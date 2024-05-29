import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { EnofiloEntity } from 'src/entities/enofilo.entity';
import { EnofiloController } from './enofilo.controller';
import { EnofiloService } from './enofilo.service';

@Module({
  imports: [TypeOrmModule.forFeature([EnofiloEntity])],
  controllers: [EnofiloController],
  providers: [EnofiloService],
})
export class EnofiloModule {}