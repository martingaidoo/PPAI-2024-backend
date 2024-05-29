import { VinoService } from './vino.service';
import { VinoEntity } from 'src/entities/vino.entity';
export declare class VinoController {
    private readonly vinoService;
    constructor(vinoService: VinoService);
    findAll(): Promise<VinoEntity[]>;
    create(vino: VinoEntity): Promise<VinoEntity>;
}
