# 入群请求
共有字段如下：

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| request_id | string | 请求 ID，用于同意 / 拒绝请求 |
| time | int64 | 请求发起时的 Unix 时间戳（秒） |
| is_filtered | boolean | 请求是否被过滤（发起自风险账户） |
| initiator_id | int64 | 发起请求的用户 QQ 号 |
| state | enum (string) | 请求状态，可能值：`pending`, `accepted`, `rejected`, `ignored` |
| group_id | int64 | 群号 |
| operator_id | int64 | 处理请求的用户 QQ 号（**可选**） |
| request_type | string | 类型标识符 |

不同的 request_type 值对应不同的附加字段，具体如下：

## `join` 自主申请入群请求

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| comment | string | 入群请求附加信息（**可选**） |
## `invite` 他人邀请入群请求

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| invitee_id | int64 | 被邀请者 QQ 号 |

