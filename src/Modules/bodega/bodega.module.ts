import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { BodegaEntity } from 'src/entities/bodega.entity';
import { BodegaController } from './bodega.controller';
import { BodegaService } from './bodega.service';

@Module({
  imports: [TypeOrmModule.forFeature([BodegaEntity])],
  controllers: [BodegaController],
  providers: [BodegaService],
})
export class BodegaModule {}
