import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ResenaEntity } from 'src/entities/resena.entity';
import { ResenaController } from './resena.controller';
import { ResenaService } from './resena.service';

@Module({
  imports: [TypeOrmModule.forFeature([ResenaEntity])],
  controllers: [ResenaController],
  providers: [ResenaService],
})
export class ResenaModule {}
