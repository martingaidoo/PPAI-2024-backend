import { Test, TestingModule } from '@nestjs/testing';
import { GenerarReporteRankingVinosController } from './generar-reporte-ranking-vinos.controller';

describe('GenerarReporteRankingVinosController', () => {
  let controller: GenerarReporteRankingVinosController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [GenerarReporteRankingVinosController],
    }).compile();

    controller = module.get<GenerarReporteRankingVinosController>(GenerarReporteRankingVinosController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
