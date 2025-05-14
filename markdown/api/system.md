# 系统 API

## `get_login_info` 获取登录信息

### 参数

此 API 无输入参数。
### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| uin | int64 | 登录 QQ 号 |
| nickname | string | 登录昵称 |

## `get_friend_list` 获取好友列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| friends | Array<[Friend](../struct/Friend.md)> | 好友列表 |

## `get_friend_info` 获取好友信息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

见 [Friend](../struct/Friend.md)

## `get_group_list` 获取群列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| groups | Array<[Group](../struct/Group.md)> | 群列表 |

## `get_group_info` 获取群信息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

见 [Group](../struct/Group.md)

## `get_group_member_list` 获取群成员列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| members | Array<[GroupMember](../struct/GroupMember.md)> | 群成员列表 |

## `get_group_member_info` 获取群成员信息

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| user_id | int64 | 群成员 QQ 号 |
| no_cache | boolean | 是否强制不使用缓存（默认值：`false`） |

### 返回值

见 [GroupMember](../struct/GroupMember.md)

