"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.RegionVitivinicolaModule = void 0;
const common_1 = require("@nestjs/common");
const typeorm_1 = require("@nestjs/typeorm");
const regionVitivinicola_entity_1 = require("../../entities/regionVitivinicola.entity");
const region_vitivinicola_controller_1 = require("./region-vitivinicola.controller");
const region_vitivinicola_service_1 = require("./region-vitivinicola.service");
let RegionVitivinicolaModule = class RegionVitivinicolaModule {
};
exports.RegionVitivinicolaModule = RegionVitivinicolaModule;
exports.RegionVitivinicolaModule = RegionVitivinicolaModule = __decorate([
    (0, common_1.Module)({
        imports: [typeorm_1.TypeOrmModule.forFeature([regionVitivinicola_entity_1.RegionVitivinicolaEntity])],
        controllers: [region_vitivinicola_controller_1.RegionVitivinicolaController],
        providers: [region_vitivinicola_service_1.RegionVitivinicolaService],
    })
], RegionVitivinicolaModule);
//# sourceMappingURL=region-vitivinicola.module.js.map