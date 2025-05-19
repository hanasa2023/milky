package org.ntqqrev.milky.message

import org.ntqqrev.saltify.composeidl.DiscriminatedUnion
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType

fun DiscriminatedUnion.defineSharedSegment() {
    struct("text") {
        describe("文本消息段")
        field("text", StringType, "文本内容")
    }

    struct("mention") {
        describe("提及（@）消息段")
        field("user_id", LongType, "提及的 QQ 号")
    }

    struct("mention_all") {
        describe("提及全体（@全体成员）消息段")
    }

    struct("face") {
        describe("表情消息段")
        field("face_id", StringType, "表情 ID")
    }
}