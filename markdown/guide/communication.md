# 通信

Milky 的协议端实现应当支持以下四种通信方式：

- **HTTP Server**：协议端开启一个 HTTP 服务器，提供 API 调用服务。
- **WebHook**：协议端作为 HTTP 客户端，向用户配置的 URL 推送事件，并处理用户返回的响应。
- **WebSocket 服务端**：协议端开启一个 WebSocket 服务端，接受用户连接，提供 API 调用和事件推送服务。
- **WebSocket 客户端**：协议端作为 WebSocket 客户端，主动连接用户配置的 URL，提供 API 调用和事件推送服务。

所有通信方式传输的数据都使用 UTF-8 编码。

## HTTP Server

协议端开启一个 HTTP 服务器，监听指定的 IP 和端口，接受路径为 `/:api` 的 API 请求。请求使用 POST 方法，在请求体中通过 JSON 传递参数。为保证安全性，可以在配置文件中设置 `access_token`，协议端需要在请求头中检查 `Authorization` 字段，格式为 `Bearer {access_token}`。

示例如下：

```http
POST /send_private_message
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

收到 API 请求并处理后，协议端会返回一个 HTTP 响应，根据具体错误类型不同，HTTP 状态码不同：

- `401`：鉴权凭据未提供。
- `403`：鉴权凭据不匹配。
- `406`：POST 请求的 Content-Type 不支持。
- `400`：参数格式不正确。
- `404`：请求的 API 不存在。

剩下的所有情况，无论操作实际成功与否，状态码都是 `200`，同时返回 JSON 格式的响应，示例如下：

```json
// 成功响应示例
{
  "status": "ok",
  "retcode": 0, // 成功时的 retcode 为 0
  "data": {
    "message_id": "Private:123456789:23333",
    "time": 1234567890
  }
}
```

```json
// 失败响应示例
{
  "status": "failed",
  "retcode": -100, // 失败时的 retcode 为非 0
  "message": "user_id 对应的好友不存在"
}
```

## WebHook

协议端产生事件后，向配置指定的事件上报 URL 通过 POST 请求发送事件数据，事件数据以 JSON 格式表示。每个 POST 请求都会携带 `X-Self-ID` 的请求头，内容是 Bot 自身的 QQ 号。为保证安全性，可以在配置文件中设置 `access_token`，协议端需要在请求头中加入 `Authorization` 字段，格式为 `Bearer {access_token}`。

示例如下：

```http
POST /webhook-endpoint
Content-Type: application/json
Authorization: Bearer 123456
X-Self-ID: 123456789

{
  "time": 1234567890,
  "event_type": "message_receive",
  "data": {
    "message_id": "Private:123456789:23333",
    "time": 1234567890,
    "user_id": 123456789,
    "segments": [
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

## WebSocket 服务端

协议端开启一个 WebSocket 服务器，监听配置文件指定的 IP 和端口，接受路径为 `/` 的用户连接，响应 API 请求**并且**推送事件。为保证安全性，可以在配置文件中设置 `access_token`，协议端需要检查连接时的 `query` 参数 `access_token`，如果不匹配则拒绝连接。

例如，如果 `access_token` 配置为 `123456`，则连接 URL 为

```
ws://{IP}:{端口}/?access_token=123456
```

客户端发送 API 请求时，采取以下格式：

```json
{
  "action": "send_private_message",
  "params": {
    "user_id": 123456789,
    "message": [
      {
        "type": "text",
        "data": {
          "text": "Hello, world!"
        }
      }
    ],
  },
  "echo": "123456" // 可选，回调 ID，用于区分不同的请求
}
```

处理 API 请求后，协议端会推送一条 JSON 格式的消息，示例如下：

```json
{
  "post_type": "action_response",
  "self_id": 123456789,
  "data": {
    // data 字段的格式与 HTTP Server 的响应一致（除 echo 字段外）
    "status": "ok",
    "retcode": 0,
    "data": {
      "message_id": "Private:123456789:23333",
      "time": 1234567890
    },
    "echo": "123456" // 请求时提供的回调 ID，若未提供则不包含此字段
  }
}
```

产生事件时，协议端会推送一条 JSON 格式的消息，示例如下：

```json
{
  "post_type": "event",
  "self_id": 123456789,
  "data": {
    // data 字段的格式与 WebHook 的事件数据一致
    "time": 1234567890,
    "event_type": "message_receive",
    "data": {
      "message_id": "Private:123456789:23333",
      "time": 1234567890,
      "user_id": 123456789,
      "segments": [
        {
          "type": "text",
          "data": {
            "text": "Hello, world!"
          }
        }
      ]
    }
  }
}
```

## WebSocket 客户端

协议端作为 WebSocket 客户端，主动连接用户配置的 URL，响应 API 请求**并且**推送事件。为保证安全性，可以在配置文件中设置 `access_token`，协议端需要在连接时的 `query` 参数中包含 `access_token`。

API 请求和事件推送的格式与 [WebSocket 服务端](#websocket-服务端)一致。
