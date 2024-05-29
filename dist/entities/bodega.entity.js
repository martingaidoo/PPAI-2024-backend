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
exports.BodegaEntity = void 0;
const typeorm_1 = require("typeorm");
const regionVitivinicola_entity_1 = require("./regionVitivinicola.entity");
const vino_entity_1 = require("./vino.entity");
let BodegaEntity = class BodegaEntity extends typeorm_1.BaseEntity {
};
exports.BodegaEntity = BodegaEntity;
__decorate([
    (0, typeorm_1.PrimaryGeneratedColumn)(),
    __metadata("design:type", Number)
], BodegaEntity.prototype, "id", void 0);
__decorate([
    (0, typeorm_1.Column)('text', { nullable: true }),
    __metadata("design:type", String)
], BodegaEntity.prototype, "coordenadasUbicacion", void 0);
__decorate([
    (0, typeorm_1.Column)('text', { nullable: true }),
    __metadata("design:type", String)
], BodegaEntity.prototype, "descripcion", void 0);
__decorate([
    (0, typeorm_1.Column)('text', { nullable: true }),
    __metadata("design:type", String)
], BodegaEntity.prototype, "historia", void 0);
__decorate([
    (0, typeorm_1.Column)({ length: 100 }),
    __metadata("design:type", String)
], BodegaEntity.prototype, "nombre", void 0);
__decorate([
    (0, typeorm_1.Column)({ length: 100, nullable: true }),
    __metadata("design:type", String)
], BodegaEntity.prototype, "periodoActualizacion", void 0);
__decorate([
    (0, typeorm_1.ManyToOne)(() => regionVitivinicola_entity_1.RegionVitivinicolaEntity, region => region.bodegas),
    __metadata("design:type", regionVitivinicola_entity_1.RegionVitivinicolaEntity)
], BodegaEntity.prototype, "regionVitivinicola", void 0);
__decorate([
    (0, typeorm_1.OneToMany)(() => vino_entity_1.VinoEntity, vino => vino.bodega),
    __metadata("design:type", Array)
], BodegaEntity.prototype, "vinos", void 0);
exports.BodegaEntity = BodegaEntity = __decorate([
    (0, typeorm_1.Entity)()
], BodegaEntity);
//# sourceMappingURL=bodega.entity.js.map