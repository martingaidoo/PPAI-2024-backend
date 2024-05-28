import { Module } from '@nestjs/common';
import { VinoController } from './vino.controller';
import { VinoService } from './vino.service';

@Module({
  controllers: [VinoController],
  providers: [VinoService]
})
export class VinoModule {}
