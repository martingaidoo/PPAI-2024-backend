import { PaisEntity } from '../../entities/pais.entity';
export declare class PaisService {
    repository: typeof PaisEntity;
    findPais(): Promise<PaisEntity[]>;
}
