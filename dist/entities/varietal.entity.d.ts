import { BaseEntity } from 'typeorm';
import { VinoEntity } from './vino.entity';
export declare class VarietalEntity extends BaseEntity {
    id: number;
    descripcion: string;
    porcentajeComposicion: number;
    vino: VinoEntity;
}
