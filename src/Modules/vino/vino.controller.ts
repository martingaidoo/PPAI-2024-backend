import { Controller, Get, Post, Body } from '@nestjs/common';
import { VinoService } from './vino.service';
import { VinoEntity } from 'src/entities/vino.entity';

@Controller('vinos')
export class VinoController {
  constructor(private readonly vinoService: VinoService) {}

  @Get()
  findAll(): Promise<VinoEntity[]> {
    return this.vinoService.findAll();
  }

  @Post()
  create(@Body() vino: VinoEntity): Promise<VinoEntity> {
    return this.vinoService.create(vino);
  }
}