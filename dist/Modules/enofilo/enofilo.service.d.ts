import { Repository } from 'typeorm';
import { EnofiloEntity } from 'src/entities/enofilo.entity';
export declare class EnofiloService {
    private readonly enofiloRepository;
    constructor(enofiloRepository: Repository<EnofiloEntity>);
    findAll(): Promise<EnofiloEntity[]>;
    create(enofilo: EnofiloEntity): Promise<EnofiloEntity>;
}
