import { BaseEntity, Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany } from 'typeorm';
import { RegionVitivinicolaEntity } from './regionVitivinicola.entity';
import { VinoEntity } from './vino.entity';

@Entity()
export class BodegaEntity extends BaseEntity{
  @PrimaryGeneratedColumn()
  id: number;

  @Column('text', { nullable: true })
  coordenadasUbicacion: string;

  @Column('text', { nullable: true })
  descripcion: string;

  @Column('text', { nullable: true })
  historia: string;

  @Column({ length: 100 })
  nombre: string;

  @Column({ length: 100, nullable: true })
  periodoActualizacion: string;

  @ManyToOne(() => RegionVitivinicolaEntity, region => region.bodegas)
  regionVitivinicola: RegionVitivinicolaEntity;

  @OneToMany(() => VinoEntity, vino => vino.bodega)
  vinos: VinoEntity[];
}