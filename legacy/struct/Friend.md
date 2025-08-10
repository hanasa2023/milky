# 好友 (Friend)

| 字段名   | 类型                                          | 描述                                          |
| -------- | --------------------------------------------- | --------------------------------------------- |
| user_id  | int64                                         | 用户 QQ 号                                    |
| nickname | string                                        | 用户昵称                                      |
| sex      | enum (string)                                 | 用户性别，可能值：`male`, `female`, `unknown` |
| qid      | string                                        | 用户 QID（**可选**）                          |
| remark   | string                                        | 好友备注                                      |
| category | [FriendCategory](../struct/FriendCategory.md) | 好友分组（**可选**）                          |
