import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { VarietalEntity } from 'src/entities/varietal.entity';

@Injectable()
export class VarietalService {
  constructor(
    @InjectRepository(VarietalEntity)
    private readonly varietalRepository: Repository<VarietalEntity>,
  ) {}

  findAll(): Promise<VarietalEntity[]> {
    return this.varietalRepository.find();
  }

  create(varietal: VarietalEntity): Promise<VarietalEntity> {
    return this.varietalRepository.save(varietal);
  }
}