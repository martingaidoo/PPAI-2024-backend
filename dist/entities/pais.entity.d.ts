import { BaseEntity } from 'typeorm';
import { ProvinciaEntity } from './provincia.entity';
export declare class PaisEntity extends BaseEntity {
    id: number;
    nombre: string;
    provincias: ProvinciaEntity[];
}
