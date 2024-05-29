import { BaseEntity } from 'typeorm';
import { ResenaEntity } from './resena.entity';
export declare class EnofiloEntity extends BaseEntity {
    id: number;
    comentario: string;
    esPremium: boolean;
    fechaResena: Date;
    puntaje: number;
    resenas: ResenaEntity[];
}
