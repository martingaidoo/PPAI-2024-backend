import { VarietalService } from './varietal.service';
import { VarietalEntity } from 'src/entities/varietal.entity';
export declare class VarietalController {
    private readonly varietalService;
    constructor(varietalService: VarietalService);
    findAll(): Promise<VarietalEntity[]>;
    create(varietal: VarietalEntity): Promise<VarietalEntity>;
}
