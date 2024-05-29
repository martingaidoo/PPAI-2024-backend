import { BaseEntity, Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany } from 'typeorm';
import { ProvinciaEntity } from './provincia.entity';
import { BodegaEntity } from './bodega.entity';

@Entity()
export class RegionVitivinicolaEntity extends BaseEntity {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ length: 100 })
  nombre: string;

  @Column('text', { nullable: true })
  descripcion: string;

  @ManyToOne(() => ProvinciaEntity, provincia => provincia.regionesVitivinicolas)
  provincia: ProvinciaEntity;

  @OneToMany(() => BodegaEntity, bodega => bodega.regionVitivinicola)
  bodegas: BodegaEntity[];
}