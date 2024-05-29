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
exports.EnofiloEntity = void 0;
const typeorm_1 = require("typeorm");
const resena_entity_1 = require("./resena.entity");
let EnofiloEntity = class EnofiloEntity extends typeorm_1.BaseEntity {
};
exports.EnofiloEntity = EnofiloEntity;
__decorate([
    (0, typeorm_1.PrimaryGeneratedColumn)(),
    __metadata("design:type", Number)
], EnofiloEntity.prototype, "id", void 0);
__decorate([
    (0, typeorm_1.Column)('text', { nullable: true }),
    __metadata("design:type", String)
], EnofiloEntity.prototype, "comentario", void 0);
__decorate([
    (0, typeorm_1.Column)(),
    __metadata("design:type", Boolean)
], EnofiloEntity.prototype, "esPremium", void 0);
__decorate([
    (0, typeorm_1.Column)({ type: 'date', nullable: true }),
    __metadata("design:type", Date)
], EnofiloEntity.prototype, "fechaResena", void 0);
__decorate([
    (0, typeorm_1.Column)({ type: 'decimal', precision: 5, scale: 2, nullable: true }),
    __metadata("design:type", Number)
], EnofiloEntity.prototype, "puntaje", void 0);
__decorate([
    (0, typeorm_1.OneToMany)(() => resena_entity_1.ResenaEntity, resena => resena.enofilo),
    __metadata("design:type", Array)
], EnofiloEntity.prototype, "resenas", void 0);
exports.EnofiloEntity = EnofiloEntity = __decorate([
    (0, typeorm_1.Entity)()
], EnofiloEntity);
//# sourceMappingURL=enofilo.entity.js.map