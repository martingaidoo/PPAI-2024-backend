import { Repository } from 'typeorm';
import { VarietalEntity } from 'src/entities/varietal.entity';
export declare class VarietalService {
    private readonly varietalRepository;
    constructor(varietalRepository: Repository<VarietalEntity>);
    findAll(): Promise<VarietalEntity[]>;
    create(varietal: VarietalEntity): Promise<VarietalEntity>;
}
