package org.ntqqrev.milky.common

import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val FriendEntity = Struct("Friend") {
    describe("好友")
    use(UserEntityBase)
    field("qid", StringType, "用户 QID") { optional() }
    field("remark", StringType, "好友备注")
    field("category", FriendCategoryEntity, "好友分组") { optional() }
}