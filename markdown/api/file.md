# 文件 API

## `upload_private_file` 上传私聊文件

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| file_uri | string | 文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式 |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| file_id | string | 文件 ID |

## `upload_group_file` 上传群文件

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| file_uri | string | 文件 URI，支持 `file://` `http(s)://` `base64://` 三种格式 |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| file_id | string | 文件 ID |

## `get_private_file_download_url` 获取私聊文件下载链接

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| file_id | string | 文件 ID |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| download_url | string | 文件下载链接 |

## `get_group_file_download_url` 获取群文件下载链接

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| file_id | string | 文件 ID |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| download_url | string | 文件下载链接 |

## `get_group_files` 获取群文件列表

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| parent_folder_id | string | 父文件夹 ID，默认为根目录（**可选**） |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| files | Array<[GroupFile](../struct/GroupFile.md)> | 文件列表 |
| folder | Array<[GroupFolder](../struct/GroupFolder.md)> | 文件夹列表 |

## `move_group_file` 移动群文件

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| file_id | string | 文件 ID |
| target_folder_id | string | 目标文件夹 ID，默认为根目录（**可选**） |

### 返回值

此 API 无返回值。
## `rename_group_file` 重命名群文件

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| file_id | string | 文件 ID |
| new_name | string | 新文件名称 |

### 返回值

此 API 无返回值。
## `delete_group_file` 删除群文件

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| file_id | string | 文件 ID |

### 返回值

此 API 无返回值。
## `create_group_folder` 创建群文件夹

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| folder_name | string | 文件夹名称 |

### 返回值

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| folder_id | string | 文件夹 ID |

## `rename_group_folder` 重命名群文件夹

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| folder_id | string | 文件夹 ID |
| new_name | string | 新文件夹名 |

### 返回值

此 API 无返回值。
## `delete_group_folder` 删除群文件夹

### 参数

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| group_id | int64 | 群号 |
| folder_id | string | 文件夹 ID |

### 返回值

此 API 无返回值。
