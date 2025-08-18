import EventEmitter from 'events';
import type { ApiCollection, ApiResponse } from './api';
import type { EventCollection } from './event';

export class MilkyClient {
  private readonly httpApiUrl: string;
  private readonly eventUrl: string;
  private readonly wsClient: WebSocket;
  private readonly fetchHeader: Record<string, string>;
  private readonly eventEmitter: EventEmitter;

  /**
   * @param address The address of the Milky API server
   * @param port The port of the Milky API server
   * @param base The base path for the Milky API
   * @param accessToken The access token for authentication (optional)
   * @param useHttps Whether to use HTTPS (default: false)
   */
  constructor(
    address: string,
    port: number, 
    base: string, 
    private readonly accessToken?: string, 
    useHttps: boolean = false
  ) {
    base = base.endsWith('/') ? base.slice(0, -1) : base;
    this.httpApiUrl = `${useHttps ? 'https' : 'http'}://${address}:${port}${base}/api`;
    this.eventUrl = accessToken
      ? `${useHttps ? 'wss' : 'ws'}://${address}:${port}${base}/event?access_token=${accessToken}`
      : `${useHttps ? 'wss' : 'ws'}://${address}:${port}${base}/event`;
    this.fetchHeader = this.accessToken ? {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.accessToken}`,
    } : {
      'Content-Type': 'application/json',
    };
    this.wsClient = new WebSocket(this.eventUrl);
    this.eventEmitter = new EventEmitter();
    this.wsClient.addEventListener('message', (event) => {
      const data = JSON.parse(event.data);
      this.eventEmitter.emit(data.event_type, data);
    });
  }

  /**
   * Call a Milky API method.
   * @param method The API method to call
   * @param input The input parameters for the API method.
   * If the API does not require any input, you can leave it empty.
   */
  async callApi<K extends keyof ApiCollection>(
    method: K,
    ...input: Parameters<ApiCollection[K]>
  ): Promise<ReturnType<ApiCollection[K]>> {
    const response = await fetch(`${this.httpApiUrl}/${method}`, {
      method: 'POST',
      headers: this.fetchHeader,
      body: JSON.stringify(input[0] ?? {}),
    });
    const callResult = (await response.json()) as ApiResponse;
    if (callResult.status === 'failed') {
      throw new Error(`call api ${method} failed with retcode ${callResult.retcode}: ${callResult.message}`);
    }
    return callResult.data as ReturnType<ApiCollection[K]>;
  }

  /**
   * Listen for a Milky event.
   * @param eventType The event type to listen for
   * @param listener The listener function to call when the event is emitted
   */
  async onEvent<K extends keyof EventCollection>(
    eventType: K,
    listener: (data: EventCollection[K]) => void
  ): Promise<void> {
    this.eventEmitter.on(eventType, listener);
  }
}
