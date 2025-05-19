package org.ntqqrev.milky.api

import org.ntqqrev.saltify.composeidl.*
import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.milky.common.GroupAnnouncementEntity

val GroupApi = Category("group") {
    describe("群聊 API")

    val pictureApiBase = Struct {
        field("image_uri", StringType) {
            describe("图像文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式")
        }
    }

    api("set_group_name") {
        describe("设置群名称")
        input {
            field("group_id", LongType, "群号")
            field("name", StringType, "新群名称")
        }
    }

    api("set_group_avatar") {
        describe("设置群头像")
        input {
            field("group_id", LongType, "群号")
            use(pictureApiBase)
        }
    }

    api("set_group_member_card") {
        describe("设置群名片")
        input {
            field("group_id", LongType, "群号")
            field("user_id", LongType, "被设置的群成员 QQ 号")
            field("card", StringType, "新群名片")
        }
    }

    api("set_group_member_special_title") {
        describe("设置群成员专属头衔")
        input {
            field("group_id", LongType, "群号")
            field("user_id", LongType, "被设置的群成员 QQ 号")
            field("special_title", StringType, "新专属头衔")
//            field("duration", LongType) {
//                describe("专属头衔持续时间，单位：秒")
//                default("0")
//            }
        }
    }

    api("set_group_member_admin") {
        describe("设置群管理员")
        input {
            field("group_id", LongType, "群号")
            field("user_id", LongType, "被设置的 QQ 号")
            field("is_set", LongType) {
                describe("是否设置为管理员，`false` 为取消管理员")
                default("true")
            }
        }
    }

    api("set_group_member_mute") {
        describe("设置群成员禁言")
        input {
            field("group_id", LongType, "群号")
            field("user_id", LongType, "被设置的 QQ 号")
            field("duration", LongType) {
                describe("禁言持续时间（秒），设为 `0` 为取消禁言")
                default("0")
            }
        }
    }

    api("set_group_whole_mute") {
        describe("设置群全员禁言")
        input {
            field("group_id", LongType, "群号")
            field("is_mute", BooleanType) {
                describe("是否开启全员禁言，`false` 为取消全员禁言")
                default("true")
            }
        }
    }

    api("kick_group_member") {
        describe("踢出群成员")
        input {
            field("group_id", LongType, "群号")
            field("user_id", LongType, "被踢的 QQ 号")
            field("reject_add_request", BooleanType) {
                describe("是否拒绝加群申请，`false` 为不拒绝")
                default("true")
            }
        }
    }

    api("get_group_announcement_list") {
        describe("获取群公告列表")
        input {
            field("group_id", LongType, "群号")
        }
        output {
            field("announcements", Array(GroupAnnouncementEntity), "群公告列表")
        }
    }

    api("send_group_announcement") {
        describe("发送群公告")
        input {
            field("group_id", LongType, "群号")
            field("content", StringType, "公告内容")
            use(pictureApiBase)
        }
    }

    api("delete_group_announcement") {
        describe("删除群公告")
        input {
            field("group_id", LongType, "群号")
            field("announcement_id", LongType, "公告 ID")
        }
    }

    api("quit_group") {
        describe("退出群")
        input {
            field("group_id", LongType, "群号")
        }
    }

    api("send_group_message_reaction") {
        describe("发送群消息表情回应")
        input {
            field("message_seq", LongType, "要回应的消息序列号")
            field("reaction", StringType, "表情 ID")
            field("is_add", BooleanType) {
                describe("是否添加表情，`false` 为取消")
                default("true")
            }
        }
    }

    api("send_group_nudge") {
        describe("发送群戳一戳")
        input {
            field("group_id", LongType, "群号")
            field("user_id", LongType, "被戳的群成员 QQ 号")
        }
    }
}