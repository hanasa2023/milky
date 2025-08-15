import { z } from 'zod';
import { ZInt32, ZInt64, ZBoolean } from '../scalar';

export const SendFriendNudgeInput = z.object({
  user_id: ZInt64.describe('好友 QQ 号'),
  is_self: ZBoolean.default(false).describe('是否戳自己'),
});

export const SendProfileLikeInput = z.object({
  user_id: ZInt64.describe('好友 QQ 号'),
  count: ZInt32.default(1).describe('点赞数量'),
});

export type SendFriendNudgeInput = z.infer<typeof SendFriendNudgeInput>;
export type SendProfileLikeInput = z.infer<typeof SendProfileLikeInput>;
