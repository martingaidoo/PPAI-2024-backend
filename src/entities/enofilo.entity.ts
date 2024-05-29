import { BaseEntity, Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany } from 'typeorm';
import { ResenaEntity } from './resena.entity';


@Entity()
export class EnofiloEntity extends BaseEntity {
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

  @OneToMany(() => ResenaEntity, resena => resena.enofilo)
  resenas: ResenaEntity[];
}