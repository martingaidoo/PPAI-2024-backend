import { BaseEntity, Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany } from 'typeorm';
import { ProvinciaEntity } from './provincia.entity';

@Entity()
export class PaisEntity extends BaseEntity{
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ length: 100 })
  nombre: string;

  @OneToMany(() => ProvinciaEntity, provincia => provincia.pais)
  provincias: ProvinciaEntity[];
}