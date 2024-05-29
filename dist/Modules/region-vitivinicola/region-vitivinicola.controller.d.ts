import { RegionVitivinicolaService } from './region-vitivinicola.service';
import { RegionVitivinicolaEntity } from 'src/entities/regionVitivinicola.entity';
export declare class RegionVitivinicolaController {
    private readonly regionService;
    constructor(regionService: RegionVitivinicolaService);
    findAll(): Promise<RegionVitivinicolaEntity[]>;
    create(region: RegionVitivinicolaEntity): Promise<RegionVitivinicolaEntity>;
}
