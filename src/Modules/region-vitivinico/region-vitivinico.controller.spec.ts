import { Test, TestingModule } from '@nestjs/testing';
import { RegionVitivinicoController } from './region-vitivinico.controller';

describe('RegionVitivinicoController', () => {
  let controller: RegionVitivinicoController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [RegionVitivinicoController],
    }).compile();

    controller = module.get<RegionVitivinicoController>(RegionVitivinicoController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
