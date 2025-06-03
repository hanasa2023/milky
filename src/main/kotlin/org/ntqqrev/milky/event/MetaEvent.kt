package org.ntqqrev.milky.event

import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val BotOfflineEvent = Struct {
    describe("机器人下线事件")
    field("reason", StringType, "下线原因")
}