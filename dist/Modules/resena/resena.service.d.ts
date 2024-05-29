import { Repository } from 'typeorm';
import { ResenaEntity } from 'src/entities/resena.entity';
export declare class ResenaService {
    private readonly resenaRepository;
    constructor(resenaRepository: Repository<ResenaEntity>);
    findAll(): Promise<ResenaEntity[]>;
    create(resena: ResenaEntity): Promise<ResenaEntity>;
}
