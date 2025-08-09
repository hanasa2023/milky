import { Layout, Navbar } from 'nextra-theme-docs';
import { getPageMap } from 'nextra/page-map';
import 'nextra-theme-docs/style.css';
import '@fontsource-variable/inter';
import '@fontsource-variable/noto-sans-sc';
import './styles.css';
import { commonStructs } from '@/component/StructRenderer';

export const metadata = {
  title: 'Milky',
  description: 'Milky 协议文档',
};

const navbar = <Navbar logo={<b>Milky</b>} />;

export default async function RootLayout({ children }) {
  return (
    <html lang="zh" suppressHydrationWarning>
      <body>
        <Layout navbar={navbar} pageMap={[
          ...await getPageMap(),
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
          }
        ]} docsRepositoryBase="https://github.com/SaltifyDev/milky">
          {children}
        </Layout>
      </body>
    </html>
  );
}
