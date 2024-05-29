"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.ResenaModule = void 0;
const common_1 = require("@nestjs/common");
const typeorm_1 = require("@nestjs/typeorm");
const resena_entity_1 = require("../../entities/resena.entity");
const resena_controller_1 = require("./resena.controller");
const resena_service_1 = require("./resena.service");
let ResenaModule = class ResenaModule {
};
exports.ResenaModule = ResenaModule;
exports.ResenaModule = ResenaModule = __decorate([
    (0, common_1.Module)({
        imports: [typeorm_1.TypeOrmModule.forFeature([resena_entity_1.ResenaEntity])],
        controllers: [resena_controller_1.ResenaController],
        providers: [resena_service_1.ResenaService],
    })
], ResenaModule);
//# sourceMappingURL=resena.module.js.map