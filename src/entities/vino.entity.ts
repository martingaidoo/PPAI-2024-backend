import { BaseEntity, Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany } from 'typeorm';
import { BodegaEntity } from './bodega.entity';
import { VarietalEntity } from './varietal.entity';
import { ResenaEntity } from './resena.entity';

@Entity()
export class VinoEntity extends BaseEntity {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ length: 100 })
  nombre: string;

  @Column({ length: 100, nullable: true })
  anada: string;

  @Column({ type: 'date', nullable: true })
  fechaActualizacion: Date;

  @Column('text', { nullable: true })
  imagenEtiqueta: string;

  @Column('text', { nullable: true })
  notaDeCataBodega: string;

  @Column({ type: 'decimal', precision: 10, scale: 2 })
  precioARS: number;

  @ManyToOne(() => BodegaEntity, bodega => bodega.vinos)
  bodega: BodegaEntity;

  @OneToMany(() => VarietalEntity, varietal => varietal.vino)
  varietals: VarietalEntity[];

  @OneToMany(() => ResenaEntity, resena => resena.vino)
  resenas: ResenaEntity[];
}