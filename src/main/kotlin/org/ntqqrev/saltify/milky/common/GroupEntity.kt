package org.ntqqrev.saltify.milky.common

import org.ntqqrev.saltify.composeidl.IntType
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val GroupEntity = Struct("Group") {
    describe("群聊")
    field("group_id", LongType, "群号")
    field("name", StringType, "群名称")
    field("member_count", IntType, "群成员数量")
    field("max_member_count", IntType, "群容量")
}