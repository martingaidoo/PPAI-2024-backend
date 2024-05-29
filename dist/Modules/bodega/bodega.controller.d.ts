import { BodegaService } from './bodega.service';
import { BodegaEntity } from 'src/entities/bodega.entity';
export declare class BodegaController {
    private readonly bodegaService;
    constructor(bodegaService: BodegaService);
    findAll(): Promise<BodegaEntity[]>;
    create(bodega: BodegaEntity): Promise<BodegaEntity>;
}
