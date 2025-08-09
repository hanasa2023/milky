import StructRenderer, { commonStructs } from '@/component/StructRenderer';
import { useMDXComponents as getMDXComponents } from '../../../mdx-components';

const Wrapper = getMDXComponents().wrapper;

export function generateStaticParams() {
  return Object.keys(commonStructs).map((name) => ({
    commonEntityName: name,
  }));
}

export default async function Page(props) {
  const params = await props.params;
  const entity = commonStructs[params.commonEntityName];
  return (
    <Wrapper
      toc={[]}
      metadata={{
        title: entity.description,
      }}
    >
      <p
        className="x:tracking-tight x:text-slate-900 x:dark:text-slate-100 x:mt-2 x:text-4xl"
        style={{ fontSize: '2.25rem', marginBottom: '0.5em' }}
      >
        <b>{entity.description}</b> ({params.commonEntityName})
      </p>
      <StructRenderer struct={entity} />
    </Wrapper>
  );
}
