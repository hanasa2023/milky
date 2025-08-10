# 他人邀请 Bot 入群请求 (GroupInvitation)

| 字段名       | 类型          | 描述                                                           |
| ------------ | ------------- | -------------------------------------------------------------- |
| request_id   | string        | 请求 ID，用于同意 / 拒绝请求                                   |
| time         | int64         | 请求发起时的 Unix 时间戳（秒）                                 |
| is_filtered  | boolean       | 请求是否被过滤（发起自风险账户）                               |
| initiator_id | int64         | 发起请求的用户 QQ 号                                           |
| state        | enum (string) | 请求状态，可能值：`pending`, `accepted`, `rejected`, `ignored` |
| group_id     | int64         | 群号                                                           |
