import { BaseEntity } from 'typeorm';
import { PaisEntity } from './pais.entity';
import { RegionVitivinicolaEntity } from './regionVitivinicola.entity';
export declare class ProvinciaEntity extends BaseEntity {
    id: number;
    nombre: string;
    pais: PaisEntity;
    regionesVitivinicolas: RegionVitivinicolaEntity[];
}
