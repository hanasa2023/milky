package org.ntqqrev.milky.api

import org.ntqqrev.saltify.composeidl.Category
import org.ntqqrev.saltify.composeidl.IntType
import org.ntqqrev.saltify.composeidl.LongType

val UserApi = Category("friend") {
    describe("好友 API")

    api("send_friend_poke") {
        describe("发送好友戳一戳")
        input {
            field("user_id", LongType, "好友 QQ 号")
            field("is_self", LongType, "是否戳自己") { default("false") }
        }
    }

    api("send_profile_like") {
        describe("发送名片点赞")
        input {
            field("user_id", LongType, "好友 QQ 号")
            field("count", IntType, "点赞数量") { default("1") }
        }
    }
}