// enofilo.service.ts
import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { EnofiloEntity } from 'src/entities/enofilo.entity';

@Injectable()
export class EnofiloService {
  constructor(
    @InjectRepository(EnofiloEntity)
    private readonly enofiloRepository: Repository<EnofiloEntity>,
  ) {}

  findAll(): Promise<EnofiloEntity[]> {
    return this.enofiloRepository.find();
  }

  create(enofilo: EnofiloEntity): Promise<EnofiloEntity> {
    return this.enofiloRepository.save(enofilo);
  }
}