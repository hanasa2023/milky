package org.ntqqrev.milky.message

import org.ntqqrev.saltify.composeidl.*
import org.ntqqrev.saltify.composeidl.Array

val OutgoingResourceSegmentBase = Struct {
    field("uri", StringType) {
        describe("文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式")
    }
}

val OutgoingSegment = DiscriminatedUnion("OutgoingSegment", "type") {
    describe("发送消息段")

    structPlacedInto("data")

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

    struct("reply") {
        describe("回复消息段")
        field("message_seq", LongType, "被引用的消息序列号")
        field("client_seq", LongType) {
            describe("被引用的消息的客户端序列号，在回复私聊消息时必须提供")
            optional()
        }
    }

    struct("image") {
        describe("图片消息段")
        use(OutgoingResourceSegmentBase)
        field("summary", StringType, "图片预览文本") { optional() }
        field("sub_type", StringType, "图片类型") {
            enum("normal", "sticker")
        }
    }

    struct("record") {
        describe("语音消息段")
        use(OutgoingResourceSegmentBase)
    }

    struct("video") {
        describe("视频消息段")
        use(OutgoingResourceSegmentBase)
        field("thumb_uri", StringType, "封面图片 URI") { optional() }
    }

    struct("forward") {
        describe("合并转发消息段")
        field("messages", Array(OutgoingForwardedMessage), "合并转发 ID")
    }
}