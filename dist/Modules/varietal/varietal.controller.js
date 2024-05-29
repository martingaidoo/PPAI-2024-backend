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
exports.VarietalController = void 0;
const common_1 = require("@nestjs/common");
const varietal_service_1 = require("./varietal.service");
const varietal_entity_1 = require("../../entities/varietal.entity");
let VarietalController = class VarietalController {
    constructor(varietalService) {
        this.varietalService = varietalService;
    }
    findAll() {
        return this.varietalService.findAll();
    }
    create(varietal) {
        return this.varietalService.create(varietal);
    }
};
exports.VarietalController = VarietalController;
__decorate([
    (0, common_1.Get)(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], VarietalController.prototype, "findAll", null);
__decorate([
    (0, common_1.Post)(),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [varietal_entity_1.VarietalEntity]),
    __metadata("design:returntype", Promise)
], VarietalController.prototype, "create", null);
exports.VarietalController = VarietalController = __decorate([
    (0, common_1.Controller)('varietals'),
    __metadata("design:paramtypes", [varietal_service_1.VarietalService])
], VarietalController);
//# sourceMappingURL=varietal.controller.js.map