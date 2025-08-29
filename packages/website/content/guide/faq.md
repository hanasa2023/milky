# Q&A

以下内容是针对一些问题的解答。未尽之处，欢迎加入 [QQ 群](https://qm.qq.com/q/C04kPQzayk)讨论相关细节。

## `message_seq` 是否相当于 OneBot 11 中的 `message_id`？

省流：`message_scene` + `peer_id` + `message_seq` = 完整版 `message_id`。

`message_seq` 不是“大号的 `message_id`”，而是一个自增的数字，表示消息在**当前会话**中的顺序，对于每个会话（好友或群聊）都是独立的。Milky 用 `message_scene`、`peer_id` 和 `message_seq` 组合来唯一标识一条消息。其中：

- `message_scene` 是一个字符串，表示消息的场景（例如：好友、群聊等）
- `peer_id` 是一个数字，表示会话的 ID。对于好友消息，`peer_id` 是好友的 QQ 号；对于群消息，`peer_id` 是群号。

OneBot 11 则使用 `message_id` 来唯一标识一条消息。

## 消息撤回（`recall`）和戳一戳（`nudge`）的事件推送中 `display_` 开头的字段指的是什么？

假如一条消息撤回的提示如下：

```
Salt 撤回了一条消息，并假装无事发生。
```

那么其对应的 `message_recall` 事件中的 `display_suffix` 字段是 `并假装无事发生。`。

假如一条戳一戳的提示如下：

```
Milk 戳了戳 Shama 的……。不许戳啦！
```

那么其对应的 `message_nudge` 事件中的 `display_action` 字段是 `戳了戳`，`display_suffix` 字段是 `的……。不许戳啦！`。

<!--
## `client_seq` 是什么？为什么在有的 API 中我必须提供它？

`client_seq` 是消息的“客户端序列号”，是 QQ 客户端（协议端）单独维护的另外一套不同于 `message_seq` 的序列号，同样是自增的，**无法通过 `message_seq` 推断或拉取**，但在**回复和撤回私聊消息**时需要用到，因此，在如下使用情景中，必须提供 `client_seq`：

- 调用 `recall_private_message` API
- 在 `send_private_message` API 中使用 `reply` 消息段

相应地，在如下 API 返回结果或事件上报中，也必须包含消息的 `client_seq`：

- 通过 `message_received` 事件上报私聊消息
- 调用 `send_private_message` API 的返回结果

以下 API 无法提供 `client_seq`：

- `get_message`
- `get_history_messages`

综上所述，应用端实现需要妥善保存私聊消息的 `client_seq`，以便在需要时使用。`client_seq` 仅在发送和接收消息时有效，无法通过其他方式获取。
-->
