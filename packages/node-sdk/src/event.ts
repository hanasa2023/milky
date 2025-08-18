import type { Event } from '@saltify/milky-types';

export type EventCollection = {
    [K in Event['event_type']]: Extract<Event, { event_type: K }>
}