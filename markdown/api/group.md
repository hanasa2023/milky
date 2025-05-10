# 群聊 API

## `set_group_name` 设置群名称

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| name | string | 新群名称 |

### 返回值

此 API 无返回值。
## `set_group_avatar` 设置群头像

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| image_uri | string | 图像文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式 |

### 返回值

此 API 无返回值。
## `set_group_member_card` 设置群名片

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 被设置的群成员 QQ 号 |
| card | string | 新群名片 |

### 返回值

此 API 无返回值。
## `set_group_member_special_title` 设置群成员专属头衔

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 被设置的群成员 QQ 号 |
| special_title | string | 新专属头衔 |
| duration | int64 | 专属头衔持续时间，单位：秒（默认值：`0`） |

### 返回值

此 API 无返回值。
## `set_group_member_admin` 设置群管理员

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 被设置的 QQ 号 |
| is_set | int64 | 是否设置为管理员，`false` 为取消管理员（默认值：`true`） |

### 返回值

此 API 无返回值。
## `set_group_member_mute` 设置群成员禁言

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 被设置的 QQ 号 |
| duration | int64 | 禁言持续时间（秒），设为 `0` 为取消禁言（默认值：`0`） |

### 返回值

此 API 无返回值。
## `set_group_whole_mute` 设置群全员禁言

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| is_mute | boolean | 是否开启全员禁言，`false` 为取消全员禁言（默认值：`true`） |

### 返回值

此 API 无返回值。
## `kick_group_member` 踢出群成员

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 被踢的 QQ 号 |
| reject_add_request | boolean | 是否拒绝加群申请，`false` 为不拒绝（默认值：`true`） |

### 返回值

此 API 无返回值。
## `get_group_announcement_list` 获取群公告列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| announcements | Array<[GroupAnnouncement](../struct/GroupAnnouncement.md)> | 群公告列表 |

## `send_group_announcement` 发送群公告

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| content | string | 公告内容 |
| image_uri | string | 图像文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式 |

### 返回值

此 API 无返回值。
## `delete_group_announcement` 删除群公告

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| announcement_id | int64 | 公告 ID |

### 返回值

此 API 无返回值。
## `quit_group` 退出群

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |

### 返回值

此 API 无返回值。
## `send_group_message_reaction` 发送群消息表情

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| message_id | string | 消息 ID |
| reaction | string | 表情 ID |

### 返回值

此 API 无返回值。
## `send_group_poke` 发送群戳一戳

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 被戳的群成员 QQ 号 |

### 返回值

此 API 无返回值。
