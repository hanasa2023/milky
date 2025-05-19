package org.ntqqrev.milky.common

import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val MessageIdentifier = Struct("MessageIdentifier") {
    field("message_scene", StringType) {
        describe("消息场景")
        enum("friend", "group", "temp")
    }
    field("peer_id", LongType, "好友 QQ 号或群号")
    field("message_seq", LongType, "消息序列号")
}