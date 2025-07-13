package org.ntqqrev.milky.api

import org.ntqqrev.milky.MilkyVersion
import org.ntqqrev.saltify.composeidl.*
import org.ntqqrev.milky.common.FriendEntity
import org.ntqqrev.milky.common.GroupEntity
import org.ntqqrev.milky.common.GroupMemberEntity

val SystemApi = Category("system") {
    describe("系统 API")

    val cachedApiBase = Struct {
        field("no_cache", BooleanType, "是否强制不使用缓存") {
            default("false")
        }
    }

    api("get_login_info") {
        describe("获取登录信息")
        output {
            field("uin", LongType, "登录 QQ 号")
            field("nickname", StringType, "登录昵称")
        }
    }

    api("get_impl_info") {
        describe("获取协议端信息")
        output {
            field("impl_name", StringType, "协议端名称")
            field("impl_version", StringType, "协议端版本")
            field("qq_protocol_version", StringType, "协议端使用的 QQ 协议版本")
            field("qq_protocol_type", StringType, "协议端使用的 QQ 协议平台") {
                enum(
                    "windows",
                    "linux",
                    "macos",
                    "android_pad",
                    "android_phone",
                    "ipad",
                    "iphone",
                    "harmony",
                    "watch"
                )
            }
            field("milky_version", StringType, "协议端实现的 Milky 协议版本，目前为 `$MilkyVersion`")
        }
    }

    api("get_user_profile") {
        describe("获取用户个人信息")
        input {
            field("user_id", IntType, "用户 QQ 号")
        }
        output {
            field("nickname", StringType, "昵称")
            field("qid", StringType, "QID") { optional() }
            field("age", IntType, "年龄")
            field("sex", StringType, "性别") {
                enum("male", "female", "unknown")
            }
            field("remark", StringType, "备注") { optional() }
            field("bio", StringType, "个性签名") { optional() }
            field("level", IntType, "QQ 等级") { optional() }
            field("country", StringType, "国家或地区") { optional() }
            field("city", StringType, "城市") { optional() }
            field("school", StringType, "学校") { optional() }
        }
    }

    api("get_friend_list") {
        describe("获取好友列表")
        input(cachedApiBase)
        output {
            field("friends", Array(FriendEntity), "好友列表")
        }
    }

    api("get_friend_info") {
        describe("获取好友信息")
        input {
            field("user_id", LongType, "好友 QQ 号")
            use(cachedApiBase)
        }
        output {
            field("friend", FriendEntity, "好友信息")
        }
    }

    api("get_group_list") {
        describe("获取群列表")
        input(cachedApiBase)
        output {
            field("groups", Array(GroupEntity), "群列表")
        }
    }

    api("get_group_info") {
        describe("获取群信息")
        input {
            field("group_id", LongType, "群号")
            use(cachedApiBase)
        }
        output {
            field("group", GroupEntity, "群信息")
        }
    }

    api("get_group_member_list") {
        describe("获取群成员列表")
        input {
            field("group_id", LongType, "群号")
            use(cachedApiBase)
        }
        output {
            field("members", Array(GroupMemberEntity), "群成员列表")
        }
    }

    api("get_group_member_info") {
        describe("获取群成员信息")
        input {
            field("group_id", LongType, "群号")
            field("user_id", LongType, "群成员 QQ 号")
            use(cachedApiBase)
        }
        output {
            field("member", GroupMemberEntity, "群成员信息")
        }
    }
}