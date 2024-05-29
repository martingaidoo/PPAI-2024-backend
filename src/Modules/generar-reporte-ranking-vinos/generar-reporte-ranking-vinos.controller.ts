import { Controller } from '@nestjs/common';
import { Get } from '@nestjs/common';
import { GenerarReporteRankingVinosService } from './generar-reporte-ranking-vinos.service';

@Controller('gestor-generar-reporte-ranking-vinos')
export class GenerarReporteRankingVinosController {
    constructor(private readonly generarReporteRankingVinosService: GenerarReporteRankingVinosService) {}
    
    @Get("opcion-generar-ranking-de-vinos")
    opcionGenerarReporteRankingDeVinos(){
        return this.generarReporteRankingVinosService.opcionGenerarReporteRankingDeVinos()
    }

}
