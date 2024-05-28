import { Module } from '@nestjs/common';
import { RegionVitivinicoController } from './region-vitivinico.controller';
import { RegionVitivinicoService } from './region-vitivinico.service';

@Module({
  controllers: [RegionVitivinicoController],
  providers: [RegionVitivinicoService]
})
export class RegionVitivinicoModule {}
