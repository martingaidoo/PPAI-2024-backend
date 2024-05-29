import { Controller, Body, Post, Get, Put ,Param} from '@nestjs/common';
import { PaisService } from './pais.service';
import { PaisEntity } from 'src/entities/pais.entity';
import { DeepPartial } from 'typeorm';

@Controller('pais')
export class PaisController {
    constructor(private service: PaisService){}
    //@Post()
    //async createPais(@Body() pais: DeepPartial<PaisEntity>){
    //    return await this.service.createPais(pais);
    //}
    @Get()
    async findPais(): Promise<PaisEntity[]>{
        return await this.service.findPais();
    }
}