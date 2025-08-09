import { Layout, Navbar } from 'nextra-theme-docs';
import { getPageMap } from 'nextra/page-map';
import 'nextra-theme-docs/style.css';

export const metadata = {
  title: 'Milky',
  description: 'Milky 协议文档',
};

const navbar = <Navbar logo={<b>Milky</b>} />;

export default async function RootLayout({ children }) {
  return (
    <html lang="zh" suppressHydrationWarning>
      <body>
        <Layout navbar={navbar} pageMap={await getPageMap()} docsRepositoryBase="https://github.com/SaltifyDev/milky">
          {children}
        </Layout>
      </body>
    </html>
  );
}
