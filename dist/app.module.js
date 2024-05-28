"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.AppModule = void 0;
const common_1 = require("@nestjs/common");
const app_controller_1 = require("./app.controller");
const app_service_1 = require("./app.service");
const generar_reporte_ranking_vinos_module_1 = require("./Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.module");
const generar_reporte_ranking_vinos_controller_1 = require("./Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.controller");
const vino_module_1 = require("./Modules/vino/vino.module");
const provincia_module_1 = require("./Modules/provincia/provincia.module");
const pais_module_1 = require("./Modules/pais/pais.module");
const tipo_rese_a_module_1 = require("./Modules/tipo-rese\u00F1a/tipo-rese\u00F1a.module");
const rese_a_module_1 = require("./Modules/rese\u00F1a/rese\u00F1a.module");
const region_vitivinico_module_1 = require("./Modules/region-vitivinico/region-vitivinico.module");
let AppModule = class AppModule {
};
exports.AppModule = AppModule;
exports.AppModule = AppModule = __decorate([
    (0, common_1.Module)({
        imports: [generar_reporte_ranking_vinos_module_1.GenerarReporteRankingVinosModule, vino_module_1.VinoModule, provincia_module_1.ProvinciaModule, pais_module_1.PaisModule, tipo_rese_a_module_1.TipoReseñaModule, rese_a_module_1.ReseñaModule, region_vitivinico_module_1.RegionVitivinicoModule,],
        controllers: [app_controller_1.AppController, generar_reporte_ranking_vinos_controller_1.GenerarReporteRankingVinosController],
        providers: [app_service_1.AppService],
    })
], AppModule);
//# sourceMappingURL=app.module.js.map