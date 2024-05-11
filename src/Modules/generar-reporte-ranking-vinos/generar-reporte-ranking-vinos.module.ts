import { Module } from '@nestjs/common';
import { GenerarReporteRankingVinosController } from './generar-reporte-ranking-vinos.controller';
import { GenerarReporteRankingVinosService } from './generar-reporte-ranking-vinos.service';

@Module({
  controllers: [GenerarReporteRankingVinosController],
  providers: [GenerarReporteRankingVinosService]
})
export class GenerarReporteRankingVinosModule {}
