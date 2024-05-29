import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { RegionVitivinicolaEntity } from 'src/entities/regionVitivinicola.entity';

@Injectable()
export class RegionVitivinicolaService {
  constructor(
    @InjectRepository(RegionVitivinicolaEntity)
    private readonly regionRepository: Repository<RegionVitivinicolaEntity>,
  ) {}

  findAll(): Promise<RegionVitivinicolaEntity[]> {
    return this.regionRepository.find();
  }

  create(region: RegionVitivinicolaEntity): Promise<RegionVitivinicolaEntity> {
    return this.regionRepository.save(region);
  }
}