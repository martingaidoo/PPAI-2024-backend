import { Test, TestingModule } from '@nestjs/testing';
import { VinoService } from './vino.service';

describe('VinoService', () => {
  let service: VinoService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [VinoService],
    }).compile();

    service = module.get<VinoService>(VinoService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
