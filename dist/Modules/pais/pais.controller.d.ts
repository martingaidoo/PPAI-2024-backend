import { PaisService } from './pais.service';
import { PaisEntity } from 'src/entities/pais.entity';
export declare class PaisController {
    private service;
    constructor(service: PaisService);
    findPais(): Promise<PaisEntity[]>;
}
