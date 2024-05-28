import { Test, TestingModule } from '@nestjs/testing';
import { RegionVitivinicolaController } from './region-vitivinicola.controller';

describe('RegionVitivinicolaController', () => {
  let controller: RegionVitivinicolaController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [RegionVitivinicolaController],
    }).compile();

    controller = module.get<RegionVitivinicolaController>(RegionVitivinicolaController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
