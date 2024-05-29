import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { ProvinciaEntity } from 'src/entities/provincia.entity';


@Injectable()
export class ProvinciaService {
    constructor(
        @InjectRepository(ProvinciaEntity)
        private readonly provinciaRepository: Repository<ProvinciaEntity>,
      ) {}
    
      findAll(): Promise<ProvinciaEntity[]> {
        return this.provinciaRepository.find();
      }
    
      create(provincia: ProvinciaEntity): Promise<ProvinciaEntity> {
        return this.provinciaRepository.save(provincia);
      }
}
