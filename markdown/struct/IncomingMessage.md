# 接收消息
共有字段如下：

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| peer_id | int64 | 好友 QQ 号或群号 |
| message_seq | int64 | 消息序列号 |
| sender_id | int64 | 发送者 QQ 号 |
| time | int64 | 消息 Unix 时间戳（秒） |
| segments | Array<[IncomingSegment](../struct/IncomingSegment.md)> | 消息段列表 |
| message_scene | string | 类型标识符 |

不同的 message_scene 值对应不同的附加字段，具体如下：

## `friend` 好友消息

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| friend | [Friend](../struct/Friend.md) | 好友信息 |
| client_seq | int64 | 客户端序列号 |
## `group` 群消息

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group | [Group](../struct/Group.md) | 群信息 |
| group_member | [GroupMember](../struct/GroupMember.md) | 群成员信息 |
## `temp` 临时会话消息

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group | [Group](../struct/Group.md) | 临时会话发送者的所在的群信息（**可选**） |

