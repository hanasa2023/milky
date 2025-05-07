package org.ntqqrev.saltify.milky.common

import org.ntqqrev.saltify.composeidl.IntType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val FriendCategoryEntity = Struct("friend_category") {
    describe("好友分组")
    document()

    field("category_id", IntType, "好友分组 ID")

    field("category_name", StringType, "好友分组名称")
}