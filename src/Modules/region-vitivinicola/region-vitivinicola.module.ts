import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { RegionVitivinicolaEntity } from 'src/entities/regionVitivinicola.entity';
import { RegionVitivinicolaController } from './region-vitivinicola.controller';
import { RegionVitivinicolaService } from './region-vitivinicola.service';

@Module({
  imports: [TypeOrmModule.forFeature([RegionVitivinicolaEntity])],
  controllers: [RegionVitivinicolaController],
  providers: [RegionVitivinicolaService],
})
export class RegionVitivinicolaModule {}