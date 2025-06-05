package org.ntqqrev.milky

import org.ntqqrev.milky.api.*
import org.ntqqrev.milky.common.*
import org.ntqqrev.milky.event.Event
import org.ntqqrev.milky.generator.markdown.MarkdownGenerator
import org.ntqqrev.milky.generator.validator.DSLValidator
import org.ntqqrev.milky.message.*
import kotlin.io.path.Path

const val MilkyVersion = "1.0"

fun main() {
    val validator = DSLValidator(
        documentedStructs = listOf(
            FriendEntity,
            FriendCategoryEntity,
            GroupEntity,
            GroupMemberEntity,
            GroupAnnouncementEntity,
            GroupFileEntity,
            GroupFolderEntity,
            FriendRequest,
            GroupRequest,
            GroupInvitation,
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
            FriendApi,
            GroupApi,
            RequestApi,
            FileApi,
        )
    )
    validator.validate()

    MarkdownGenerator(
        documentedStructs = validator.documentedStructs,
        apiCategories = validator.apiCategories
    ).generate(Path("markdown"))
}
