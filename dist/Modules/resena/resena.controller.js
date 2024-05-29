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
exports.ResenaController = void 0;
const common_1 = require("@nestjs/common");
const resena_service_1 = require("./resena.service");
const resena_entity_1 = require("../../entities/resena.entity");
let ResenaController = class ResenaController {
    constructor(resenaService) {
        this.resenaService = resenaService;
    }
    findAll() {
        return this.resenaService.findAll();
    }
    create(resena) {
        return this.resenaService.create(resena);
    }
};
exports.ResenaController = ResenaController;
__decorate([
    (0, common_1.Get)(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], ResenaController.prototype, "findAll", null);
__decorate([
    (0, common_1.Post)(),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [resena_entity_1.ResenaEntity]),
    __metadata("design:returntype", Promise)
], ResenaController.prototype, "create", null);
exports.ResenaController = ResenaController = __decorate([
    (0, common_1.Controller)('resenas'),
    __metadata("design:paramtypes", [resena_service_1.ResenaService])
], ResenaController);
//# sourceMappingURL=resena.controller.js.map