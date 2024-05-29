import { Injectable } from '@nestjs/common';

@Injectable()
export class GenerarReporteRankingVinosService {

    opcionGenerarReporteRankingDeVinos(){
        return {"mensaje": "Generar reporte ranking de vinos"}
    }
}
