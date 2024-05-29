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
exports.BodegaController = void 0;
const common_1 = require("@nestjs/common");
const bodega_service_1 = require("./bodega.service");
const bodega_entity_1 = require("../../entities/bodega.entity");
let BodegaController = class BodegaController {
    constructor(bodegaService) {
        this.bodegaService = bodegaService;
    }
    findAll() {
        return this.bodegaService.findAll();
    }
    create(bodega) {
        return this.bodegaService.create(bodega);
    }
};
exports.BodegaController = BodegaController;
__decorate([
    (0, common_1.Get)(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], BodegaController.prototype, "findAll", null);
__decorate([
    (0, common_1.Post)(),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [bodega_entity_1.BodegaEntity]),
    __metadata("design:returntype", Promise)
], BodegaController.prototype, "create", null);
exports.BodegaController = BodegaController = __decorate([
    (0, common_1.Controller)('bodegas'),
    __metadata("design:paramtypes", [bodega_service_1.BodegaService])
], BodegaController);
//# sourceMappingURL=bodega.controller.js.map