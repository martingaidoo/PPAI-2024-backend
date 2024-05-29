import { BaseEntity, Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany } from 'typeorm';
import { VinoEntity } from './vino.entity';

@Entity()
export class VarietalEntity extends BaseEntity{
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ length: 100 })
  descripcion: string;

  @Column({ type: 'decimal', precision: 5, scale: 2 })
  porcentajeComposicion: number;

  @ManyToOne(() => VinoEntity, vino => vino.varietals)
  vino: VinoEntity;
}