import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { BodegaEntity } from 'src/entities/bodega.entity';

@Injectable()
export class BodegaService {
  constructor(
    @InjectRepository(BodegaEntity)
    private readonly bodegaRepository: Repository<BodegaEntity>,
  ) {}

  findAll(): Promise<BodegaEntity[]> {
    return this.bodegaRepository.find();
  }

  create(bodega: BodegaEntity): Promise<BodegaEntity> {
    return this.bodegaRepository.save(bodega);
  }
}
