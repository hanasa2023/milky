package org.ntqqrev.saltify.milky.api

import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.saltify.composeidl.BooleanType
import org.ntqqrev.saltify.composeidl.Category
import org.ntqqrev.saltify.composeidl.Struct
import org.ntqqrev.saltify.composeidl.UIntType
import org.ntqqrev.saltify.milky.common.FriendEntity
import org.ntqqrev.saltify.milky.common.GroupEntity
import org.ntqqrev.saltify.milky.common.GroupMemberEntity

val SystemApi = Category("system") {
    describe("系统 API")

    val cachedApiBase = Struct {
        field("no_cache", BooleanType, "是否强制不使用缓存") {
            default("false")
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
            field("user_id", UIntType, "好友 QQ 号")
            use(cachedApiBase)
        }
        output(FriendEntity)
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
            field("group_id", UIntType, "群号")
            use(cachedApiBase)
        }
        output(GroupEntity)
    }

    api("get_group_member_list") {
        describe("获取群成员列表")
        input {
            field("group_id", UIntType, "群号")
            use(cachedApiBase)
        }
        output {
            field("members", Array(GroupMemberEntity), "群成员列表")
        }
    }

    api("get_group_member_info") {
        describe("获取群成员信息")
        input {
            field("group_id", UIntType, "群号")
            field("user_id", UIntType, "群成员 QQ 号")
            use(cachedApiBase)
        }
        output(GroupMemberEntity)
    }
}