import { Controller, Body, Post, Get, Put ,Param} from '@nestjs/common';
import { ProvinciaService } from './provincia.service';
import { ProvinciaEntity } from 'src/entities/provincia.entity';

@Controller('provincia')
export class ProvinciaController {
    constructor(private readonly provinciaService: ProvinciaService) {}
    @Get()
    findAll(): Promise<ProvinciaEntity[]> {
        return this.provinciaService.findAll();
    }
    @Post()
    create(@Body() provincia: ProvinciaEntity): Promise<ProvinciaEntity> {
        return this.provinciaService.create(provincia);
    }
}
