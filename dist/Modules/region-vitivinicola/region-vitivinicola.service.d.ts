import { Repository } from 'typeorm';
import { RegionVitivinicolaEntity } from 'src/entities/regionVitivinicola.entity';
export declare class RegionVitivinicolaService {
    private readonly regionRepository;
    constructor(regionRepository: Repository<RegionVitivinicolaEntity>);
    findAll(): Promise<RegionVitivinicolaEntity[]>;
    create(region: RegionVitivinicolaEntity): Promise<RegionVitivinicolaEntity>;
}
