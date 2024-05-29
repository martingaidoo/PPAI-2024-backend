import { ProvinciaService } from './provincia.service';
import { ProvinciaEntity } from 'src/entities/provincia.entity';
export declare class ProvinciaController {
    private readonly provinciaService;
    constructor(provinciaService: ProvinciaService);
    findAll(): Promise<ProvinciaEntity[]>;
    create(provincia: ProvinciaEntity): Promise<ProvinciaEntity>;
}
