package org.ntqqrev.saltify.milky.api

import org.ntqqrev.saltify.composeidl.Category
import org.ntqqrev.saltify.composeidl.UIntType
import org.ntqqrev.saltify.milky.common.CachedApiBase
import org.ntqqrev.saltify.milky.common.FriendEntity
import org.ntqqrev.saltify.milky.common.GroupEntity
import org.ntqqrev.saltify.milky.common.GroupMemberEntity

val SystemApi = Category("system") {
    describe("系统 API")

    api("get_friend_list") {
        describe("获取好友列表")
        input(CachedApiBase)
        outputArray(FriendEntity)
    }

    api("get_friend_info") {
        describe("获取好友信息")
        input {
            field("user_id", UIntType, "好友 QQ 号")
            use(CachedApiBase)
        }
        output(FriendEntity)
    }

    api("get_group_list") {
        describe("获取群列表")
        input(CachedApiBase)
        outputArray(GroupEntity)
    }

    api("get_group_info") {
        describe("获取群信息")
        input {
            field("group_id", UIntType, "群号")
            use(CachedApiBase)
        }
        output(GroupEntity)
    }

    api("get_group_member_list") {
        describe("获取群成员列表")
        input {
            field("group_id", UIntType, "群号")
            use(CachedApiBase)
        }
        outputArray(GroupMemberEntity)
    }

    api("get_group_member_info") {
        describe("获取群成员信息")
        input {
            field("group_id", UIntType, "群号")
            field("user_id", UIntType, "群成员 QQ 号")
            use(CachedApiBase)
        }
        output(GroupMemberEntity)
    }
}