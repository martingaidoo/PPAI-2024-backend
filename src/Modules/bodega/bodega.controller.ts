import { Controller, Body, Post, Get, Put ,Param} from '@nestjs/common';
import { BodegaService } from './bodega.service';
import { BodegaEntity } from 'src/entities/bodega.entity';

@Controller('bodegas')
export class BodegaController {
  constructor(private readonly bodegaService: BodegaService) {}

  @Get()
  findAll(): Promise<BodegaEntity[]> {
    return this.bodegaService.findAll();
  }
  @Post()
  create(@Body() bodega: BodegaEntity): Promise<BodegaEntity> {
    return this.bodegaService.create(bodega);
  }
}