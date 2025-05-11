package org.ntqqrev.saltify.milky

import org.ntqqrev.saltify.milky.api.*
import org.ntqqrev.saltify.milky.common.FriendCategoryEntity
import org.ntqqrev.saltify.milky.common.FriendEntity
import org.ntqqrev.saltify.milky.common.GroupAnnouncementEntity
import org.ntqqrev.saltify.milky.common.GroupEntity
import org.ntqqrev.saltify.milky.common.GroupFileEntity
import org.ntqqrev.saltify.milky.common.GroupFolderEntity
import org.ntqqrev.saltify.milky.common.GroupMemberEntity
import org.ntqqrev.saltify.milky.event.Event
import org.ntqqrev.saltify.milky.generator.markdown.MarkdownGenerator
import org.ntqqrev.saltify.milky.message.IncomingForwardedMessage
import org.ntqqrev.saltify.milky.message.IncomingMessage
import org.ntqqrev.saltify.milky.message.IncomingSegment
import org.ntqqrev.saltify.milky.message.OutgoingForwardedMessage
import org.ntqqrev.saltify.milky.message.OutgoingSegment
import kotlin.io.path.Path

fun main() {
    println(MarkdownGenerator(
        documentedStructs = listOf(
            FriendEntity,
            FriendCategoryEntity,
            GroupEntity,
            GroupMemberEntity,
            GroupAnnouncementEntity,
            GroupFileEntity,
            GroupFolderEntity,
            IncomingMessage,
            IncomingForwardedMessage,
            OutgoingForwardedMessage,
            IncomingSegment,
            OutgoingSegment,
            Event
        ),
        apiCategories = listOf(
            SystemApi,
            MessageApi,
            UserApi,
            GroupApi,
            RequestApi,
            FileApi,
        )
    ).generate(Path("markdown")))
}