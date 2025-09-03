import { z, ZodVoid } from 'zod';
import { milkyVersion, milkyPackageVersion } from '@saltify/milky-types';
import { commonStructs, apiCategories } from '@saltify/milky-types/api';

Object.entries(commonStructs).forEach(([name, schema]) => {
  z.globalRegistry.add(schema, { id: name, description: schema.description });
});

Object.entries(apiCategories).forEach(([, category]) => {
  category.apis.forEach((api) => {
    z.globalRegistry.add(api.inputStruct, { id: `Api_${api.endpoint}_input` });
    if (!(api.outputStruct instanceof ZodVoid)) {
      z.globalRegistry.add(api.outputStruct, { id: `Api_${api.endpoint}_output` });
    }
  });
});

export * from '@saltify/milky-types/api';
export const jsonSchemas = {
  milkyVersion: milkyVersion,
  packageVersion: milkyPackageVersion,
  schemas: z.toJSONSchema(z.globalRegistry, {
    metadata: z.globalRegistry,
  }).schemas,
};
