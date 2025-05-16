package org.ntqqrev.saltify.milky.common

import org.ntqqrev.saltify.composeidl.*

val GroupFolderEntity = Struct("GroupFolder") {
    describe("群文件夹")
    field("group_id", LongType, "群号")
    field("folder_id", StringType, "文件夹 ID")
    field("parent_folder_id", StringType, "父文件夹 ID") { optional() }
    field("folder_name", StringType, "文件夹名称")
    field("created_time", LongType, "创建时的 Unix 时间戳（秒）")
    field("last_modified_time", LongType, "最后修改时的 Unix 时间戳（秒）")
    field("creator_id", LongType, "创建者 QQ 号")
    field("file_count", IntType, "文件数量")
}

val GroupFileEntity = Struct("GroupFile") {
    describe("群文件")
    field("group_id", LongType, "群号")
    field("file_id", StringType, "文件 ID")
    field("file_name", StringType, "文件名称")
    field("parent_folder_id", StringType, "父文件夹 ID") { optional() }
    field("file_size", IntType, "文件大小（字节）")
    field("uploaded_time", LongType, "上传时的 Unix 时间戳（秒）")
    field("expire_time", LongType, "过期时的 Unix 时间戳（秒）")
    field("uploader_id", LongType, "上传者 QQ 号")
    field("downloaded_times", IntType, "下载次数")
}