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
Object.defineProperty(exports, "__esModule", { value: true });
exports.VarietalEntity = void 0;
const typeorm_1 = require("typeorm");
const vino_entity_1 = require("./vino.entity");
let VarietalEntity = class VarietalEntity extends typeorm_1.BaseEntity {
};
exports.VarietalEntity = VarietalEntity;
__decorate([
    (0, typeorm_1.PrimaryGeneratedColumn)(),
    __metadata("design:type", Number)
], VarietalEntity.prototype, "id", void 0);
__decorate([
    (0, typeorm_1.Column)({ length: 100 }),
    __metadata("design:type", String)
], VarietalEntity.prototype, "descripcion", void 0);
__decorate([
    (0, typeorm_1.Column)({ type: 'decimal', precision: 5, scale: 2 }),
    __metadata("design:type", Number)
], VarietalEntity.prototype, "porcentajeComposicion", void 0);
__decorate([
    (0, typeorm_1.ManyToOne)(() => vino_entity_1.VinoEntity, vino => vino.varietals),
    __metadata("design:type", vino_entity_1.VinoEntity)
], VarietalEntity.prototype, "vino", void 0);
exports.VarietalEntity = VarietalEntity = __decorate([
    (0, typeorm_1.Entity)()
], VarietalEntity);
//# sourceMappingURL=varietal.entity.js.map