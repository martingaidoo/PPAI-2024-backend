"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.PaisService = void 0;
const common_1 = require("@nestjs/common");
const pais_entity_1 = require("../../entities/pais.entity");
let PaisService = class PaisService {
    constructor() {
        this.repository = pais_entity_1.PaisEntity;
    }
    async findPais() {
        try {
            return await this.repository.find();
        }
        catch (error) {
            throw new common_1.HttpException('Find Pais type error', 500);
        }
    }
};
exports.PaisService = PaisService;
exports.PaisService = PaisService = __decorate([
    (0, common_1.Injectable)()
], PaisService);
//# sourceMappingURL=pais.service.js.map