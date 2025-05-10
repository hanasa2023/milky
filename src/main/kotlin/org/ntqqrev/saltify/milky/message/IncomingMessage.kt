package org.ntqqrev.saltify.milky.message

import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.saltify.composeidl.DiscriminatedUnion
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.UIntType

val IncomingMessage = DiscriminatedUnion("IncomingMessage", "message_type") {
    field("message_id", StringType, "消息 ID")
    field("time", UIntType, "消息 Unix 时间戳（秒）")
    field("user_id", LongType, "发送者 QQ 号")
    field("segments", Array(IncomingSegment), "消息段列表")

    struct("private") {
        describe("私聊消息")
    }

    struct("group") {
        describe("群消息")
        field("group_id", LongType, "发送者所在群号")
    }

    struct("temp") {
        describe("临时消息")
        field("group_id", LongType, "发送者所在群号")
    }
}