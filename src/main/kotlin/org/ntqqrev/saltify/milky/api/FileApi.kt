package org.ntqqrev.saltify.milky.api

import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.saltify.composeidl.Category
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct
import org.ntqqrev.saltify.milky.common.GroupFileEntity
import org.ntqqrev.saltify.milky.common.GroupFolderEntity

val FileApi = Category("file") {
    describe("文件 API")

    val fileUploadApiBase = Struct {
        field("file_uri", StringType) {
            describe("文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式")
        }
    }

    api("upload_private_file") {
        describe("上传私聊文件")
        input {
            field("user_id", LongType, "好友 QQ 号")
            use(fileUploadApiBase)
        }
        output {
            field("file_id", StringType, "文件 ID")
        }
    }

    api("upload_group_file") {
        describe("上传群文件")
        input {
            field("group_id", LongType, "群号")
            use(fileUploadApiBase)
        }
        output {
            field("file_id", StringType, "文件 ID")
        }
    }

    val fileDownloadApiBase = Struct {
        field("file_id", StringType) {
            describe("文件 ID")
        }
    }

    api("get_private_file_download_url") {
        describe("获取私聊文件下载链接")
        input {
            field("user_id", LongType, "好友 QQ 号")
            use(fileDownloadApiBase)
        }
        output {
            field("download_url", StringType, "文件下载链接")
        }
    }

    api("get_group_file_download_url") {
        describe("获取群文件下载链接")
        input {
            field("group_id", LongType, "群号")
            use(fileDownloadApiBase)
        }
        output {
            field("download_url", StringType, "文件下载链接")
        }
    }

    api("get_group_files") {
        describe("获取群文件列表")
        input {
            field("group_id", LongType, "群号")
            field("parent_folder_id", StringType) {
                describe("父文件夹 ID，默认为根目录")
                optional()
            }
        }
        output {
            field("files", Array(GroupFileEntity), "文件列表")
            field("folder", Array(GroupFolderEntity), "文件夹列表")
        }
    }

    api("move_group_file") {
        describe("移动群文件")
        input {
            field("group_id", LongType, "群号")
            field("file_id", StringType, "文件 ID")
            field("target_folder_id", StringType) {
                describe("目标文件夹 ID，默认为根目录")
                optional()
            }
        }
    }

    api("rename_group_file") {
        describe("重命名群文件")
        input {
            field("group_id", LongType, "群号")
            field("file_id", StringType, "文件 ID")
            field("new_name", StringType) {
                describe("新文件名称")
            }
        }
    }

    api("delete_group_file") {
        describe("删除群文件")
        input {
            field("group_id", LongType, "群号")
            field("file_id", StringType, "文件 ID")
        }
    }

    api("create_group_folder") {
        describe("创建群文件夹")
        input {
            field("group_id", LongType, "群号")
            field("folder_name", StringType, "文件夹名称")
//            field("parent_folder_id", StringType) {
//                describe("父文件夹 ID，默认为根目录")
//                optional()
//            }
        }
        output {
            field("folder_id", StringType, "文件夹 ID")
        }
    }

    api("rename_group_folder") {
        describe("重命名群文件夹")
        input {
            field("group_id", LongType, "群号")
            field("folder_id", StringType, "文件夹 ID")
            field("new_name", StringType, "新文件夹名")
        }
    }

    api("delete_group_folder") {
        describe("删除群文件夹")
        input {
            field("group_id", LongType, "群号")
            field("folder_id", StringType, "文件夹 ID")
        }
    }
}