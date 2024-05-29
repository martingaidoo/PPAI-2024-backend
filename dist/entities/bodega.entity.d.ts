import { BaseEntity } from 'typeorm';
import { RegionVitivinicolaEntity } from './regionVitivinicola.entity';
import { VinoEntity } from './vino.entity';
export declare class BodegaEntity extends BaseEntity {
    id: number;
    coordenadasUbicacion: string;
    descripcion: string;
    historia: string;
    nombre: string;
    periodoActualizacion: string;
    regionVitivinicola: RegionVitivinicolaEntity;
    vinos: VinoEntity[];
}
