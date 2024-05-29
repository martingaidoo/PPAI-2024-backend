import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { VarietalEntity } from 'src/entities/varietal.entity';
import { VarietalController } from './varietal.controller';
import { VarietalService } from './varietal.service';

@Module({
  imports: [TypeOrmModule.forFeature([VarietalEntity])],
  controllers: [VarietalController],
  providers: [VarietalService],
})
export class VarietalModule {}
