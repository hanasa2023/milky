package org.ntqqrev.saltify.milky.message

import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.saltify.composeidl.TypeReference
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val IncomingForwardedMessage = Struct("ForwardedMessage") {
    describe("转发消息")
    field("user_id", LongType, "发送者 QQ 号")
    field("name", StringType, "发送者名称")
    field("segments", Array(IncomingSegment), "消息段列表")
}

val OutgoingForwardedMessage = Struct("OutgoingForwardedMessage") {
    describe("转发消息")
    field("user_id", LongType, "发送者 QQ 号")
    field("name", StringType, "发送者名称")
    field("segments", Array(TypeReference("OutgoingSegment")), "消息段列表")
}