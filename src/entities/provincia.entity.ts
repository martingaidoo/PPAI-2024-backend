import { BaseEntity, Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany } from 'typeorm';
import { PaisEntity } from './pais.entity';
import { RegionVitivinicolaEntity } from './regionVitivinicola.entity';

@Entity()
export class ProvinciaEntity extends BaseEntity{
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ length: 100 })
  nombre: string;

  @ManyToOne(() => PaisEntity, pais => pais.provincias)
  pais: PaisEntity;

  @OneToMany(() => RegionVitivinicolaEntity, region => region.provincia)
  regionesVitivinicolas: RegionVitivinicolaEntity[];
}