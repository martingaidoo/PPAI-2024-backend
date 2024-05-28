import { Test, TestingModule } from '@nestjs/testing';
import { RegionVitivinicoService } from './region-vitivinico.service';

describe('RegionVitivinicoService', () => {
  let service: RegionVitivinicoService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [RegionVitivinicoService],
    }).compile();

    service = module.get<RegionVitivinicoService>(RegionVitivinicoService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
