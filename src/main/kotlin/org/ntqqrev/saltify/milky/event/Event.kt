package org.ntqqrev.saltify.milky.event

import org.ntqqrev.saltify.composeidl.BooleanType
import org.ntqqrev.saltify.composeidl.DiscriminatedUnion
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.UIntType
import org.ntqqrev.saltify.milky.message.IncomingMessage

val Event = DiscriminatedUnion("Event", "event_type") {
    describe("事件")

    structPlacedInto("data")

    field("time", UIntType, "事件 Unix 时间戳（秒）")

    struct("message_receive", IncomingMessage)

    struct("message_recall") {
        describe("撤回消息")
        field("message_id", StringType, "消息 ID")
        field("operator_id", LongType, "操作者 QQ 号") { optional() }
    }

    struct("friend_request", FriendRequestEvent)

    struct("group_join_request", GroupJoinRequestEvent)

    struct("group_invited_join_request", GroupInvitedJoinRequestEvent)

    struct("group_invitation_request", GroupInvitationRequestEvent)

    struct("friend_poke") {
        describe("好友戳一戳")
        field("user_id", LongType, "戳一戳发生的好友 QQ 号")
        field("is_self_send", BooleanType, "是否是自己发送的戳一戳")
        field("is_self_receive", BooleanType, "是否是自己接收的戳一戳")
    }

    struct("group_admin_change", GroupAdminChangeEvent)

    struct("group_essence_message_change", GroupEssenceMessageChangeEvent)

    struct("group_member_increase", GroupMemberIncreaseEvent)

    struct("group_member_decrease", GroupMemberDecreaseEvent)

    struct("group_name_change", GroupNameChangeEvent)

    struct("group_message_reaction", GroupMessageReactionEvent)

    struct("group_mute", GroupMuteEvent)

    struct("group_whole_mute", GroupWholeMuteEvent)

    struct("group_poke", GroupPokeEvent)
}