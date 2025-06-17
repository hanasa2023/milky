# 群文件 (GroupFile)
| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| file_id | string | 文件 ID |
| file_name | string | 文件名称 |
| parent_folder_id | string | 父文件夹 ID |
| file_size | int64 | 文件大小（字节） |
| uploaded_time | int64 | 上传时的 Unix 时间戳（秒） |
| expire_time | int64 | 过期时的 Unix 时间戳（秒）（**可选**） |
| uploader_id | int64 | 上传者 QQ 号 |
| downloaded_times | int32 | 下载次数 |

