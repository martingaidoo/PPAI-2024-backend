// pais.controller.ts
import { Controller, Get, Post, Body } from '@nestjs/common';
import { PaisService } from './pais.service';
import { PaisEntity } from 'src/entities/pais.entity';

@Controller('paises')
export class PaisController {
  constructor(private readonly paisService: PaisService) {}

  @Get()
  findAll(): Promise<PaisEntity[]> {
    return this.paisService.findAll();
  }

  @Post()
  create(@Body() pais: PaisEntity): Promise<PaisEntity> {
    return this.paisService.create(pais);
  }
}
