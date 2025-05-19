package org.ntqqrev.milky.message

import org.ntqqrev.saltify.composeidl.*
import org.ntqqrev.saltify.composeidl.Array

val IncomingForwardedMessage = Struct("IncomingForwardedMessage") {
    describe("接收转发消息")
    field("user_id", LongType, "发送者 QQ 号")
    field("name", StringType, "发送者名称")
    field("segments", Array(IncomingSegment), "消息段列表")
}

val OutgoingForwardedMessage = Struct("OutgoingForwardedMessage") {
    describe("发送转发消息")
    field("user_id", LongType, "发送者 QQ 号")
    field("name", StringType, "发送者名称")
    field("segments", Array(TypeReference("OutgoingSegment")), "消息段列表")
}