import { defineConfig } from 'vitepress'

export default defineConfig({
  title: "Milky",
  description: "新时代 QQ 机器人应用接口标准",
  themeConfig: {
    nav: [
      { text: '主页', link: '/' },
    ],

    sidebar: [
      {
        text: '指南',
        items: [
          { text: '介绍', link: '/guide/introduction' },
          { text: '通信', link: '/guide/communication' },
          { text: '生态' },
        ]
      },
      {
        text: '参考',
        items: [
          {
            text: 'API',
            items: [
              { text: '系统 API', link: '/api/system' },
              { text: '消息 API', link: '/api/message' },
              { text: '好友 API', link: '/api/friend' },
              { text: '群聊 API', link: '/api/group' },
              { text: '请求 API', link: '/api/request' },
              { text: '文件 API', link: '/api/file' },
            ],
            collapsed: false,
          },
          {
            text: '结构体',
            items: [
              { text: '好友', link: '/struct/Friend' },
              { text: '好友分组', link: '/struct/FriendCategory' },
              { text: '群聊', link: '/struct/Group' },
              { text: '群成员', link: '/struct/GroupMember' },
              { text: '群公告', link: '/struct/GroupAnnouncement' },
              { text: '群文件', link: '/struct/GroupFile' },
              { text: '群文件夹', link: '/struct/GroupFolder' },
              { text: '接收消息', link: '/struct/IncomingMessage' },
              { text: '接收转发消息', link: '/struct/IncomingForwardedMessage' },
              { text: '接收消息段', link: '/struct/IncomingSegment' },
              { text: '发送转发消息', link: '/struct/OutgoingForwardedMessage' },
              { text: '发送消息段', link: '/struct/OutgoingSegment' },
            ],
            collapsed: true,
          },
          { text: '事件', link: '/struct/Event' },
        ]
      }
    ],

    socialLinks: [
      { icon: 'github', link: 'https://github.com/SaltifyDev/milky' }
    ]
  }
})
