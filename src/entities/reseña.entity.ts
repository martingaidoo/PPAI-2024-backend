import e from 'express';
import { Entity, Column, PrimaryGeneratedColumn, OneToMany, BaseEntity} from 'typeorm';

@Entity ('reseña')
export class ReseñaEntity extends BaseEntity {
}