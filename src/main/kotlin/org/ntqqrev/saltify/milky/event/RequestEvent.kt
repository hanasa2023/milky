package org.ntqqrev.saltify.milky.event

import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val RequestEventBase = Struct {
    field("request_id", StringType, "请求 ID，用于同意 / 拒绝请求")
    field("operator_id", LongType, "发起请求的用户 QQ 号")
}

val FriendRequestEvent = RequestEventBase.extend {
    describe("好友请求")
    field("comment", StringType, "好友请求附加信息") { optional() }
    field("via", StringType, "好友请求来源") { optional() }
}

val GroupJoinRequestEvent = RequestEventBase.extend {
    describe("入群请求")
    field("group_id", LongType, "群号")
    field("comment", StringType, "入群请求附加信息") { optional() }
}

val GroupInvitedJoinRequestEvent = RequestEventBase.extend {
    describe("邀请他人入群请求")
    field("group_id", LongType, "群号")
    field("invitee_id", LongType, "被邀请者 QQ 号")
}

val GroupInvitationRequestEvent = RequestEventBase.extend {
    describe("邀请自己入群请求")
    field("group_id", LongType, "群号")
}