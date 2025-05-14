package org.ntqqrev.saltify.milky.event

import org.ntqqrev.saltify.composeidl.BooleanType
import org.ntqqrev.saltify.composeidl.DiscriminatedUnion
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.UIntType
import org.ntqqrev.saltify.milky.common.MessageIdentifier
import org.ntqqrev.saltify.milky.message.IncomingMessage

val Event = DiscriminatedUnion("Event", "event_type") {
    describe("事件")

    structPlacedInto("data")

    field("time", UIntType, "事件 Unix 时间戳（秒）")

    struct("message_receive", IncomingMessage)

    struct("message_recall") {
        describe("撤回消息")
        use(MessageIdentifier)
        field("operator_id", LongType, "操作者 QQ 号") { optional() }
    }

    struct("friend_request", FriendRequestEvent)

    struct("group_join_request", GroupJoinRequestEvent)

    struct("group_invited_join_request", GroupInvitedJoinRequestEvent)

    struct("group_invitation_request", GroupInvitationRequestEvent)

    struct("friend_poke", FriendPokeEvent)

    struct("friend_file_upload", FriendFileUploadEvent)

    struct("group_admin_change", GroupAdminChangeEvent)

    struct("group_essence_message_change", GroupEssenceMessageChangeEvent)

    struct("group_member_increase", GroupMemberIncreaseEvent)

    struct("group_member_decrease", GroupMemberDecreaseEvent)

    struct("group_name_change", GroupNameChangeEvent)

    struct("group_message_reaction", GroupMessageReactionEvent)

    struct("group_mute", GroupMuteEvent)

    struct("group_whole_mute", GroupWholeMuteEvent)

    struct("group_poke", GroupPokeEvent)

    struct("group_file_upload", GroupFileUploadEvent)
}