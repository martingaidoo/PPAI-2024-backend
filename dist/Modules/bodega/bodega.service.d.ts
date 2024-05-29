import { Repository } from 'typeorm';
import { BodegaEntity } from 'src/entities/bodega.entity';
export declare class BodegaService {
    private readonly bodegaRepository;
    constructor(bodegaRepository: Repository<BodegaEntity>);
    findAll(): Promise<BodegaEntity[]>;
    create(bodega: BodegaEntity): Promise<BodegaEntity>;
}
