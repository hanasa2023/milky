# 系统 API

## `get_login_info` 获取登录信息

### 参数

此 API 无输入参数。
### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| uin | int64 | 登录 QQ 号 |
| nickname | string | 登录昵称 |

## `get_impl_info` 获取协议端信息

### 参数

此 API 无输入参数。
### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| impl_name | string | 协议端名称 |
| impl_version | string | 协议端版本 |
| qq_version | string | 协议端使用的 QQ 协议版本 |
| milky_version | string | 协议端实现的 Milky 协议版本，目前为 `1.0` |

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

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| friend | [Friend](../struct/Friend.md) | 好友信息 |

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

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group | [Group](../struct/Group.md) | 群信息 |

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

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| member | [GroupMember](../struct/GroupMember.md) | 群成员信息 |

