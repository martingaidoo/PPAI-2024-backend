import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { GenerarReporteRankingVinosModule } from './Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.module';
import { GenerarReporteRankingVinosController } from './Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.controller';

@Module({
  imports: [GenerarReporteRankingVinosModule],
  controllers: [AppController, GenerarReporteRankingVinosController],
  providers: [AppService],
})
export class AppModule {}
