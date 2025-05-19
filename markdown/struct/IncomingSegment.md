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
## `mention` 提及（@）消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 提及的 QQ 号 |
## `mention_all` 提及全体（@全体成员）消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
## `face` 表情消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| face_id | string | 表情 ID |
## `reply` 回复消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_seq | int64 | 被引用的消息序列号 |
## `image` 图片消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| resource_id | string | 资源 ID |
| summary | string | 图片预览文本（**可选**） |
| sub_type | string | 图片类型（可能值：`normal`, `sticker`） |
## `record` 语音消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| resource_id | string | 资源 ID |
| duration | int32 | 语音时长（秒） |
## `video` 视频消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| resource_id | string | 资源 ID |
## `forward` 合并转发消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| forward_id | string | 合并转发 ID |
## `market_face` 市场表情消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| url | string | 市场表情 URL |
## `light_app` 小程序消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| app_name | string | 小程序名称 |
| json_payload | string | 小程序 JSON 数据 |
## `xml` XML 消息段

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| service_id | int32 | 服务 ID |
| xml_payload | string | XML 数据 |

