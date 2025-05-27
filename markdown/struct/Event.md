# 事件
共有字段如下：

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| time | int64 | 事件 Unix 时间戳（秒） |
| self_id | int64 | 机器人 QQ 号 |
| event_type | string | 类型标识符 |
| data | struct | 结构体 |

不同的 event_type 值对应不同的 data，具体如下：

## `message_receive` 接收消息

见 [IncomingMessage](../struct/IncomingMessage.md)

## `message_recall` 撤回消息

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_scene | enum (string) | 消息场景，可能值：`friend`, `group`, `temp` |
| peer_id | int64 | 好友 QQ 号或群号 |
| message_seq | int64 | 消息序列号 |
| sender_id | int64 | 被撤回的消息的发送者 QQ 号 |
| operator_id | int64 | 操作者 QQ 号 |
## `friend_request` 好友请求

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID，用于同意 / 拒绝请求 |
| operator_id | int64 | 发起请求的用户 QQ 号 |
| comment | string | 好友请求附加信息（**可选**） |
| via | string | 好友请求来源（**可选**） |
## `group_join_request` 入群请求

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID，用于同意 / 拒绝请求 |
| operator_id | int64 | 发起请求的用户 QQ 号 |
| group_id | int64 | 群号 |
| comment | string | 入群请求附加信息（**可选**） |
## `group_invited_join_request` 邀请他人入群请求

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID，用于同意 / 拒绝请求 |
| operator_id | int64 | 发起请求的用户 QQ 号 |
| group_id | int64 | 群号 |
| invitee_id | int64 | 被邀请者 QQ 号 |
## `group_invitation_request` 邀请自己入群请求

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID，用于同意 / 拒绝请求 |
| operator_id | int64 | 发起请求的用户 QQ 号 |
| group_id | int64 | 群号 |
## `friend_nudge` 好友戳一戳

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| is_self_send | boolean | 是否是自己发送的戳一戳 |
| is_self_receive | boolean | 是否是自己接收的戳一戳 |
## `friend_file_upload` 好友文件上传

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| file_id | string | 文件 ID |
| file_name | string | 文件名称 |
| file_size | int64 | 文件大小 |
| is_self | boolean | 是否是自己发送的文件 |
## `group_admin_change` 群管理员变更

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 发生变更的用户 QQ 号 |
| is_set | boolean | 是否被设置为管理员，`false` 表示被取消管理员 |
## `group_essence_message_change` 群精华消息变更

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| message_seq | int64 | 发生变更的消息序列号 |
| is_set | boolean | 是否被设置为精华，`false` 表示被取消精华 |
## `group_member_increase` 群成员增加

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 发生变更的用户 QQ 号 |
| operator_id | int64 | 管理员 QQ 号，如果是管理员同意入群（**可选**） |
| invitor_id | int64 | 邀请者 QQ 号，如果是邀请入群（**可选**） |
## `group_member_decrease` 群成员减少

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 发生变更的用户 QQ 号 |
| operator_id | int64 | 管理员 QQ 号，如果是管理员踢出（**可选**） |
## `group_name_change` 群名称变更

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| name | string | 新的群名称 |
| operator_id | int64 | 操作者 QQ 号 |
## `group_message_reaction` 群消息表情回应

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 发送回应者 QQ 号 |
| message_seq | int64 | 消息序列号 |
| face_id | string | 表情 ID |
| is_add | boolean | 是否为添加，`false` 表示取消回应（**可选**） |
## `group_mute` 群成员禁言状态变更

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 发生变更的用户 QQ 号 |
| operator_id | int64 | 操作者 QQ 号 |
| duration | int32 | 禁言时长（秒），为 0 表示取消禁言 |
## `group_whole_mute` 群全员禁言状态变更

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| operator_id | int64 | 操作者 QQ 号 |
| is_mute | boolean | 是否全员禁言，`false` 表示取消全员禁言 |
## `group_nudge` 群戳一戳

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| sender_id | int64 | 发送者 QQ 号 |
| receiver_id | int64 | 接收者 QQ 号 |
## `group_file_upload` 群文件上传

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 发送者 QQ 号 |
| file_id | string | 文件 ID |
| file_name | string | 文件名称 |
| file_size | int64 | 文件大小 |

