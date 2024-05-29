import { Repository } from 'typeorm';
import { PaisEntity } from 'src/entities/pais.entity';
export declare class PaisService {
    private readonly paisRepository;
    constructor(paisRepository: Repository<PaisEntity>);
    findAll(): Promise<PaisEntity[]>;
    create(pais: PaisEntity): Promise<PaisEntity>;
}
