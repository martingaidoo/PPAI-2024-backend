import { PaisService } from './pais.service';
import { PaisEntity } from 'src/entities/pais.entity';
export declare class PaisController {
    private readonly paisService;
    constructor(paisService: PaisService);
    findAll(): Promise<PaisEntity[]>;
    create(pais: PaisEntity): Promise<PaisEntity>;
}
