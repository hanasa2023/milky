package org.ntqqrev.milky.common

import org.ntqqrev.saltify.composeidl.*

val GroupMemberEntity = Struct("GroupMember") {
    describe("群成员")
    use(UserEntityBase)
    field("group_id", LongType, "群号")
    field("card", StringType, "成员备注")
    field("title", StringType, "专属头衔") { optional() }
    field("level", IntType, "群等级，注意和 QQ 等级区分")
    field("role", StringType, "权限等级") {
        enum("owner", "admin", "member")
    }
    field("join_time", LongType, "入群时间，Unix 时间戳（秒）")
    field("last_sent_time", LongType, "最后发言时间，Unix 时间戳（秒）")
    field("shut_up_end_time", LongType, "禁言结束时间，Unix 时间戳（秒）") { optional() }
}