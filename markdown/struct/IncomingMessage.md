# 接收消息
共有字段如下：

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_id | string | 消息 ID |
| time | uint32 | 消息 Unix 时间戳（秒） |
| user_id | int64 | 发送者 QQ 号 |
| segments | Array<[IncomingSegment](../struct/IncomingSegment.md)> | 消息段列表 |
| message_type | string | 类型标识符 |

不同的 message_type 值对应不同的附加字段，具体如下：

## `private` 私聊消息

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
## `group` 群消息

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 发送者所在群号 |
## `temp` 临时消息

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 发送者所在群号 |

