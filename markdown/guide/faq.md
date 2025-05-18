# Q&A

以下内容是针对一些问题的解答。

## `message_seq` 是否相当于 OneBot 11 标准中的 `message_id`？

省流：`message_scene` + `peer_id` + `message_seq` = 完整版 `message_id`。

`message_seq` 不是“大号的 `message_id`”，而是一个自增的数字，表示消息在**当前会话**中的顺序，对于每个会话（好友或群聊）都是独立的。Milky 用 `message_scene`、`peer_id` 和 `message_seq` 组合来唯一标识一条消息。`message_scene` 是一个字符串，表示消息的场景（例如：好友、群聊等），`peer_id` 是一个数字，表示发送者的 ID。OneBot 11 则使用 `message_id` 来唯一标识一条消息。
