import e from 'express';
import { Entity, Column, PrimaryGeneratedColumn, OneToMany, BaseEntity} from 'typeorm';

@Entity ('vino')
export class VinoEntity extends BaseEntity {
}