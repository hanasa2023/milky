package org.ntqqrev.saltify.milky.event

import org.ntqqrev.saltify.composeidl.BooleanType
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val FriendEventBase = Struct {
    field("user_id", LongType, "好友 QQ 号")
}

val FriendPokeEvent = FriendEventBase.extend {
    describe("好友戳一戳")
    field("is_self_send", BooleanType, "是否是自己发送的戳一戳")
    field("is_self_receive", BooleanType, "是否是自己接收的戳一戳")
}

val FriendFileUploadEvent = FriendEventBase.extend {
    describe("好友文件上传")
    field("file_id", StringType, "文件 ID")
    field("file_name", StringType, "文件名称")
    field("file_size", LongType, "文件大小")
    field("is_self", BooleanType, "是否是自己发送的文件")
}