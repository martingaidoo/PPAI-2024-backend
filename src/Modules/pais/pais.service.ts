import { HttpException, Injectable, NotFoundException, BadRequestException } from '@nestjs/common';
import { DeepPartial, Repository} from 'typeorm';
import { PaisEntity } from '../../entities/pais.entity';

@Injectable()
export class PaisService {
    repository = PaisEntity;

//    async createPais(pais: DeepPartial<PaisEntity>){
//        try{
//            return await this.repository.save(pais);
//        }catch(error){
//            throw new HttpException('Create pais error',500);
//        }
//    }
    async findPais(){
        try {
            return await this.repository.find();
        } catch (error) {
            throw new HttpException('Find Pais type error', 500)
        }   
    }
}
