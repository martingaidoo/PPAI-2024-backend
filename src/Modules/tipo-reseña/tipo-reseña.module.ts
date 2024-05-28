import { Module } from '@nestjs/common';
import { TipoReseñaController } from './tipo-reseña.controller';
import { TipoReseñaService } from './tipo-reseña.service';

@Module({
  controllers: [TipoReseñaController],
  providers: [TipoReseñaService]
})
export class TipoReseñaModule {}
