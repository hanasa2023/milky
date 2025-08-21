# Milky Node SDK

这是 Milky 协议的 Node.js SDK，提供 TypeScript 支持。

源码中使用了 Node.js 的 WebSocket API，因此需要 Node 版本高于 22。如果必须在低于 22 的版本中使用，请在启动时加入 `--experimental-websocket` 这一 Flag。

## 初始化

```typescript
import { MilkyClient } from '@saltify/milky-node-sdk';

const client = new MilkyClient('localhost', 3000, '/', 'your-access-token');
```

## 调用 API

```typescript
const response = await client.callApi('get_group_info', {
  group_id: 123456789
});
```

## 监听事件

```typescript
client.on('message_receive', (event) => {
  console.log('Received event:', event);
});
```