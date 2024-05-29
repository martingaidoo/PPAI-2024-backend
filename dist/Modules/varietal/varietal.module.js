"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.VarietalModule = void 0;
const common_1 = require("@nestjs/common");
const typeorm_1 = require("@nestjs/typeorm");
const varietal_entity_1 = require("../../entities/varietal.entity");
const varietal_controller_1 = require("./varietal.controller");
const varietal_service_1 = require("./varietal.service");
let VarietalModule = class VarietalModule {
};
exports.VarietalModule = VarietalModule;
exports.VarietalModule = VarietalModule = __decorate([
    (0, common_1.Module)({
        imports: [typeorm_1.TypeOrmModule.forFeature([varietal_entity_1.VarietalEntity])],
        controllers: [varietal_controller_1.VarietalController],
        providers: [varietal_service_1.VarietalService],
    })
], VarietalModule);
//# sourceMappingURL=varietal.module.js.map