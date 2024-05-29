// vino.module.ts
import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { VinoEntity } from 'src/entities/vino.entity';
import { VinoController } from './vino.controller';
import { VinoService } from './vino.service';

@Module({
  imports: [TypeOrmModule.forFeature([VinoEntity])],
  controllers: [VinoController],
  providers: [VinoService],
})
export class VinoModule {}
