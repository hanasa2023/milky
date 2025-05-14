package org.ntqqrev.saltify.milky

import org.ntqqrev.saltify.milky.api.*
import org.ntqqrev.saltify.milky.common.*
import org.ntqqrev.saltify.milky.event.Event
import org.ntqqrev.saltify.milky.generator.markdown.MarkdownGenerator
import org.ntqqrev.saltify.milky.message.*
import kotlin.io.path.Path

fun main() {
    println(
        MarkdownGenerator(
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
        ).generate(Path("markdown"))
    )
}