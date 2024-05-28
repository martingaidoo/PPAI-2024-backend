import { Test, TestingModule } from '@nestjs/testing';
import { RegionVitivinicolaService } from './region-vitivinicola.service';

describe('RegionVitivinicolaService', () => {
  let service: RegionVitivinicolaService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [RegionVitivinicolaService],
    }).compile();

    service = module.get<RegionVitivinicolaService>(RegionVitivinicolaService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
