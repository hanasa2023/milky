# 生态

下面列出了部分支持 Milky 的项目。如果你想要将自己的项目加入以下列表，欢迎在 [Milky 的 GitHub 仓库](https://github.com/SaltifyDev/milky)提出 Pull Request。

## 支持 Milky 的协议端

- [Lagrange.Milky](https://github.com/LagrangeDev/LagrangeV2/tree/main/Lagrange.Milky)
- [tanebi-milky](https://github.com/SaltifyDev/tanebi/tree/v2/packages/milky)

## 支持 Milky 的应用端

| 框架    | 语言       | 适配器                                                                                |
| ------- | ---------- | ------------------------------------------------------------------------------------- |
| NoneBot | Python     | [nonebot-adapter-milky](https://github.com/nonebot/adapter-milky)                     |
| Koishi  | TypeScript | [koishi-plugin-adapter-milky](https://github.com/idranme/koishi-plugin-adapter-milky) |

## 类型定义

以下是由 Milky 官方发布的类型定义包：

| 语言       | 包名                                                                       |
| ---------- | -------------------------------------------------------------------------- |
| TypeScript | [@saltify/milky-types](https://www.npmjs.com/package/@saltify/milky-types) |
| .Net       | [Milky.Net.Model](https://www.nuget.org/packages/Milky.Net.Model)          |

同时，Milky 官方通过一系列社区工具将 Zod 定义转化为其他语言的类型定义，托管在 `/raw` 端点下，可以直接通过 `GET` 请求获取。目前支持的语言有：

| 语言        | 路径                                   | 生成方式                                          |
| ----------- | -------------------------------------- | ------------------------------------------------- |
| JSON Schema | [`/raw/json-schema`](/raw/json-schema) | [`z.toJSONSchema()`](https://zod.dev/json-schema) |

请注意，以上由社区工具生成的类型定义是**实验性**的，Milky 官方不保证其准确性和完整性。如对生成的类型定义有疑问，请以文档提供的定义为准，并且及时反馈。

## Milky SDK

| 语言       | 包名                                                                             |
| ---------- | -------------------------------------------------------------------------------- |
| TypeScript | [@saltify/milky-node-sdk](https://www.npmjs.com/package/@saltify/milky-node-sdk) |
| Rust       | [vivian-rs](https://crates.io/crates/vivian)                                     |
| .Net       | [Milky.Net.Client](https://www.nuget.org/packages/Milky.Net.Client)              |
