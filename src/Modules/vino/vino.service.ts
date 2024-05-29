import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { VinoEntity } from 'src/entities/vino.entity';

@Injectable()
export class VinoService {
  constructor(
    @InjectRepository(VinoEntity)
    private readonly vinoRepository: Repository<VinoEntity>,
  ) {}

  findAll(): Promise<VinoEntity[]> {
    return this.vinoRepository.find();
  }

  create(vino: VinoEntity): Promise<VinoEntity> {
    return this.vinoRepository.save(vino);
  }
}