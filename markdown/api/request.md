# 请求 API

## `get_friend_requests` 获取好友请求列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| limit | int32 | 获取的最大请求数量（默认值：`20`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| requests | Array<[FriendRequest](../struct/FriendRequest.md)> | 好友请求列表 |

## `get_group_requests` 获取群请求列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| limit | int32 | 获取的最大请求数量（默认值：`20`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| requests | Array<[GroupRequest](../struct/GroupRequest.md)> | 群请求列表 |

## `get_group_invitations` 获取群邀请列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| limit | int32 | 获取的最大邀请数量（默认值：`20`） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| invitations | Array<[GroupInvitation](../struct/GroupInvitation.md)> | 群邀请列表 |

## `accept_friend_request` 同意好友请求

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID |

### 返回值

此 API 无返回值。
## `reject_friend_request` 拒绝好友请求

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID |
| reason | string | 拒绝理由（**可选**） |

### 返回值

此 API 无返回值。
## `accept_group_request` 同意群请求

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID |

### 返回值

此 API 无返回值。
## `reject_group_request` 拒绝群请求

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID |
| reason | string | 拒绝理由（**可选**） |

### 返回值

此 API 无返回值。
## `accept_group_invitation` 同意群邀请

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID |

### 返回值

此 API 无返回值。
## `reject_group_invitation` 拒绝群邀请

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID |

### 返回值

此 API 无返回值。
