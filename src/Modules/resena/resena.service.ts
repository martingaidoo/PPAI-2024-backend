import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { ResenaEntity } from 'src/entities/resena.entity';

@Injectable()
export class ResenaService {
  constructor(
    @InjectRepository(ResenaEntity)
    private readonly resenaRepository: Repository<ResenaEntity>,
  ) {}

  findAll(): Promise<ResenaEntity[]> {
    return this.resenaRepository.find();
  }

  create(resena: ResenaEntity): Promise<ResenaEntity> {
    return this.resenaRepository.save(resena);
  }
}