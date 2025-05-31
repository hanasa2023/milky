package org.ntqqrev.milky.common

import org.ntqqrev.saltify.composeidl.BooleanType
import org.ntqqrev.saltify.composeidl.DiscriminatedUnion
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val RequestBase = Struct {
    field("request_id", StringType, "请求 ID，用于同意 / 拒绝请求")
    field("time", LongType, "请求发起时的 Unix 时间戳（秒）")
    field("is_filtered", BooleanType, "请求是否被过滤（发起自风险账户）")
    field("initiator_id", LongType, "发起请求的用户 QQ 号")
    field("state", StringType, "请求状态") {
        describe("请求状态")
        enum("pending", "accepted", "rejected", "ignored")
    }
}

val FriendRequest = Struct("FriendRequest") {
    describe("好友请求")
    use(RequestBase)
    field("comment", StringType, "好友请求附加信息") { optional() }
    field("via", StringType, "好友请求来源") { optional() }
}

val GroupRequest = DiscriminatedUnion("GroupRequest", "request_type") {
    describe("入群请求")
    use(RequestBase)
    field("group_id", LongType, "群号")
    field("operator_id", LongType, "处理请求的用户 QQ 号") { optional() }

    struct("join") {
        describe("自主申请入群请求")
        field("comment", StringType, "入群请求附加信息") { optional() }
    }

    struct("invite") {
        describe("他人邀请入群请求")
        field("invitee_id", LongType, "被邀请者 QQ 号")
    }
}

val GroupInvitation = Struct("GroupInvitation") {
    describe("他人邀请 Bot 入群请求")
    use(RequestBase)
    field("group_id", LongType, "群号")
}