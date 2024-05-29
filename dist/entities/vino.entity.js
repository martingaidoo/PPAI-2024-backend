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
exports.VinoEntity = void 0;
const typeorm_1 = require("typeorm");
const bodega_entity_1 = require("./bodega.entity");
const varietal_entity_1 = require("./varietal.entity");
const resena_entity_1 = require("./resena.entity");
let VinoEntity = class VinoEntity extends typeorm_1.BaseEntity {
};
exports.VinoEntity = VinoEntity;
__decorate([
    (0, typeorm_1.PrimaryGeneratedColumn)(),
    __metadata("design:type", Number)
], VinoEntity.prototype, "id", void 0);
__decorate([
    (0, typeorm_1.Column)({ length: 100 }),
    __metadata("design:type", String)
], VinoEntity.prototype, "nombre", void 0);
__decorate([
    (0, typeorm_1.Column)({ length: 100, nullable: true }),
    __metadata("design:type", String)
], VinoEntity.prototype, "anada", void 0);
__decorate([
    (0, typeorm_1.Column)({ type: 'date', nullable: true }),
    __metadata("design:type", Date)
], VinoEntity.prototype, "fechaActualizacion", void 0);
__decorate([
    (0, typeorm_1.Column)('text', { nullable: true }),
    __metadata("design:type", String)
], VinoEntity.prototype, "imagenEtiqueta", void 0);
__decorate([
    (0, typeorm_1.Column)('text', { nullable: true }),
    __metadata("design:type", String)
], VinoEntity.prototype, "notaDeCataBodega", void 0);
__decorate([
    (0, typeorm_1.Column)({ type: 'decimal', precision: 10, scale: 2 }),
    __metadata("design:type", Number)
], VinoEntity.prototype, "precioARS", void 0);
__decorate([
    (0, typeorm_1.ManyToOne)(() => bodega_entity_1.BodegaEntity, bodega => bodega.vinos),
    __metadata("design:type", bodega_entity_1.BodegaEntity)
], VinoEntity.prototype, "bodega", void 0);
__decorate([
    (0, typeorm_1.OneToMany)(() => varietal_entity_1.VarietalEntity, varietal => varietal.vino),
    __metadata("design:type", Array)
], VinoEntity.prototype, "varietals", void 0);
__decorate([
    (0, typeorm_1.OneToMany)(() => resena_entity_1.ResenaEntity, resena => resena.vino),
    __metadata("design:type", Array)
], VinoEntity.prototype, "resenas", void 0);
exports.VinoEntity = VinoEntity = __decorate([
    (0, typeorm_1.Entity)()
], VinoEntity);
//# sourceMappingURL=vino.entity.js.map