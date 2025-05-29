package org.ntqqrev.milky.event

import org.ntqqrev.milky.common.MessageIdentifier
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.Struct

val MessageRecallEvent = Struct {
    describe("撤回消息")
    use(MessageIdentifier)
    field("sender_id", LongType, "被撤回的消息的发送者 QQ 号")
    field("operator_id", LongType, "操作者 QQ 号")
}