package org.ntqqrev.milky.message

import org.ntqqrev.milky.common.FriendEntity
import org.ntqqrev.milky.common.GroupEntity
import org.ntqqrev.milky.common.GroupMemberEntity
import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.DiscriminatedUnion

val IncomingMessage = DiscriminatedUnion("IncomingMessage", "message_scene") {
    describe("接收消息")

    field("peer_id", LongType, "好友 QQ 号或群号")
    field("message_seq", LongType, "消息序列号")
    field("sender_id", LongType, "发送者 QQ 号")
    field("time", LongType, "消息 Unix 时间戳（秒）")
    field("segments", Array(IncomingSegment), "消息段列表")

    struct("friend") {
        describe("好友消息")
        field("friend", FriendEntity, "好友信息")
    }

    struct("group") {
        describe("群消息")
        field("group", GroupEntity, "群信息")
        field("group_member", GroupMemberEntity, "群成员信息")
    }

    struct("temp") {
        describe("临时会话消息")
        field("group", GroupEntity, "临时会话发送者的所在的群信息") { optional() }
    }
}