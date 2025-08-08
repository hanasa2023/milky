import { z } from 'zod';
import { ZInt32, ZInt64, ZString, ZBoolean } from './scalar';

// 基础用户实体
export const UserEntityBase = z.object({
  user_id: ZInt64.describe('用户 QQ 号'),
  nickname: ZString.describe('用户昵称'),
  sex: z.enum(['male', 'female', 'unknown']).describe('用户性别'),
}).describe('基础用户实体');

// 好友分类实体
export const FriendCategoryEntity = z.object({
  category_id: ZInt32.describe('分类 ID'),
  name: ZString.describe('分类名称'),
}).describe('好友分类实体');

// 好友实体
export const FriendEntity = UserEntityBase.extend({
  qid: ZString.optional().describe('用户 QID'),
  remark: ZString.describe('好友备注'),
  category: FriendCategoryEntity.optional().describe('好友分组'),
}).describe('好友实体');

// 群实体
export const GroupEntity = z.object({
  group_id: ZInt64.describe('群号'),
  name: ZString.describe('群名称'),
  member_count: ZInt32.describe('群成员数量'),
  max_member_count: ZInt32.describe('群容量'),
}).describe('群实体');

// 群成员实体
export const GroupMemberEntity = UserEntityBase.extend({
  group_id: ZInt64.describe('群号'),
  card: ZString.describe('成员备注'),
  title: ZString.optional().describe('专属头衔'),
  level: ZInt32.describe('群等级，注意和 QQ 等级区分'),
  role: z.enum(['owner', 'admin', 'member']).describe('权限等级'),
  join_time: ZInt64.describe('入群时间，Unix 时间戳（秒）'),
  last_sent_time: ZInt64.describe('最后发言时间，Unix 时间戳（秒）'),
  shut_up_end_time: ZInt64.optional().describe('禁言结束时间，Unix 时间戳（秒）'),
}).describe('群成员实体');

// 群公告实体
export const GroupAnnouncementEntity = z.object({
  announcement_id: ZString.describe('公告 ID'),
  group_id: ZInt64.describe('群号'),
  content: ZString.describe('公告内容'),
  sender_id: ZInt64.describe('发送者 QQ 号'),
  time: ZInt64.describe('发送时间，Unix 时间戳（秒）'),
}).describe('群公告实体');

// 群文件实体
export const GroupFileEntity = z.object({
  file_id: ZString.describe('文件 ID'),
  group_id: ZInt64.describe('群号'),
  name: ZString.describe('文件名'),
  size: ZInt64.describe('文件大小（字节）'),
  busid: ZInt32.describe('文件类型'),
  upload_time: ZInt64.describe('上传时间，Unix 时间戳（秒）'),
  expire_time: ZInt64.describe('过期时间，Unix 时间戳（秒）'),
  uploader_id: ZInt64.describe('上传者 QQ 号'),
  url: ZString.describe('文件下载链接'),
}).describe('群文件实体');

// 请求基础实体
export const RequestBase = z.object({
  request_id: ZString.describe('请求 ID，用于同意 / 拒绝请求'),
  time: ZInt64.describe('请求发起时的 Unix 时间戳（秒）'),
  is_filtered: ZBoolean.describe('请求是否被过滤（发起自风险账户）'),
  initiator_id: ZInt64.describe('发起请求的用户 QQ 号'),
  state: z.enum(['pending', 'accepted', 'rejected', 'ignored']).describe('请求状态'),
}).describe('请求基础实体');

// 好友请求实体
export const FriendRequest = RequestBase.extend({
  comment: ZString.optional().describe('好友请求附加信息'),
  via: ZString.optional().describe('好友请求来源'),
}).describe('好友请求实体');

// 群请求实体
export const GroupRequest = z.discriminatedUnion('request_type', [
  // 自主申请入群请求
  z.object({
    request_type: z.literal('join'),
    request_id: ZString.describe('请求 ID，用于同意 / 拒绝请求'),
    time: ZInt64.describe('请求发起时的 Unix 时间戳（秒）'),
    is_filtered: ZBoolean.describe('请求是否被过滤（发起自风险账户）'),
    initiator_id: ZInt64.describe('发起请求的用户 QQ 号'),
    state: z.enum(['pending', 'accepted', 'rejected', 'ignored']).describe('请求状态'),
    group_id: ZInt64.describe('群号'),
    operator_id: ZInt64.optional().describe('处理请求的用户 QQ 号'),
    comment: ZString.optional().describe('入群请求附加信息'),
  }).describe('自主申请入群请求'),
  
  // 他人邀请入群请求
  z.object({
    request_type: z.literal('invite'),
    request_id: ZString.describe('请求 ID，用于同意 / 拒绝请求'),
    time: ZInt64.describe('请求发起时的 Unix 时间戳（秒）'),
    is_filtered: ZBoolean.describe('请求是否被过滤（发起自风险账户）'),
    initiator_id: ZInt64.describe('发起请求的用户 QQ 号'),
    state: z.enum(['pending', 'accepted', 'rejected', 'ignored']).describe('请求状态'),
    group_id: ZInt64.describe('群号'),
    operator_id: ZInt64.optional().describe('处理请求的用户 QQ 号'),
    invitee_id: ZInt64.describe('被邀请者 QQ 号'),
  }).describe('他人邀请入群请求'),
]);

// 群邀请实体
export const GroupInvitation = RequestBase.extend({
  group_id: ZInt64.describe('群号'),
}).describe('群邀请实体');

// 请求实体（通用）
export const RequestEntity = z.object({
  request_id: ZString.describe('请求 ID'),
  time: ZInt64.describe('请求时间，Unix 时间戳（秒）'),
  requester_id: ZInt64.describe('请求者 QQ 号'),
  requester_nickname: ZString.describe('请求者昵称'),
  message: ZString.describe('请求消息'),
}).describe('请求实体（通用）');

// 消息标识符
export const MessageIdentifier = z.object({
  message_scene: z.enum(['friend', 'group', 'temp']).describe('消息场景'),
  peer_id: ZInt64.describe('好友 QQ 号或群号'),
  message_seq: ZInt64.describe('消息序列号'),
}).describe('消息标识符');

// 导出类型
export type UserEntityBase = z.infer<typeof UserEntityBase>;
export type FriendCategoryEntity = z.infer<typeof FriendCategoryEntity>;
export type FriendEntity = z.infer<typeof FriendEntity>;
export type GroupEntity = z.infer<typeof GroupEntity>;
export type GroupMemberEntity = z.infer<typeof GroupMemberEntity>;
export type GroupAnnouncementEntity = z.infer<typeof GroupAnnouncementEntity>;
export type GroupFileEntity = z.infer<typeof GroupFileEntity>;
export type RequestBase = z.infer<typeof RequestBase>;
export type FriendRequest = z.infer<typeof FriendRequest>;
export type GroupRequest = z.infer<typeof GroupRequest>;
export type GroupInvitation = z.infer<typeof GroupInvitation>;
export type RequestEntity = z.infer<typeof RequestEntity>;
export type MessageIdentifier = z.infer<typeof MessageIdentifier>;
