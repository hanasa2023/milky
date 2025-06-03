package org.ntqqrev.milky.event

import org.ntqqrev.milky.common.FriendRequest
import org.ntqqrev.milky.common.GroupInvitation
import org.ntqqrev.milky.common.GroupRequest
import org.ntqqrev.saltify.composeidl.DiscriminatedUnion
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.milky.message.IncomingMessage

val Event = DiscriminatedUnion("Event", "event_type") {
    describe("事件")

    structPlacedInto("data")

    field("time", LongType, "事件 Unix 时间戳（秒）")
    field("self_id", LongType, "机器人 QQ 号")

    struct("bot_offline", BotOfflineEvent)

    struct("message_receive", IncomingMessage)
    struct("message_recall", MessageRecallEvent)

    struct("friend_request", FriendRequest)
    struct("group_request", GroupRequest)
    struct("group_invitation", GroupInvitation)

    struct("friend_nudge", FriendNudgeEvent)
    struct("friend_file_upload", FriendFileUploadEvent)

    struct("group_admin_change", GroupAdminChangeEvent)
    struct("group_essence_message_change", GroupEssenceMessageChangeEvent)
    struct("group_member_increase", GroupMemberIncreaseEvent)
    struct("group_member_decrease", GroupMemberDecreaseEvent)
    struct("group_name_change", GroupNameChangeEvent)
    struct("group_message_reaction", GroupMessageReactionEvent)
    struct("group_mute", GroupMuteEvent)
    struct("group_whole_mute", GroupWholeMuteEvent)
    struct("group_nudge", GroupNudgeEvent)
    struct("group_file_upload", GroupFileUploadEvent)
}