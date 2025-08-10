# 接收转发消息 (IncomingForwardedMessage)

| 字段名     | 类型                                                   | 描述                   |
| ---------- | ------------------------------------------------------ | ---------------------- |
| name       | string                                                 | 发送者名称             |
| avatar_url | string                                                 | 发送者头像 URL         |
| time       | int64                                                  | 消息 Unix 时间戳（秒） |
| segments   | Array<[IncomingSegment](../struct/IncomingSegment.md)> | 消息段列表             |
