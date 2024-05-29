import { EnofiloService } from './enofilo.service';
import { EnofiloEntity } from 'src/entities/enofilo.entity';
export declare class EnofiloController {
    private readonly enofiloService;
    constructor(enofiloService: EnofiloService);
    findAll(): Promise<EnofiloEntity[]>;
    create(enofilo: EnofiloEntity): Promise<EnofiloEntity>;
}
