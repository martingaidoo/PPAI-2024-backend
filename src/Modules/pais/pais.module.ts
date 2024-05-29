import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { PaisEntity } from 'src/entities/pais.entity';
import { PaisController } from './pais.controller';
import { PaisService } from './pais.service';

@Module({
  imports: [TypeOrmModule.forFeature([PaisEntity])],
  controllers: [PaisController],
  providers: [PaisService],
})
export class PaisModule {}