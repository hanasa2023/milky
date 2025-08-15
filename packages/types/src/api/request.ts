import { z } from 'zod';
import { ZInt32, ZString } from '../scalar';
import { FriendRequest } from '../common';

// 获取好友请求列表输入
export const GetFriendRequestsInput = z.object({
  limit: ZInt32.default(20).describe('获取的最大请求数量'),
});

// 获取好友请求列表输出
export const GetFriendRequestsOutput = z.object({
  requests: z.array(z.lazy(() => FriendRequest)).describe('好友请求列表'),
});

// 同意好友请求输入
export const AcceptFriendRequestInput = z.object({
  request_id: ZString.describe('请求 ID'),
});

// 拒绝好友请求输入
export const RejectFriendRequestInput = z.object({
  request_id: ZString.describe('请求 ID'),
  reason: ZString.optional().describe('拒绝理由'),
});

// 导出类型
export type GetFriendRequestsInput = z.infer<typeof GetFriendRequestsInput>;
export type GetFriendRequestsOutput = z.infer<typeof GetFriendRequestsOutput>;
export type AcceptFriendRequestInput = z.infer<typeof AcceptFriendRequestInput>;
export type RejectFriendRequestInput = z.infer<typeof RejectFriendRequestInput>;
