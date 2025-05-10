package org.ntqqrev.saltify.milky.common

import org.ntqqrev.saltify.composeidl.IntType
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct
import org.ntqqrev.saltify.composeidl.UIntType

val GroupFolderEntity = Struct("GroupFolder") {
    field("group_id", LongType, "群号")
    field("folder_id", StringType, "文件夹 ID")
    field("parent_folder_id", StringType, "父文件夹 ID") { optional() }
    field("folder_name", StringType, "文件夹名称")
    field("created_time", UIntType, "创建时的 Unix 时间戳（秒）")
    field("last_modified_time", UIntType, "最后修改时的 Unix 时间戳（秒）")
    field("creator_id", LongType, "创建者 QQ 号")
    field("file_count", IntType, "文件数量")
}

val GroupFileEntity = Struct("GroupFile") {
    field("group_id", LongType, "群号")
    field("file_id", StringType, "文件 ID")
    field("file_name", StringType, "文件名称")
    field("parent_folder_id", StringType, "父文件夹 ID") { optional() }
    field("file_size", IntType, "文件大小（字节）")
    field("uploaded_time", UIntType, "上传时的 Unix 时间戳（秒）")
    field("expire_time", UIntType, "过期时的 Unix 时间戳（秒）")
    field("uploader_id", LongType, "上传者 QQ 号")
    field("downloaded_times", IntType, "下载次数")
}