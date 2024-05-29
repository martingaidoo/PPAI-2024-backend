import { BaseEntity } from 'typeorm';
import { BodegaEntity } from './bodega.entity';
import { VarietalEntity } from './varietal.entity';
import { ResenaEntity } from './resena.entity';
export declare class VinoEntity extends BaseEntity {
    id: number;
    nombre: string;
    anada: string;
    fechaActualizacion: Date;
    imagenEtiqueta: string;
    notaDeCataBodega: string;
    precioARS: number;
    bodega: BodegaEntity;
    varietals: VarietalEntity[];
    resenas: ResenaEntity[];
}
