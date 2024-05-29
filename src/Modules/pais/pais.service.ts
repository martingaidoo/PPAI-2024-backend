import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { PaisEntity } from 'src/entities/pais.entity';

@Injectable()
export class PaisService {
  constructor(
    @InjectRepository(PaisEntity)
    private readonly paisRepository: Repository<PaisEntity>,
  ) {}

  findAll(): Promise<PaisEntity[]> {
    return this.paisRepository.find();
  }

  create(pais: PaisEntity): Promise<PaisEntity> {
    return this.paisRepository.save(pais);
  }
}
