package org.ntqqrev.saltify.milky.common

import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct
import org.ntqqrev.saltify.composeidl.UIntType

val GroupAnnouncementEntity = Struct("GroupAnnouncement") {
    describe("群公告")
    field("group_id", LongType, "群号")
    field("announcement_id", StringType, "公告 ID")
    field("user_id", LongType, "发送者 QQ 号")
    field("time", UIntType, "Unix 时间戳（秒）")
    field("content", StringType, "公告内容")
    field("image_url", StringType, "公告图片 URL") { optional() }
}