import { Module } from '@nestjs/common';
import { RegionVitivinicolaController } from './region-vitivinicola.controller';
import { RegionVitivinicolaService } from './region-vitivinicola.service';

@Module({
  controllers: [RegionVitivinicolaController],
  providers: [RegionVitivinicolaService]
})
export class RegionVitivinicolaModule {}
