import {
  FriendCategoryEntity,
  FriendEntity,
  FriendRequest,
  GroupAnnouncementEntity,
  GroupEntity,
  GroupFileEntity,
  GroupFolderEntity,
  GroupInvitation,
  GroupMemberEntity,
  GroupRequest,
  IncomingForwardedMessage,
  IncomingMessage,
  IncomingSegment,
  OutgoingForwardedMessage,
  OutgoingSegment,
} from '@saltify/milky-types';
import { Table } from 'nextra/components';
import { JSX } from 'react';
import {
  ZodArray,
  ZodBoolean,
  ZodDiscriminatedUnion,
  ZodEnum,
  ZodLazy,
  ZodNumber,
  ZodObject,
  ZodOptional,
  ZodString,
  ZodType,
} from 'zod';
import { $ZodType, toJSONSchema } from 'zod/v4/core';

export const commonStructs = {
  FriendEntity,
  FriendCategoryEntity,
  GroupEntity,
  GroupMemberEntity,
  GroupAnnouncementEntity,
  GroupFileEntity,
  GroupFolderEntity,
  FriendRequest,
  GroupRequest,
  GroupInvitation,
  IncomingMessage,
  IncomingForwardedMessage,
  IncomingSegment,
  OutgoingForwardedMessage,
  OutgoingSegment,
} satisfies Record<string, ZodType>;

const commonStructNames = new Map<ZodType, string>(
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
  if (type instanceof ZodLazy) {
    return renderTypeName(type.unwrap());
  }
  if (type instanceof ZodObject) {
    if (commonStructNames.has(type)) {
      return commonStructNames.get(type)!; // TODO
    }
  }
  return 'Unknown struct, consult the developers to register it';
}

function renderZodObject(struct: ZodObject) {
  return (
    <Table>
      <thead>
        <Table.Tr>
          <Table.Th>字段名</Table.Th>
          <Table.Th>类型</Table.Th>
          <Table.Th>描述</Table.Th>
        </Table.Tr>
      </thead>
      <tbody>
        {Object.entries(struct.shape).map(([key, value]) => (
          <Table.Tr key={key}>
            <Table.Td>{key}</Table.Td>
            <Table.Td>{renderTypeName(value)}</Table.Td>
            <Table.Td>{value.description}</Table.Td>
          </Table.Tr>
        ))}
      </tbody>
    </Table>
  );
}

export default function StructRenderer(props: { struct: ZodType }) {
  if (props.struct instanceof ZodObject) {
    return renderZodObject(props.struct);
  }
  return <></>;
}
