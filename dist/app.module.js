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
const typeorm_1 = require("@nestjs/typeorm");
const entities_1 = require("./entities");
const app_controller_1 = require("./app.controller");
const app_service_1 = require("./app.service");
const generar_reporte_ranking_vinos_module_1 = require("./Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.module");
const generar_reporte_ranking_vinos_controller_1 = require("./Modules/generar-reporte-ranking-vinos/generar-reporte-ranking-vinos.controller");
const vino_module_1 = require("./Modules/vino/vino.module");
const provincia_module_1 = require("./Modules/provincia/provincia.module");
const pais_module_1 = require("./Modules/pais/pais.module");
const resena_module_1 = require("./Modules/resena/resena.module");
const region_vitivinicola_module_1 = require("./Modules/region-vitivinicola/region-vitivinicola.module");
const varietal_module_1 = require("./Modules/varietal/varietal.module");
const bodega_module_1 = require("./Modules/bodega/bodega.module");
const enofilo_module_1 = require("./Modules/enofilo/enofilo.module");
let AppModule = class AppModule {
};
exports.AppModule = AppModule;
exports.AppModule = AppModule = __decorate([
    (0, common_1.Module)({
        imports: [generar_reporte_ranking_vinos_module_1.GenerarReporteRankingVinosModule, typeorm_1.TypeOrmModule.forRoot({
                type: 'sqlite',
                database: 'bonvino.db',
                entities: entities_1.entities,
                synchronize: true,
            }), vino_module_1.VinoModule, provincia_module_1.ProvinciaModule, pais_module_1.PaisModule, resena_module_1.ResenaModule, region_vitivinicola_module_1.RegionVitivinicolaModule, varietal_module_1.VarietalModule, bodega_module_1.BodegaModule, enofilo_module_1.EnofiloModule],
        controllers: [app_controller_1.AppController, generar_reporte_ranking_vinos_controller_1.GenerarReporteRankingVinosController],
        providers: [app_service_1.AppService],
    })
], AppModule);
//# sourceMappingURL=app.module.js.map