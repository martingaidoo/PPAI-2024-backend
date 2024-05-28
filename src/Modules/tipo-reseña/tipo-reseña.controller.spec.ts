import { Test, TestingModule } from '@nestjs/testing';
import { TipoReseñaController } from './tipo-reseña.controller';

describe('TipoReseñaController', () => {
  let controller: TipoReseñaController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [TipoReseñaController],
    }).compile();

    controller = module.get<TipoReseñaController>(TipoReseñaController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
