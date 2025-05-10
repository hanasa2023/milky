# 系统 API

## `get_friend_list` 获取好友列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

返回值为数组，元素类型如下：

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| qid | string | 好友 QID（**可选**） |
| nickname | string | 好友昵称 |
| remark | string | 好友备注 |
| category | [FriendCategory](../struct/FriendCategory.md) | 好友分组（**可选**） |

## `get_friend_info` 获取好友信息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | uint32 | 好友 QQ 号 |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| qid | string | 好友 QID（**可选**） |
| nickname | string | 好友昵称 |
| remark | string | 好友备注 |
| category | [FriendCategory](../struct/FriendCategory.md) | 好友分组（**可选**） |

## `get_group_list` 获取群列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

返回值为数组，元素类型如下：

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | uint32 | 群号 |
| name | string | 群名称 |
| member_count | int32 | 群成员数量 |
| max_member_count | int32 | 群容量 |

## `get_group_info` 获取群信息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | uint32 | 群号 |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | uint32 | 群号 |
| name | string | 群名称 |
| member_count | int32 | 群成员数量 |
| max_member_count | int32 | 群容量 |

## `get_group_member_list` 获取群成员列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | uint32 | 群号 |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

返回值为数组，元素类型如下：

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | uint32 | 群号 |
| user_id | uint32 | 成员 QQ 号 |
| nickname | string | 成员昵称 |
| card | string | 成员备注 |
| title | string | 专属头衔（**可选**） |
| sex | string | 性别（可能值：`male`, `female`, `unknown`） |
| level | int32 | 群等级，注意和 QQ 等级区分 |
| role | string | 权限等级（可能值：`owner`, `admin`, `member`） |
| join_time | int64 | 入群时间，Unix 时间戳（秒） |
| last_sent_time | int64 | 最后发言时间，Unix 时间戳（秒） |

## `get_group_member_info` 获取群成员信息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | uint32 | 群号 |
| user_id | uint32 | 群成员 QQ 号 |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | uint32 | 群号 |
| user_id | uint32 | 成员 QQ 号 |
| nickname | string | 成员昵称 |
| card | string | 成员备注 |
| title | string | 专属头衔（**可选**） |
| sex | string | 性别（可能值：`male`, `female`, `unknown`） |
| level | int32 | 群等级，注意和 QQ 等级区分 |
| role | string | 权限等级（可能值：`owner`, `admin`, `member`） |
| join_time | int64 | 入群时间，Unix 时间戳（秒） |
| last_sent_time | int64 | 最后发言时间，Unix 时间戳（秒） |

