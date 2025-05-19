# 消息 API

## `send_private_message` 发送私聊消息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| message | Array<[OutgoingSegment](../struct/OutgoingSegment.md)> | 消息内容 |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_seq | int64 | 消息序列号 |
| time | int64 | 消息发送时间 |
| client_seq | int64 | 消息的客户端序列号 |

## `send_group_message` 发送群消息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| message | Array<[OutgoingSegment](../struct/OutgoingSegment.md)> | 消息内容 |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_seq | int64 | 消息序列号 |
| time | int64 | 消息发送时间 |

## `get_message` 获取消息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_scene | string | 消息场景（可能值：`friend`, `group`, `temp`） |
| peer_id | int64 | 好友 QQ 号或群号 |
| message_seq | int64 | 消息序列号 |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message | [IncomingMessage](../struct/IncomingMessage.md) | 消息内容 |

## `get_history_private_message` 获取私聊消息历史

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| start_message_seq | int64 | 起始消息 ID，不提供则从最新消息开始（**可选**） |
| limit | int32 | 获取的消息数量（默认值：`20`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| messages | Array<[IncomingMessage](../struct/IncomingMessage.md)> | 消息列表 |
| next_start_message_seq | string | 下一页起始消息序列号 |

## `get_history_group_message` 获取群消息历史

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| start_message_seq | int64 | 起始消息 ID，不提供则从最新消息开始（**可选**） |
| limit | int32 | 获取的消息数量（默认值：`20`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| messages | Array<[IncomingMessage](../struct/IncomingMessage.md)> | 消息列表 |
| next_start_message_seq | string | 下一页起始消息序列号 |

## `get_resource_temp_url` 获取临时资源链接

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| resource_id | string | 资源 ID |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| url | string | 临时资源链接 |

## `get_forwarded_messages` 获取合并转发消息内容

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| forward_id | string | 转发消息 ID |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| messages | Array<[IncomingMessage](../struct/IncomingMessage.md)> | 转发消息内容 |

## `recall_private_message` 撤回私聊消息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| message_seq | int64 | 消息序列号 |
| client_seq | int64 | 客户端序列号 |

### 返回值

此 API 无返回值。
## `recall_group_message` 撤回群消息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| message_seq | int64 | 消息序列号 |

### 返回值

此 API 无返回值。
