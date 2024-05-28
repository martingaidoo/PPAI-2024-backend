import { Module } from '@nestjs/common';
import { ReseñaController } from './reseña.controller';
import { ReseñaService } from './reseña.service';

@Module({
  controllers: [ReseñaController],
  providers: [ReseñaService]
})
export class ReseñaModule {}
