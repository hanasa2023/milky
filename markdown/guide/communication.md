# 通信

Milky 的协议端实现需要开启一个 HTTP 服务器，在不同的端点提供两种网络服务：
- `/api` 端点，提供 API 调用服务，应用端向协议端发起请求，协议端继而完成响应操作；
- `/event` 端点，提供事件推送服务，协议端向应用端主动推送事件。

同时，如果用户配置了 WebHook 地址，协议端还会向配置的地址推送事件。可以给定多个 WebHook 地址。

所有服务传输的数据都应当使用 UTF-8 编码。

## API 调用

接受路径为 `/api/:api` 的 API 请求。请求使用 POST 方法，在请求体中通过 JSON 传递参数。为保证安全性，可以在配置文件中设置 `access_token`，协议端需要在请求头中检查 `Authorization` 字段，格式为 `Bearer {access_token}`。

示例如下：

```http
POST /api/send_private_message
Content-Type: application/json
Authorization: Bearer 123456

{
  "user_id": 123456789,
  "message": [
    {
      "type": "text",
      "data": {
        "text": "Hello, world!"
      }
    }
  ]
}
```

注意，即使请求的 API 无输入参数，也必须传入一个空的 JSON 对象 `{}`，例如：

```http
POST /api/get_login_info
Content-Type: application/json
Authorization: Bearer 123456

{}
```

收到 API 请求并处理后，协议端会返回一个 HTTP 响应，根据具体错误类型不同，HTTP 状态码不同：

- `401`：鉴权凭据未提供或不匹配。
- `404`：请求的 API 不存在。
- `415`：POST 请求的 Content-Type 不支持。

剩下的所有情况，无论操作实际成功与否，状态码**都是 `200`**，同时返回 JSON 格式的响应，示例如下：

```jsonc
// 成功响应示例
{
  "status": "ok",
  "retcode": 0, // 成功时的 retcode 为 0
  "data": {
    "message_seq": 23333,
    "time": 1234567890
  }
}
```

```jsonc
// 失败响应示例 1
{
  "status": "failed",
  "retcode": -400, // 参数解析失败时，retcode 为 -400
  "message": "user_id (-1) 不是一个合法的 QQ 号"
}
```

```jsonc
// 失败响应示例 2
{
  "status": "failed",
  "retcode": -404, // 其余错误情况的 retcode 由协议端自行决定
  "message": "user_id 对应的好友不存在"
}
```

## 事件推送

事件推送服务支持两种方式：WebSocket 和 WebHook。

### WebSocket 连接

接受路径为 `/event` 的 WebSocket 连接请求，在建立连接后推送事件。为保证安全性，可以在配置文件中设置 `access_token`，协议端需要检查连接时的 `query` 参数 `access_token`，如果不匹配则拒绝连接。

例如，如果 `access_token` 配置为 `123456`，则连接 URL 为

```
ws://{IP}:{端口}/event?access_token=123456
```

产生事件时，协议端会推送一条 JSON 格式的消息，格式见 [Event](../struct/Event.md)。示例如下：

```json
{
  "time": 1234567890,
  "self_id": 123456789,
  "event_type": "message_receive",
  "data": {
    "message_scene": "friend",
    "peer_id": 123456789,
    "message_seq": 23333,
    "sender_id": 123456789,
    "time": 1234567890,
    "message": [
      {
        "type": "text",
        "data": {
          "text": "Hello, world!"
        }
      }
    ]
  }
}
```

### WebHook 推送

以 POST 方式向给定的 WebHook 地址推送事件。POST 请求的 body 与 WebSocket 推送的格式相同。示例如下：

```http
POST http://example.com/webhook
Content-Type: application/json

{
  "time": 1234567890,
  "self_id": 123456789,
  "event_type": "message_receive",
  "data": {
    "message_scene": "friend",
    "peer_id": 123456789,
    "message_seq": 23333,
    "sender_id": 123456789,
    "time": 1234567890,
    "message": [
      {
        "type": "text",
        "data": {
          "text": "Hello, world!"
        }
      }
    ]
  }
}
```