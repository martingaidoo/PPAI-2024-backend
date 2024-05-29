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
exports.GenerarReporteRankingVinosController = void 0;
const common_1 = require("@nestjs/common");
const common_2 = require("@nestjs/common");
const generar_reporte_ranking_vinos_service_1 = require("./generar-reporte-ranking-vinos.service");
let GenerarReporteRankingVinosController = class GenerarReporteRankingVinosController {
    constructor(generarReporteRankingVinosService) {
        this.generarReporteRankingVinosService = generarReporteRankingVinosService;
    }
    opcionGenerarReporteRankingDeVinos() {
        return this.generarReporteRankingVinosService.opcionGenerarReporteRankingDeVinos();
    }
};
exports.GenerarReporteRankingVinosController = GenerarReporteRankingVinosController;
__decorate([
    (0, common_2.Get)("opcion-generar-ranking-de-vinos"),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", void 0)
], GenerarReporteRankingVinosController.prototype, "opcionGenerarReporteRankingDeVinos", null);
exports.GenerarReporteRankingVinosController = GenerarReporteRankingVinosController = __decorate([
    (0, common_1.Controller)('gestor-generar-reporte-ranking-vinos'),
    __metadata("design:paramtypes", [generar_reporte_ranking_vinos_service_1.GenerarReporteRankingVinosService])
], GenerarReporteRankingVinosController);
//# sourceMappingURL=generar-reporte-ranking-vinos.controller.js.map