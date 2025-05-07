package org.ntqqrev.saltify.milky.common

import org.ntqqrev.saltify.composeidl.IntType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct
import org.ntqqrev.saltify.composeidl.UIntType

val GroupEntity = Struct("group") {
    describe("群聊")
    document()

    field("group_id", UIntType, "群号")

    field("name", StringType, "群名称")

    field("member_count", IntType, "群成员数量")

    field("max_member_count", IntType, "群容量")
}