import { commonStructs } from '@/app/common';
import { Link } from 'nextra-theme-docs';
import { Table } from 'nextra/components';
import { JSX } from 'react';
import {
  ZodArray,
  ZodBoolean,
  ZodDefault,
  ZodDiscriminatedUnion,
  ZodEnum,
  ZodLazy,
  ZodLiteral,
  ZodNumber,
  ZodObject,
  ZodOptional,
  ZodString,
  ZodType,
} from 'zod';
import { $ZodType } from 'zod/v4/core';

const commonStructNames = new Map<$ZodType, string>(
  Object.entries(commonStructs).map(([name, struct]) => [struct, name])
);

function renderTypeName(type: $ZodType): JSX.Element | string {
  if (type instanceof ZodArray) {
    return <>{renderTypeName(type.element)}[]</>;
  }
  if (type instanceof ZodNumber) {
    return (type.meta()?.scalarType as string | undefined) ?? 'int32';
  }
  if (type instanceof ZodBoolean) {
    return 'boolean';
  }
  if (type instanceof ZodString) {
    return 'string';
  }
  if (type instanceof ZodEnum) {
    return type.options.map((e) => JSON.stringify(e)).join(' | ');
  }
  if (type instanceof ZodOptional) {
    return <>{renderTypeName(type.unwrap())} (optional)</>;
  }
  if (type instanceof ZodDefault) {
    return <>{renderTypeName(type.unwrap())} (default: {JSON.stringify(type.def.defaultValue)})</>;
  }
  if (type instanceof ZodLazy) {
    return renderTypeName(type.unwrap());
  }
  if (commonStructNames.has(type)) {
    return renderCommonStructName(type);
  }
  return 'Unknown struct, consult the developers to register it';
}

function renderCommonStructName(type: $ZodType): JSX.Element {
  const structName = commonStructNames.get(type)!;
  return <Link href={`/struct/${structName}`}>{structName}</Link>;
}

function renderZodObject(struct: ZodObject) {
  if (Object.keys(struct.shape).length === 0) {
    return <p style={{ marginTop: '1rem' }}>此对象无字段，请传入 {'{}'}。</p>;
  }
  return (
    <div style={{ marginTop: '1rem' }}>
      <Table>
        <thead>
          <Table.Tr>
            <Table.Th>字段名</Table.Th>
            <Table.Th>类型</Table.Th>
            <Table.Th>描述</Table.Th>
          </Table.Tr>
        </thead>
        <tbody>{Object.entries<ZodType>(struct.shape).map(([key, value]) => renderZodObjectRow(key, value))}</tbody>
      </Table>
    </div>
  );
}

function renderZodObjectRow(key: string, ztype: ZodType) {
  return (
    <Table.Tr key={key}>
      <Table.Td>{key}</Table.Td>
      <Table.Td>{renderTypeName(ztype)}</Table.Td>
      <Table.Td>{ztype.description}</Table.Td>
    </Table.Tr>
  );
}

function renderZodDiscriminatedUnion(struct: ZodDiscriminatedUnion) {
  const keysList = struct.options.map((option) => {
    if (option instanceof ZodObject) {
      return Object.keys(option.shape);
    } else {
      throw new Error('Expected ZodDiscriminatedUnion to contain ZodObject');
    }
  });
  // Check if all options have the same keys
  if (keysList.every((keys) => keys.length === keysList[0].length && keys.every((key) => keysList[0].includes(key)))) {
    if (!keysList[0].includes('data')) {
      throw new Error('Expected all options to have a "data" field');
    }
    const commonKeys = keysList[0].filter((key) => key !== 'data' && key !== struct.def.discriminator);
    const firstOption = struct.options[0];
    if (!(firstOption instanceof ZodObject)) {
      throw new Error('Expected first option to be a ZodObject');
    }
    return (
      <div
        style={{
          display: 'flex',
          flexDirection: 'column',
          marginTop: '1rem',
          gap: '1rem',
        }}
      >
        <Table>
          <thead>
            <Table.Tr>
              <Table.Th>字段名</Table.Th>
              <Table.Th>类型</Table.Th>
              <Table.Th>描述</Table.Th>
            </Table.Tr>
          </thead>
          <tbody>
            <Table.Tr>
              <Table.Td>{struct.def.discriminator}</Table.Td>
              <Table.Td>string</Table.Td>
              <Table.Td>类型区分字段</Table.Td>
            </Table.Tr>
            {commonKeys.map((key) => renderZodObjectRow(key, firstOption.shape[key]))}
            <Table.Tr>
              <Table.Td>data</Table.Td>
              <Table.Td>object</Table.Td>
              <Table.Td>与 {struct.def.discriminator} 有关</Table.Td>
            </Table.Tr>
          </tbody>
        </Table>
        <p>data 在不同 {struct.def.discriminator} 下的具体类型如下：</p>
        {struct.options.map((option) => {
          if (!(option instanceof ZodObject)) {
            throw new Error('Expected option to be a ZodObject');
          }
          const discriminatorValue = (option.shape[struct.def.discriminator] as ZodLiteral).value as string;
          return (
            <div id={`type-${discriminatorValue}`} key={discriminatorValue} style={{ marginTop: '2rem' }}>
              <pre style={{ fontSize: '120%' }}>
                <b>
                  {struct.def.discriminator} = "{discriminatorValue}" {'->'} {option.description}
                </b>
              </pre>
              {option.shape.data instanceof ZodLazy ? (
                <p style={{ marginTop: '1rem' }}>
                  参见 {renderCommonStructName(option.shape.data.unwrap())}
                </p> // todo
              ) : commonStructNames.has(option.shape.data) ? (
                <p style={{ marginTop: '1rem' }}>参见 {renderCommonStructName(option.shape.data)}</p>
              ) : (
                <StructRenderer struct={option.shape.data} />
              )}
            </div>
          );
        })}
      </div>
    );
  } else {
    return (
      <div
        style={{
          display: 'flex',
          flexDirection: 'column',
          marginTop: '1rem',
          gap: '1rem',
        }}
      >
        <p>可能的类型如下：</p>
        {struct.options.map((option) => {
          if (!(option instanceof ZodObject)) {
            throw new Error('Expected option to be a ZodObject');
          }
          const discriminatorValue = (option.shape[struct.def.discriminator] as ZodLiteral).value as string;
          return (
            <div key={discriminatorValue}>
              <Table>
                <thead>
                  <Table.Tr>
                    <Table.Th>字段名</Table.Th>
                    <Table.Th>类型</Table.Th>
                    <Table.Th>描述</Table.Th>
                  </Table.Tr>
                </thead>
                <tbody>
                  <Table.Tr>
                    <Table.Td>{struct.def.discriminator}</Table.Td>
                    <Table.Td>"{discriminatorValue}"</Table.Td>
                    <Table.Td>表示{option.description}</Table.Td>
                  </Table.Tr>
                  {Object.entries<ZodType>(option.shape)
                    .filter(([key]) => key !== struct.def.discriminator)
                    .map(([key, value]) => renderZodObjectRow(key, value))}
                </tbody>
              </Table>
            </div>
          );
        })}
      </div>
    );
  }
}

export default function StructRenderer(props: { struct: ZodType }) {
  if (props.struct instanceof ZodObject) {
    return renderZodObject(props.struct);
  }
  if (props.struct instanceof ZodDiscriminatedUnion) {
    return renderZodDiscriminatedUnion(props.struct);
  }
  return <>unsupported type</>;
}
