package org.ntqqrev.milky.common

import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val UserEntityBase = Struct {
    field("user_id", LongType, "用户 QQ 号")
    field("qid", StringType, "用户 QID") { optional() }
    field("nickname", StringType, "用户昵称")
    field("sex", StringType, "用户性别") {
        enum("male", "female", "unknown")
    }
}