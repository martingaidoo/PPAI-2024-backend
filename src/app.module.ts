import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { entities } from './entities';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { GenerarReporteRankingVinosModule } from './Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.module';
import { VinoModule } from './Modules/vino/vino.module';
import { ProvinciaModule } from './Modules/provincia/provincia.module';
import { PaisModule } from './Modules/pais/pais.module';
import { ResenaModule } from './Modules/resena/resena.module';
import { RegionVitivinicolaModule } from './Modules/region-vitivinicola/region-vitivinicola.module';
import { VarietalModule } from './Modules/varietal/varietal.module';
import { BodegaModule } from './Modules/bodega/bodega.module';

@Module({
  imports: [GenerarReporteRankingVinosModule,TypeOrmModule.forRoot({
    type:'sqlite',
    database:'bonvino.db',
    entities: entities,
    synchronize:true,
  }), VinoModule, ProvinciaModule, PaisModule, ResenaModule, RegionVitivinicolaModule, VarietalModule, BodegaModule, GenerarReporteRankingVinosModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
