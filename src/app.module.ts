import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { GenerarReporteRankingVinosModule } from './Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.module';
import { GenerarReporteRankingVinosController } from './Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.controller';
import { PaisModule } from './Modules/pais/pais.module';
import { ProvinciaModule } from './Modules/provincia/provincia.module';
import { RegionVitivinicolaModule } from './Modules/region-vitivinicola/region-vitivinicola.module';
import { ReseñaModule } from './Modules/reseña/reseña.module';
import { TipoReseñaModule } from './Modules/tipo-reseña/tipo-reseña.module';
import { VinoModule } from './Modules/vino/vino.module';

@Module({
  imports: [GenerarReporteRankingVinosModule, PaisModule, ProvinciaModule, RegionVitivinicolaModule, ReseñaModule, TipoReseñaModule, VinoModule],
  controllers: [AppController, GenerarReporteRankingVinosController],
  providers: [AppService],
})
export class AppModule {}
