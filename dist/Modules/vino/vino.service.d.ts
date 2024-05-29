import { Repository } from 'typeorm';
import { VinoEntity } from 'src/entities/vino.entity';
export declare class VinoService {
    private readonly vinoRepository;
    constructor(vinoRepository: Repository<VinoEntity>);
    findAll(): Promise<VinoEntity[]>;
    create(vino: VinoEntity): Promise<VinoEntity>;
}
