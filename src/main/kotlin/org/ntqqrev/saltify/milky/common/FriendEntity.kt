package org.ntqqrev.saltify.milky.common

import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val FriendEntity = Struct("Friend") {
    describe("好友")
    document()

    field("user_id", LongType, "好友 QQ 号")
    field("qid", StringType, "好友 QID") { optional() }
    field("nickname", StringType, "好友昵称")
    field("remark", StringType, "好友备注")
    field("category", FriendCategoryEntity, "好友分组") { optional() }
}