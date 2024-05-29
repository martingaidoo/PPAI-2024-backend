import { ResenaService } from './resena.service';
import { ResenaEntity } from 'src/entities/resena.entity';
export declare class ResenaController {
    private readonly resenaService;
    constructor(resenaService: ResenaService);
    findAll(): Promise<ResenaEntity[]>;
    create(resena: ResenaEntity): Promise<ResenaEntity>;
}
