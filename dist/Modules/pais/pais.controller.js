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
exports.PaisController = void 0;
const common_1 = require("@nestjs/common");
const pais_service_1 = require("./pais.service");
const pais_entity_1 = require("../../entities/pais.entity");
let PaisController = class PaisController {
    constructor(paisService) {
        this.paisService = paisService;
    }
    findAll() {
        return this.paisService.findAll();
    }
    create(pais) {
        return this.paisService.create(pais);
    }
};
exports.PaisController = PaisController;
__decorate([
    (0, common_1.Get)(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], PaisController.prototype, "findAll", null);
__decorate([
    (0, common_1.Post)(),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [pais_entity_1.PaisEntity]),
    __metadata("design:returntype", Promise)
], PaisController.prototype, "create", null);
exports.PaisController = PaisController = __decorate([
    (0, common_1.Controller)('paises'),
    __metadata("design:paramtypes", [pais_service_1.PaisService])
], PaisController);
//# sourceMappingURL=pais.controller.js.map