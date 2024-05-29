import { BaseEntity } from 'typeorm';
import { ProvinciaEntity } from './provincia.entity';
import { BodegaEntity } from './bodega.entity';
export declare class RegionVitivinicolaEntity extends BaseEntity {
    id: number;
    nombre: string;
    descripcion: string;
    provincia: ProvinciaEntity;
    bodegas: BodegaEntity[];
}
