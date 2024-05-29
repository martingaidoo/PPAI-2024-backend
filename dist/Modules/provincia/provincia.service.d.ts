import { Repository } from 'typeorm';
import { ProvinciaEntity } from 'src/entities/provincia.entity';
export declare class ProvinciaService {
    private readonly provinciaRepository;
    constructor(provinciaRepository: Repository<ProvinciaEntity>);
    findAll(): Promise<ProvinciaEntity[]>;
    create(provincia: ProvinciaEntity): Promise<ProvinciaEntity>;
}
