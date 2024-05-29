"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.RegionVitivinicolaController = void 0;
const common_1 = require("@nestjs/common");
const region_vitivinicola_service_1 = require("./region-vitivinicola.service");
const regionVitivinicola_entity_1 = require("../../entities/regionVitivinicola.entity");
let RegionVitivinicolaController = class RegionVitivinicolaController {
    constructor(regionService) {
        this.regionService = regionService;
    }
    findAll() {
        return this.regionService.findAll();
    }
    create(region) {
        return this.regionService.create(region);
    }
};
exports.RegionVitivinicolaController = RegionVitivinicolaController;
__decorate([
    (0, common_1.Get)(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], RegionVitivinicolaController.prototype, "findAll", null);
__decorate([
    (0, common_1.Post)(),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [regionVitivinicola_entity_1.RegionVitivinicolaEntity]),
    __metadata("design:returntype", Promise)
], RegionVitivinicolaController.prototype, "create", null);
exports.RegionVitivinicolaController = RegionVitivinicolaController = __decorate([
    (0, common_1.Controller)('regiones-vitivinicolas'),
    __metadata("design:paramtypes", [region_vitivinicola_service_1.RegionVitivinicolaService])
], RegionVitivinicolaController);
//# sourceMappingURL=region-vitivinicola.controller.js.map