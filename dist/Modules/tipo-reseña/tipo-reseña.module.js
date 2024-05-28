"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.TipoReseñaModule = void 0;
const common_1 = require("@nestjs/common");
const tipo_rese_a_controller_1 = require("./tipo-rese\u00F1a.controller");
const tipo_rese_a_service_1 = require("./tipo-rese\u00F1a.service");
let TipoReseñaModule = class TipoReseñaModule {
};
exports.TipoReseñaModule = TipoReseñaModule;
exports.TipoReseñaModule = TipoReseñaModule = __decorate([
    (0, common_1.Module)({
        controllers: [tipo_rese_a_controller_1.TipoReseñaController],
        providers: [tipo_rese_a_service_1.TipoReseñaService]
    })
], TipoReseñaModule);
//# sourceMappingURL=tipo-rese%C3%B1a.module.js.map