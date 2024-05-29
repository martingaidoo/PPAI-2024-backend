import { Controller, Get, Post, Body } from '@nestjs/common';
import { VarietalService } from './varietal.service';
import { VarietalEntity } from 'src/entities/varietal.entity';

@Controller('varietals')
export class VarietalController {
  constructor(private readonly varietalService: VarietalService) {}

  @Get()
  findAll(): Promise<VarietalEntity[]> {
    return this.varietalService.findAll();
  }

  @Post()
  create(@Body() varietal: VarietalEntity): Promise<VarietalEntity> {
    return this.varietalService.create(varietal);
  }
}