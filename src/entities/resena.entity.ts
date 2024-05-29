import { BaseEntity, Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany } from 'typeorm';
import { VinoEntity } from './vino.entity';
import { EnofiloEntity } from './enofilo.entity';

@Entity()
export class ResenaEntity extends BaseEntity{
  @PrimaryGeneratedColumn()
  id: number;

  @Column('text', { nullable: true })
  comentario: string;

  @Column()
  esPremium: boolean;

  @Column({ type: 'date', nullable: true })
  fechaResena: Date;

  @Column({ type: 'decimal', precision: 5, scale: 2, nullable: true })
  puntaje: number;

  @ManyToOne(() => VinoEntity, vino => vino.resenas)
  vino: VinoEntity;

  @ManyToOne(() => EnofiloEntity, enofilo => enofilo.resenas)
  enofilo: EnofiloEntity;
}