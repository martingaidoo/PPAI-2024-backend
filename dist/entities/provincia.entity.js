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
exports.ProvinciaEntity = void 0;
const typeorm_1 = require("typeorm");
const pais_entity_1 = require("./pais.entity");
const regionVitivinicola_entity_1 = require("./regionVitivinicola.entity");
let ProvinciaEntity = class ProvinciaEntity extends typeorm_1.BaseEntity {
};
exports.ProvinciaEntity = ProvinciaEntity;
__decorate([
    (0, typeorm_1.PrimaryGeneratedColumn)(),
    __metadata("design:type", Number)
], ProvinciaEntity.prototype, "id", void 0);
__decorate([
    (0, typeorm_1.Column)({ length: 100 }),
    __metadata("design:type", String)
], ProvinciaEntity.prototype, "nombre", void 0);
__decorate([
    (0, typeorm_1.ManyToOne)(() => pais_entity_1.PaisEntity, pais => pais.provincias),
    __metadata("design:type", pais_entity_1.PaisEntity)
], ProvinciaEntity.prototype, "pais", void 0);
__decorate([
    (0, typeorm_1.OneToMany)(() => regionVitivinicola_entity_1.RegionVitivinicolaEntity, region => region.provincia),
    __metadata("design:type", Array)
], ProvinciaEntity.prototype, "regionesVitivinicolas", void 0);
exports.ProvinciaEntity = ProvinciaEntity = __decorate([
    (0, typeorm_1.Entity)()
], ProvinciaEntity);
//# sourceMappingURL=provincia.entity.js.map