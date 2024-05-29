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
exports.ResenaEntity = void 0;
const typeorm_1 = require("typeorm");
const vino_entity_1 = require("./vino.entity");
let ResenaEntity = class ResenaEntity extends typeorm_1.BaseEntity {
};
exports.ResenaEntity = ResenaEntity;
__decorate([
    (0, typeorm_1.PrimaryGeneratedColumn)(),
    __metadata("design:type", Number)
], ResenaEntity.prototype, "id", void 0);
__decorate([
    (0, typeorm_1.Column)('text', { nullable: true }),
    __metadata("design:type", String)
], ResenaEntity.prototype, "comentario", void 0);
__decorate([
    (0, typeorm_1.Column)(),
    __metadata("design:type", Boolean)
], ResenaEntity.prototype, "esPremium", void 0);
__decorate([
    (0, typeorm_1.Column)({ type: 'date', nullable: true }),
    __metadata("design:type", Date)
], ResenaEntity.prototype, "fechaResena", void 0);
__decorate([
    (0, typeorm_1.Column)({ type: 'decimal', precision: 5, scale: 2, nullable: true }),
    __metadata("design:type", Number)
], ResenaEntity.prototype, "puntaje", void 0);
__decorate([
    (0, typeorm_1.ManyToOne)(() => vino_entity_1.VinoEntity, vino => vino.resenas),
    __metadata("design:type", vino_entity_1.VinoEntity)
], ResenaEntity.prototype, "vino", void 0);
exports.ResenaEntity = ResenaEntity = __decorate([
    (0, typeorm_1.Entity)()
], ResenaEntity);
//# sourceMappingURL=resena.entity.js.map