import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { entities } from './entities';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { GenerarReporteRankingVinosModule } from './Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.module';
import { GenerarReporteRankingVinosController } from './Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.controller';
import { VinoModule } from './Modules/vino/vino.module';
import { ProvinciaModule } from './Modules/provincia/provincia.module';
import { PaisModule } from './Modules/pais/pais.module';
import { TipoReseñaModule } from './Modules/tipo-reseña/tipo-reseña.module';
import { ReseñaModule } from './Modules/reseña/reseña.module';
import { RegionVitivinicolaModule } from './Modules/region-vitivinicola/region-vitivinicola.module';

@Module({
  imports: [GenerarReporteRankingVinosModule,TypeOrmModule.forRoot({
    type:'sqlite',
    database:'bonvino.db',
    entities: entities,
    synchronize:true,
  }), VinoModule, ProvinciaModule, PaisModule, TipoReseñaModule, ReseñaModule, RegionVitivinicolaModule,],
  controllers: [AppController, GenerarReporteRankingVinosController],
  providers: [AppService],
})
export class AppModule {}
