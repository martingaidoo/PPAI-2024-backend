import { Controller, Get, Post, Body } from '@nestjs/common';
import { ResenaService } from './resena.service';
import { ResenaEntity } from 'src/entities/resena.entity';

@Controller('resenas')
export class ResenaController {
  constructor(private readonly resenaService: ResenaService) {}

  @Get()
  findAll(): Promise<ResenaEntity[]> {
    return this.resenaService.findAll();
  }

  @Post()
  create(@Body() resena: ResenaEntity): Promise<ResenaEntity> {
    return this.resenaService.create(resena);
  }
}