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
exports.RegionVitivinicolaEntity = void 0;
const typeorm_1 = require("typeorm");
const provincia_entity_1 = require("./provincia.entity");
const bodega_entity_1 = require("./bodega.entity");
let RegionVitivinicolaEntity = class RegionVitivinicolaEntity extends typeorm_1.BaseEntity {
};
exports.RegionVitivinicolaEntity = RegionVitivinicolaEntity;
__decorate([
    (0, typeorm_1.PrimaryGeneratedColumn)(),
    __metadata("design:type", Number)
], RegionVitivinicolaEntity.prototype, "id", void 0);
__decorate([
    (0, typeorm_1.Column)({ length: 100 }),
    __metadata("design:type", String)
], RegionVitivinicolaEntity.prototype, "nombre", void 0);
__decorate([
    (0, typeorm_1.Column)('text', { nullable: true }),
    __metadata("design:type", String)
], RegionVitivinicolaEntity.prototype, "descripcion", void 0);
__decorate([
    (0, typeorm_1.ManyToOne)(() => provincia_entity_1.ProvinciaEntity, provincia => provincia.regionesVitivinicolas),
    __metadata("design:type", provincia_entity_1.ProvinciaEntity)
], RegionVitivinicolaEntity.prototype, "provincia", void 0);
__decorate([
    (0, typeorm_1.OneToMany)(() => bodega_entity_1.BodegaEntity, bodega => bodega.regionVitivinicola),
    __metadata("design:type", Array)
], RegionVitivinicolaEntity.prototype, "bodegas", void 0);
exports.RegionVitivinicolaEntity = RegionVitivinicolaEntity = __decorate([
    (0, typeorm_1.Entity)()
], RegionVitivinicolaEntity);
//# sourceMappingURL=regionVitivinicola.entity.js.map