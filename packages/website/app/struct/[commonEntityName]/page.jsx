import StructRenderer from '@/component/StructRenderer';
import { commonStructs } from '@/app/common';
import { useMDXComponents as getMDXComponents } from '../../../mdx-components';
import { ZodDiscriminatedUnion } from 'zod';

const Wrapper = getMDXComponents().wrapper;

export async function generateMetadata(props) {
  const params = await props.params;
  return {
    title: `🥛 Milky | ${commonStructs[params.commonEntityName].description} (${params.commonEntityName})`,
  };
}

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
      toc={entity instanceof ZodDiscriminatedUnion ? entity.options.map((option) => {
        const discriminatorValue = option.shape[entity.def.discriminator].value;
        return {
          depth: 2,
          value: option.description,
          id: `type-${discriminatorValue}`,
        }
      }) : []}
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
