# Milky Types

这是 Milky 协议的 TypeScript 类型定义包，使用 Zod 进行运行时类型验证。

## 安装

```bash
npm install @saltify/milky-types
```

## 使用方法

### 基础类型

```typescript
import { Int32, Int64, String, Boolean } from '@saltifydev/milky-types';

// 使用基础标量类型
const userId: z.infer<typeof Int64> = 123456789;
const userName: z.infer<typeof String> = "用户名";
const isActive: z.infer<typeof Boolean> = true;
```

### 实体类型

```typescript
import { FriendEntity, GroupEntity, GroupMemberEntity } from '@saltifydev/milky-types';

// 使用实体类型
const friend: z.infer<typeof FriendEntity> = {
  user_id: 123456789,
  nickname: "好友昵称",
  sex: "male",
  qid: "QID123",
  remark: "好友备注",
  category: {
    category_id: 1,
    name: "默认分组"
  }
};
```

### 消息类型

```typescript
import { IncomingMessage, OutgoingSegment } from '@saltifydev/milky-types';

// 使用消息类型
const message: z.infer<typeof IncomingMessage> = {
  message_scene: "friend",
  peer_id: 123456789,
  message_seq: 1,
  sender_id: 123456789,
  time: 1640995200,
  segments: [
    {
      type: "text",
      data: {
        text: "Hello, World!"
      }
    }
  ],
  friend: {
    user_id: 123456789,
    nickname: "好友昵称",
    sex: "male",
    remark: "好友备注"
  }
};
```

### 事件类型

```typescript
import { Event } from '@saltifydev/milky-types';

// 使用事件类型
const event: z.infer<typeof Event> = {
  event_type: "message_receive",
  time: 1640995200,
  self_id: 123456789,
  data: {
    message_scene: "friend",
    peer_id: 123456789,
    message_seq: 1,
    sender_id: 123456789,
    time: 1640995200,
    segments: [],
    friend: {
      user_id: 123456789,
      nickname: "好友昵称",
      sex: "male",
      remark: "好友备注"
    }
  }
};
```

### API 类型

```typescript
import { 
  SendPrivateMessageInput, 
  SendPrivateMessageOutput,
  GetLoginInfoOutput 
} from '@saltifydev/milky-types';

// 使用 API 输入类型
const sendMessageInput: z.infer<typeof SendPrivateMessageInput> = {
  user_id: 123456789,
  message: [
    {
      type: "text",
      data: {
        text: "Hello!"
      }
    }
  ]
};

// 使用 API 输出类型
const loginInfo: z.infer<typeof GetLoginInfoOutput> = {
  uin: 123456789,
  nickname: "机器人昵称"
};
```

## 类型验证

所有类型都使用 Zod 进行运行时验证：

```typescript
import { FriendEntity } from '@saltifydev/milky-types';

// 验证数据
const data = {
  user_id: 123456789,
  nickname: "用户名",
  sex: "male",
  remark: "备注"
};

try {
  const validatedFriend = FriendEntity.parse(data);
  console.log('验证成功:', validatedFriend);
} catch (error) {
  console.error('验证失败:', error);
}
```

## 类型结构

### 基础类型 (`scalar.ts`)
- `Int32` - 32位整数
- `Int64` - 64位整数
- `String` - 字符串
- `Boolean` - 布尔值

### 实体类型 (`common.ts`)
- `UserEntityBase` - 基础用户实体
- `FriendEntity` - 好友实体
- `GroupEntity` - 群实体
- `GroupMemberEntity` - 群成员实体
- `GroupAnnouncementEntity` - 群公告实体
- `GroupFileEntity` - 群文件实体
- `RequestEntity` - 请求实体
- `MessageIdentifier` - 消息标识符

### 消息类型 (`message.ts`)
- `IncomingSegment` - 接收消息段
- `OutgoingSegment` - 发送消息段
- `IncomingMessage` - 接收消息
- `IncomingForwardedMessage` - 接收合并转发消息
- `OutgoingForwardedMessage` - 发送合并转发消息

### 事件类型 (`event.ts`)
- `Event` - 主事件类型（包含所有事件类型）
- `BotOfflineEvent` - 机器人离线事件
- `MessageRecallEvent` - 消息撤回事件
- `FriendRequest` - 好友请求
- `GroupRequest` - 群请求
- `GroupInvitation` - 群邀请
- 等等...

### API 类型 (`api/`)
- `system.ts` - 系统 API 类型
- `message.ts` - 消息 API 类型
- `friend.ts` - 好友 API 类型
- `group.ts` - 群聊 API 类型
- `file.ts` - 文件 API 类型
- `request.ts` - 请求 API 类型
