import { Test, TestingModule } from '@nestjs/testing';
import { VinoController } from './vino.controller';

describe('VinoController', () => {
  let controller: VinoController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [VinoController],
    }).compile();

    controller = module.get<VinoController>(VinoController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
