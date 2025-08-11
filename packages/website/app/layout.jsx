import { LastUpdated, Layout, Navbar } from 'nextra-theme-docs';
import { getPageMap } from 'nextra/page-map';
import 'nextra-theme-docs/style.css';
import '@fontsource/inter/100.css';
import '@fontsource/inter/200.css';
import '@fontsource/inter/300.css';
import '@fontsource/inter/400.css';
import '@fontsource/inter/500.css';
import '@fontsource/inter/600.css';
import '@fontsource/inter/700.css';
import '@fontsource/inter/800.css';
import '@fontsource/inter/900.css';
import '@fontsource-variable/noto-sans-sc';
import './styles.css';
import { commonStructs, apiCategories } from './common';
import { Head, Search } from 'nextra/components';

export const metadata = {
  title: '🥛 Milky',
  description: 'Milky 协议文档',
};

const navbar = <Navbar logo={<b>Milky</b>} />;

export default async function RootLayout({ children }) {
  return (
    <html lang="zh" suppressHydrationWarning>
      <Head />
      <body>
        <Layout
          navbar={navbar}
          pageMap={[
            ...(await getPageMap()),
            {
              name: 'api',
              route: '/api',
              title: 'API',
              children: Object.entries(apiCategories).map(([name, apiCategory]) => ({
                name,
                route: `/api/${name}`,
                title: apiCategory.name,
              })),
            },
            {
              name: 'struct',
              route: '/struct',
              title: '结构体',
              children: Object.entries(commonStructs).map(([name, struct]) => ({
                name,
                route: `/struct/${name}`,
                title: struct.description,
                frontMater: {},
              })),
            },
          ]}
          docsRepositoryBase="https://github.com/SaltifyDev/milky/tree/main/packages/website/"
          search={<Search
            placeholder="搜索内容..."
            emptyResult="没有找到相关内容"
            errorText="加载索引失败"
            loading="加载中..."
          />}
          editLink="在 GitHub 上编辑此页"
          feedback={{
            content: '有问题？提交反馈',
          }}
          lastUpdated={<LastUpdated locale="zh">最后更新于</LastUpdated>}
          themeSwitch={{
            dark: '暗色',
            light: '亮色',
            system: '跟随系统',
          }}
          toc={{
            title: '目录',
            backToTop: '返回顶部',
          }}
        >
          {children}
        </Layout>
      </body>
    </html>
  );
}
