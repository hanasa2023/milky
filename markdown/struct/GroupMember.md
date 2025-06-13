# 群成员 (GroupMember)
| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 用户 QQ 号 |
| qid | string | 用户 QID（**可选**） |
| nickname | string | 用户昵称 |
| sex | enum (string) | 用户性别，可能值：`male`, `female`, `unknown` |
| group_id | int64 | 群号 |
| card | string | 成员备注 |
| title | string | 专属头衔（**可选**） |
| level | int32 | 群等级，注意和 QQ 等级区分 |
| role | enum (string) | 权限等级，可能值：`owner`, `admin`, `member` |
| join_time | int64 | 入群时间，Unix 时间戳（秒） |
| last_sent_time | int64 | 最后发言时间，Unix 时间戳（秒） |

