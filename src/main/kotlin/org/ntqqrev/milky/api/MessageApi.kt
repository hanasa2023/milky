package org.ntqqrev.milky.api

import org.ntqqrev.saltify.composeidl.*
import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.milky.common.MessageIdentifier
import org.ntqqrev.milky.message.IncomingForwardedMessage
import org.ntqqrev.milky.message.IncomingMessage
import org.ntqqrev.milky.message.OutgoingSegment

val MessageApi = Category("message") {
    describe("消息 API")

    val sendMessageApiBase = Struct {
        field("message", Array(OutgoingSegment), "消息内容")
    }

    val sendMessageApiCommonOutput = Struct {
        field("message_seq", LongType, "消息序列号")
        field("time", LongType, "消息发送时间")
    }

    api("send_private_message") {
        describe("发送私聊消息")
        input {
            field("user_id", LongType, "好友 QQ 号")
            use(sendMessageApiBase)
        }
        output(sendMessageApiCommonOutput)
    }

    api("send_group_message") {
        describe("发送群消息")
        input {
            field("group_id", LongType, "群号")
            use(sendMessageApiBase)
        }
        output(sendMessageApiCommonOutput)
    }

    api("get_message") {
        describe("获取消息")
        input(MessageIdentifier)
        output {
            field("message", IncomingMessage, "消息内容")
        }
    }

    api("get_history_messages") {
        describe("获取历史消息")
        input {
            field("message_scene", StringType) {
                describe("消息场景")
                enum("friend", "group", "temp")
            }
            field("peer_id", LongType, "好友 QQ 号或群号")
            field("start_message_seq", LongType) {
                describe("起始消息序列号，不提供则从最新消息开始")
                optional()
            }
            field("direction", StringType) {
                describe("消息获取方向")
                enum("newer", "older")
            }
            field("limit", IntType, "获取的最大消息数量") { default("20") }
        }
        output {
            field("messages", Array(IncomingMessage)) {
                describe("获取到的消息，部分消息可能不存在，如撤回的消息")
            }
        }
    }

    api("get_resource_temp_url") {
        describe("获取临时资源链接")
        input {
            field("resource_id", StringType, "资源 ID")
        }
        output {
            field("url", StringType, "临时资源链接")
        }
    }

    api("get_forwarded_messages") {
        describe("获取合并转发消息内容")
        input {
            field("forward_id", StringType, "转发消息 ID")
        }
        output {
            field("messages", Array(IncomingForwardedMessage), "转发消息内容")
        }
    }

    api("recall_private_message") {
        describe("撤回私聊消息")
        input {
            field("user_id", LongType, "好友 QQ 号")
            field("message_seq", LongType, "消息序列号")
        }
    }

    api("recall_group_message") {
        describe("撤回群消息")
        input {
            field("group_id", LongType, "群号")
            field("message_seq", LongType, "消息序列号")
        }
    }
}