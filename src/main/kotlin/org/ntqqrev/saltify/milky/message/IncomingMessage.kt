package org.ntqqrev.saltify.milky.message

import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.Struct
import org.ntqqrev.saltify.composeidl.UIntType
import org.ntqqrev.saltify.milky.common.MessageIdentifier

val IncomingMessage = Struct("IncomingMessage") {
    describe("接收消息")

    use(MessageIdentifier)
    field("sender_id", LongType, "发送者 QQ 号")
    field("time", UIntType, "消息 Unix 时间戳（秒）")
    field("segments", Array(IncomingSegment), "消息段列表")
}