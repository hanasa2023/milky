package org.ntqqrev.saltify.milky.event

import org.ntqqrev.saltify.composeidl.BooleanType
import org.ntqqrev.saltify.composeidl.IntType
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val GroupEventBase = Struct {
    field("group_id", LongType, "群号")
}

val GroupAdminChangeEvent = GroupEventBase.extend {
    describe("群管理员变更")
    field("user_id", LongType, "发生变更的用户 QQ 号")
    field("is_set", BooleanType, "是否被设置为管理员，`false` 表示被取消管理员")
}

val GroupEssenceMessageChangeEvent = GroupEventBase.extend {
    describe("群精华消息变更")
    field("message_id", LongType, "发生变更的消息 ID")
    field("is_set", BooleanType, "是否被设置为精华，`false` 表示被取消精华")
}

/*
val GroupMemberCardChangeEvent = GroupEventBase.extend {
    describe("群成员名片变更")
    field("user_id", LongType, "发生变更的用户 QQ 号")
    field("old_card", StringType, "旧名片")
    field("new_card", StringType, "新名片")
}
 */

val GroupMemberIncreaseEvent = GroupEventBase.extend {
    describe("群成员增加")
    field("user_id", LongType, "发生变更的用户 QQ 号")
    field("operator_id", LongType, "管理员 QQ 号，如果是管理员同意入群") { optional() }
    field("invitor_id", LongType, "邀请者 QQ 号，如果是邀请入群") { optional() }
}

val GroupMemberDecreaseEvent = GroupEventBase.extend {
    describe("群成员减少")
    field("user_id", LongType, "发生变更的用户 QQ 号")
    field("operator_id", LongType, "管理员 QQ 号，如果是管理员踢出") { optional() }
}

val GroupNameChangeEvent = GroupEventBase.extend {
    describe("群名称变更")
    field("name", StringType, "新的群名称")
}

val GroupMessageReactionEvent = GroupEventBase.extend {
    describe("群消息表情回应")
    field("user_id", LongType, "发送回应者 QQ 号")
    field("message_id", LongType, "消息 ID")
    field("face_id", StringType, "表情 ID")
    field("is_add", BooleanType, "是否为添加，`false` 表示取消回应") { optional() }
}

val GroupMuteEvent = GroupEventBase.extend {
    describe("群成员禁言状态变更")
    field("user_id", LongType, "发生变更的用户 QQ 号")
    field("duration", IntType, "禁言时长（秒），为 0 表示取消禁言")
}

val GroupWholeMuteEvent = GroupEventBase.extend {
    describe("群全员禁言状态变更")
    field("operator_id", LongType, "操作者 QQ 号")
    field("is_mute", BooleanType, "是否全员禁言，`false` 表示取消全员禁言")
}

val GroupPokeEvent = GroupEventBase.extend {
    describe("群戳一戳")
    field("sender_id", LongType, "发送者 QQ 号")
    field("receiver_id", LongType, "接收者 QQ 号")
}