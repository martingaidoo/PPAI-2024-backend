"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.GenerarReporteRankingVinosModule = void 0;
const common_1 = require("@nestjs/common");
const generar_reporte_ranking_vinos_controller_1 = require("./generar-reporte-ranking-vinos.controller");
const generar_reporte_ranking_vinos_service_1 = require("./generar-reporte-ranking-vinos.service");
let GenerarReporteRankingVinosModule = class GenerarReporteRankingVinosModule {
};
exports.GenerarReporteRankingVinosModule = GenerarReporteRankingVinosModule;
exports.GenerarReporteRankingVinosModule = GenerarReporteRankingVinosModule = __decorate([
    (0, common_1.Module)({
        controllers: [generar_reporte_ranking_vinos_controller_1.GenerarReporteRankingVinosController],
        providers: [generar_reporte_ranking_vinos_service_1.GenerarReporteRankingVinosService]
    })
], GenerarReporteRankingVinosModule);
//# sourceMappingURL=generar-reporte-ranking-vinos.module.js.map