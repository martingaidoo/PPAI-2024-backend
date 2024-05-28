import { Test, TestingModule } from '@nestjs/testing';
import { TipoReseñaService } from './tipo-reseña.service';

describe('TipoReseñaService', () => {
  let service: TipoReseñaService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [TipoReseñaService],
    }).compile();

    service = module.get<TipoReseñaService>(TipoReseñaService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
