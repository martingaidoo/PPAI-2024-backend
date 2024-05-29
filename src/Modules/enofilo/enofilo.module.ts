import { Module } from '@nestjs/common';
import { EnofiloController } from './enofilo.controller';
import { EnofiloService } from './enofilo.service';

@Module({
  controllers: [EnofiloController],
  providers: [EnofiloService]
})
export class EnofiloModule {}
