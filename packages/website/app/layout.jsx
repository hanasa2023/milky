import { Layout, Navbar } from 'nextra-theme-docs';
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
import { commonStructs } from '@/component/StructRenderer';

export const metadata = {
  title: '🥛 Milky',
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
