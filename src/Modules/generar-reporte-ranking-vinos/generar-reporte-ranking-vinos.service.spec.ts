import { Test, TestingModule } from '@nestjs/testing';
import { GenerarReporteRankingVinosService } from './generar-reporte-ranking-vinos.service';

describe('GenerarReporteRankingVinosService', () => {
  let service: GenerarReporteRankingVinosService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [GenerarReporteRankingVinosService],
    }).compile();

    service = module.get<GenerarReporteRankingVinosService>(GenerarReporteRankingVinosService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
