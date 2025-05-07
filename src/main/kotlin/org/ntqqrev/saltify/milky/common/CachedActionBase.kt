package org.ntqqrev.saltify.milky.common

import org.ntqqrev.saltify.composeidl.BooleanType
import org.ntqqrev.saltify.composeidl.Struct

val CacheActionBase = Struct {
    field("no_cache", BooleanType, "是否强制不使用缓存") {
        default("false")
    }
}