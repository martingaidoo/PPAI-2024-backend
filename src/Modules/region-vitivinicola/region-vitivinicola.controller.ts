import { Controller, Get, Post, Body } from '@nestjs/common';
import { RegionVitivinicolaService } from './region-vitivinicola.service';
import { RegionVitivinicolaEntity } from 'src/entities/regionVitivinicola.entity';

@Controller('regiones-vitivinicolas')
export class RegionVitivinicolaController {
  constructor(private readonly regionService: RegionVitivinicolaService) {}

  @Get()
  findAll(): Promise<RegionVitivinicolaEntity[]> {
    return this.regionService.findAll();
  }

  @Post()
  create(@Body() region: RegionVitivinicolaEntity): Promise<RegionVitivinicolaEntity> {
    return this.regionService.create(region);
  }
}