# 接收消息
| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_scene | string | 消息场景（可能值：`friend`, `group`, `temp`） |
| peer_id | int64 | 好友 QQ 号或群号 |
| message_seq | int64 | 消息序列号 |
| sender_id | int64 | 发送者 QQ 号 |
| time | int64 | 消息 Unix 时间戳（秒） |
| segments | Array<[IncomingSegment](../struct/IncomingSegment.md)> | 消息段列表 |
| client_seq | int64 | 私聊消息的客户端序列号（**可选**） |

