import { Controller, Get, Post, Body } from '@nestjs/common';
import { EnofiloService } from './enofilo.service';
import { EnofiloEntity } from 'src/entities/enofilo.entity';

@Controller('enofilos')
export class EnofiloController {
  constructor(private readonly enofiloService: EnofiloService) {}

  @Get()
  findAll(): Promise<EnofiloEntity[]> {
    return this.enofiloService.findAll();
  }

  @Post()
  create(@Body() enofilo: EnofiloEntity): Promise<EnofiloEntity> {
    return this.enofiloService.create(enofilo);
  }
}