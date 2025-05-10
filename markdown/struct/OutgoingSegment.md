# 接收消息段
共有字段如下：

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| type | string | 类型标识符 |
| data | struct | 结构体 |

不同的 type 值对应不同的 data，具体如下：

## `text` 文本消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| text | string | 文本内容 |
## `at` 提及（@）消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 提及的 QQ 号 |
## `face` 表情消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| face_id | string | 表情 ID |
## `reply` 回复消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_id | int64 | 被引用的消息 ID |
## `image` 图片消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| uri | string | 文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式 |
| summary | string | 图片预览文本（**可选**） |
| sub_type | string | 图片类型（可能值：`normal`, `sticker`） |
## `record` 语音消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| uri | string | 文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式 |
## `video` 视频消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| uri | string | 文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式 |
| thumb_uri | string | 封面图片 URI（**可选**） |
## `forward` 合并转发消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| messages | Array<[OutgoingForwardedMessage](../struct/OutgoingForwardedMessage.md)> | 合并转发 ID |

