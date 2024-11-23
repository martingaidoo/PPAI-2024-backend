package com.bonvino.components;

import com.bonvino.model.*;
import com.bonvino.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

        @Autowired
        private RepositoryPais paisRepository;

        @Autowired
        private RepositoryProvincia provinciaRepository;

        @Autowired
        private RepositoryRegionVitivinicola regionVitivinicolaRepository;

        @Autowired
        private RepositoryBodega bodegaRepository;

        @Autowired
        private RepositoryVino vinoRepository;

        @Autowired
        private RepositoryVarietal varietalRepository;

        @Autowired
        private RepositoryResena resenaRepository;

        @Override
        public void run(String... args) throws Exception {
                // Crear instancias de las entidades principales

                // Crear Paises y Provincias
                Pais argentina = new Pais(null, "Argentina", new ArrayList<>());
                Pais chile = new Pais(null, "Chile", new ArrayList<>());
                Pais brasil = new Pais(null, "Brasil", new ArrayList<>());
                Pais uruguay = new Pais(null, "Uruguay", new ArrayList<>());
                Pais peru = new Pais(null, "Perú", new ArrayList<>());

                // Provincias para Argentina
                Provincia mendoza = new Provincia(null, "Mendoza", argentina, new ArrayList<>());
                Provincia sanJuan = new Provincia(null, "San Juan", argentina, new ArrayList<>());
                Provincia salta = new Provincia(null, "Salta", argentina, new ArrayList<>());
                Provincia cordoba = new Provincia(null, "Córdoba", argentina, new ArrayList<>());
                Provincia buenosAires = new Provincia(null, "Buenos Aires", argentina, new ArrayList<>());

                // Provincias para Chile
                Provincia maipo = new Provincia(null, "Región del Maipo", chile, new ArrayList<>());
                Provincia atacama = new Provincia(null, "Región de Atacama", chile, new ArrayList<>());
                Provincia bioBio = new Provincia(null, "Región del Biobío", chile, new ArrayList<>());
                Provincia valparaiso = new Provincia(null, "Región de Valparaíso", chile, new ArrayList<>());
                Provincia araucania = new Provincia(null, "Región de La Araucanía", chile, new ArrayList<>());

                // Provincias para Brasil
                Provincia saoPaulo = new Provincia(null, "São Paulo", brasil, new ArrayList<>());
                Provincia rioDeJaneiro = new Provincia(null, "Río de Janeiro", brasil, new ArrayList<>());
                Provincia bahia = new Provincia(null, "Bahía", brasil, new ArrayList<>());
                Provincia minasGerais = new Provincia(null, "Minas Gerais", brasil, new ArrayList<>());
                Provincia rioGrandeDoSul = new Provincia(null, "Río Grande do Sul", brasil, new ArrayList<>());

                // Provincias para Uruguay
                Provincia canelones = new Provincia(null, "Canelones", uruguay, new ArrayList<>());
                Provincia montevideo = new Provincia(null, "Montevideo", uruguay, new ArrayList<>());
                Provincia maldonado = new Provincia(null, "Maldonado", uruguay, new ArrayList<>());
                Provincia colonia = new Provincia(null, "Colonia", uruguay, new ArrayList<>());
                Provincia rocha = new Provincia(null, "Rocha", uruguay, new ArrayList<>());

                // Provincias para Perú
                Provincia lima = new Provincia(null, "Lima", peru, new ArrayList<>());
                Provincia cusco = new Provincia(null, "Cusco", peru, new ArrayList<>());
                Provincia arequipa = new Provincia(null, "Arequipa", peru, new ArrayList<>());
                Provincia puno = new Provincia(null, "Puno", peru, new ArrayList<>());
                Provincia ica = new Provincia(null, "Ica", peru, new ArrayList<>());

                // Asignar provincias a países
                argentina.setProvincias(List.of(mendoza, sanJuan, salta, cordoba, buenosAires));
                chile.setProvincias(List.of(maipo, atacama, bioBio, valparaiso, araucania));
                brasil.setProvincias(List.of(saoPaulo, rioDeJaneiro, bahia, minasGerais, rioGrandeDoSul));
                uruguay.setProvincias(List.of(canelones, montevideo, maldonado, colonia, rocha));
                peru.setProvincias(List.of(lima, cusco, arequipa, puno, ica));

                // Persistir países y provincias
                paisRepository.save(argentina);
                paisRepository.save(chile);
                paisRepository.save(brasil);
                paisRepository.save(uruguay);
                paisRepository.save(peru);

                provinciaRepository.saveAll(argentina.getProvincias());
                provinciaRepository.saveAll(chile.getProvincias());
                provinciaRepository.saveAll(brasil.getProvincias());
                provinciaRepository.saveAll(uruguay.getProvincias());
                provinciaRepository.saveAll(peru.getProvincias());

                // Crear Regiones Vitivinícolas para Mendoza
                RegionVitivinicola lujanDeCuyo = new RegionVitivinicola(null, "Luján de Cuyo", "Famosa por sus Malbec",
                                mendoza);
                RegionVitivinicola ucoValley = new RegionVitivinicola(null, "Valle de Uco", "Excelentes Alturas",
                                mendoza);
                RegionVitivinicola maipu = new RegionVitivinicola(null, "Maipú", "Tradición vinícola de siglos",
                                mendoza);
                RegionVitivinicola tupungato = new RegionVitivinicola(null, "Tupungato", "Cuna de vinos frescos",
                                mendoza);
                RegionVitivinicola sanRafael = new RegionVitivinicola(null, "San Rafael",
                                "Malbec y Chardonnays exquisitos",
                                mendoza);
                RegionVitivinicola generalAlvear = new RegionVitivinicola(null, "General Alvear", "Región emergente",
                                mendoza);

                // Crear Regiones Vitivinícolas para San Juan
                RegionVitivinicola tulum = new RegionVitivinicola(null, "Valle de Tulum", "Excelentes Syrah", sanJuan);
                RegionVitivinicola zonda = new RegionVitivinicola(null, "Valle de Zonda", "Vinos elegantes", sanJuan);
                RegionVitivinicola pedernal = new RegionVitivinicola(null, "Valle del Pedernal",
                                "Alta calidad vinícola",
                                sanJuan);
                RegionVitivinicola calingasta = new RegionVitivinicola(null, "Calingasta", "Vinos de altura", sanJuan);
                RegionVitivinicola ullum = new RegionVitivinicola(null, "Ullum", "Pequeños productores de calidad",
                                sanJuan);

                // Crear Regiones Vitivinícolas para Maipo (Chile)
                RegionVitivinicola aconcagua = new RegionVitivinicola(null, "Aconcagua", "Excelentes Cabernets", maipo);
                RegionVitivinicola cachapoal = new RegionVitivinicola(null, "Cachapoal", "Cabernet Sauvignon destacado",
                                maipo);
                RegionVitivinicola colchagua = new RegionVitivinicola(null, "Colchagua",
                                "Vinos reconocidos a nivel mundial",
                                maipo);
                RegionVitivinicola curico = new RegionVitivinicola(null, "Curicó", "Diversidad vinícola", maipo);
                RegionVitivinicola leyda = new RegionVitivinicola(null, "Valle de Leyda",
                                "Sauvignon Blanc sobresaliente",
                                maipo);

                // Crear Regiones Vitivinícolas para Atacama
                RegionVitivinicola copiapo = new RegionVitivinicola(null, "Copiapó", "Nueva región emergente", atacama);
                RegionVitivinicola huasco = new RegionVitivinicola(null, "Huasco", "Viñedos desérticos", atacama);

                // Crear Regiones Vitivinícolas para Biobío
                RegionVitivinicola itata = new RegionVitivinicola(null, "Itata", "Vinos ancestrales", bioBio);
                RegionVitivinicola maule = new RegionVitivinicola(null, "Valle del Maule",
                                "Carignan y variedades tintas",
                                bioBio);

                // Crear Regiones Vitivinícolas para Valparaíso
                RegionVitivinicola casablanca = new RegionVitivinicola(null, "Casablanca",
                                "Chardonnay y Sauvignon Blanc",
                                valparaiso);
                RegionVitivinicola sanAntonio = new RegionVitivinicola(null, "San Antonio",
                                "Pequeñas bodegas innovadoras",
                                valparaiso);

                // Crear Regiones Vitivinícolas para Brasil
                RegionVitivinicola valeDosVinhedos = new RegionVitivinicola(null, "Vale dos Vinhedos",
                                "Vinos espumosos",
                                rioGrandeDoSul);
                RegionVitivinicola serraGaucha = new RegionVitivinicola(null, "Serra Gaúcha",
                                "Región clásica vinícola de Brasil", rioGrandeDoSul);
                RegionVitivinicola camposDeCima = new RegionVitivinicola(null, "Campos de Cima",
                                "Alta calidad emergente",
                                rioGrandeDoSul);

                // Crear Regiones Vitivinícolas para Uruguay
                RegionVitivinicola canelonesRegion = new RegionVitivinicola(null, "Canelones", "Excelentes Tannat",
                                canelones);
                RegionVitivinicola montevideoRegion = new RegionVitivinicola(null, "Montevideo", "Vinos boutique",
                                montevideo);

                // Crear Regiones Vitivinícolas para Perú
                RegionVitivinicola icaRegion = new RegionVitivinicola(null, "Ica", "Pisco y vinos dulces", ica);
                RegionVitivinicola cuscoRegion = new RegionVitivinicola(null, "Cusco", "Viñedos de altura", cusco);

                // Crear Regiones Vitivinícolas para otras provincias de Argentina
                RegionVitivinicola valleCalchaqui = new RegionVitivinicola(null, "Valle Calchaquí",
                                "Terruños extremos con gran altura", salta);
                RegionVitivinicola cafayate = new RegionVitivinicola(null, "Cafayate", "Famosa por su Torrontés único",
                                salta);
                RegionVitivinicola quebradaDeHumahuaca = new RegionVitivinicola(null, "Quebrada de Humahuaca",
                                "Viñedos en paisajes Patrimonio de la Humanidad", cordoba);
                RegionVitivinicola tucumanValles = new RegionVitivinicola(null, "Valles de Tucumán",
                                "Viñedos en los Valles Calchaquíes", salta);
                RegionVitivinicola rioColorado = new RegionVitivinicola(null, "Río Colorado",
                                "Pequeñas bodegas artesanales",
                                cordoba);

                // Crear Regiones Vitivinícolas para Brasil (otras provincias)
                RegionVitivinicola planaltoCatarinense = new RegionVitivinicola(null, "Planalto Catarinense",
                                "Viñedos de altura con gran acidez", minasGerais);

                // Crear Regiones Vitivinícolas para Chile (otras provincias)
                RegionVitivinicola bioBioRegion = new RegionVitivinicola(null, "Bío Bío",
                                "Viñedos al sur con gran frescura",
                                bioBio);
                RegionVitivinicola sanPedro = new RegionVitivinicola(null, "Araucanía",
                                "Nuevos viñedos en tierras mapuches",
                                bioBio);

                // Crear Regiones Vitivinícolas para Uruguay (otras provincias)
                RegionVitivinicola artigas = new RegionVitivinicola(null, "Canelones",
                                "Producción del 60% de los vinos uruguayos", canelones);
                RegionVitivinicola cerroLargo = new RegionVitivinicola(null, "Cerro Largo",
                                "Viñedos emergentes en la región este", colonia);
                RegionVitivinicola rivera = new RegionVitivinicola(null, "Rivera", "Viñedos en la frontera con Brasil",
                                colonia);

                // Crear Regiones Vitivinícolas para Perú (otras provincias)
                RegionVitivinicola chincha = new RegionVitivinicola(null, "Chincha",
                                "Viñedos con historia precolombina", ica);
                RegionVitivinicola nazca = new RegionVitivinicola(null, "Nazca", "Viñedos en terrenos desérticos", ica);
                RegionVitivinicola limaValley = new RegionVitivinicola(null, "Lima Valley", "Viñedos urbanos únicos",
                                lima);

                //// Asignar Regiones Vitivinícolas a sus respectivas provincias
                mendoza.getRegionesVitivinicolas()
                                .addAll(List.of(lujanDeCuyo, ucoValley, maipu, tupungato, sanRafael, generalAlvear));
                sanJuan.getRegionesVitivinicolas().addAll(List.of(tulum, zonda, pedernal, calingasta, ullum));
                maipo.getRegionesVitivinicolas().addAll(List.of(aconcagua, cachapoal, colchagua, curico, leyda));
                atacama.getRegionesVitivinicolas().addAll(List.of(copiapo, huasco));
                bioBio.getRegionesVitivinicolas().addAll(List.of(itata, maule, bioBioRegion, sanPedro));
                valparaiso.getRegionesVitivinicolas().addAll(List.of(casablanca, sanAntonio));
                rioGrandeDoSul.getRegionesVitivinicolas().addAll(List.of(valeDosVinhedos, serraGaucha, camposDeCima));
                canelones.getRegionesVitivinicolas().addAll(List.of(canelonesRegion, artigas));
                montevideo.getRegionesVitivinicolas().addAll(List.of(montevideoRegion));
                ica.getRegionesVitivinicolas().addAll(List.of(icaRegion, chincha, nazca));
                cusco.getRegionesVitivinicolas().addAll(List.of(cuscoRegion));
                salta.getRegionesVitivinicolas().addAll(List.of(valleCalchaqui, cafayate, tucumanValles));
                cordoba.getRegionesVitivinicolas().addAll(List.of(quebradaDeHumahuaca, rioColorado));
                minasGerais.getRegionesVitivinicolas().addAll(List.of(planaltoCatarinense));
                colonia.getRegionesVitivinicolas().addAll(List.of(cerroLargo, rivera));
                lima.getRegionesVitivinicolas().addAll(List.of(limaValley));

                // Persistir las regiones vitivinícolas
                regionVitivinicolaRepository.saveAll(mendoza.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(sanJuan.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(maipo.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(atacama.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(bioBio.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(valparaiso.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(rioGrandeDoSul.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(canelones.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(montevideo.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(ica.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(cusco.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(salta.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(cordoba.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(minasGerais.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(colonia.getRegionesVitivinicolas());
                regionVitivinicolaRepository.saveAll(lima.getRegionesVitivinicolas());

                Bodega tulumVineyards = new Bodega(null, "Tulum Vineyards",
                                "Famosa por su Syrah con cuerpo y estructura",
                                "Desde 2008", "Anual", "lat:-31.5000, lon:-68.6000", tulum);
                Bodega sanJuanVino = new Bodega(null, "Bodega San Juan Vino", "Productores artesanales de Syrah",
                                "Desde 2010",
                                "Anual", "lat:-31.5500, lon:-68.7000", tulum);
                Bodega zondaVineyards = new Bodega(null, "Zonda Vineyards",
                                "Vinos elegantes y finos, con un toque de historia",
                                "Desde 2005", "Anual", "lat:-31.3000, lon:-68.5000", zonda);
                Bodega vinoElegante = new Bodega(null, "Bodega Vino Elegante",
                                "Especialistas en la crianza de Cabernet Franc",
                                "Fundada en 2012", "Anual", "lat:-31.3500, lon:-68.4500", zonda);
                Bodega pedernalWines = new Bodega(null, "Bodega Pedernal Wines", "Vinos premiados de alta calidad",
                                "Desde 2009", "Anual", "lat:-31.4000, lon:-68.2500", pedernal);
                Bodega granPedernal = new Bodega(null, "Bodega Gran Pedernal",
                                "Enólogo especializado en vinos de alta gama",
                                "Fundada en 2006", "Anual", "lat:-31.3500, lon:-68.2000", pedernal);
                Bodega calingastaVineyards = new Bodega(null, "Bodega Calingasta",
                                "Viñedos de altura con producción limitada",
                                "Desde 2011", "Anual", "lat:-31.6000, lon:-68.4500", calingasta);
                Bodega vallesDeCalingasta = new Bodega(null, "Valles de Calingasta",
                                "Vinos frescos y elegantes, de zonas altas", "Fundada en 2014", "Anual",
                                "lat:-31.6500, lon:-68.4000",
                                calingasta);
                Bodega ullumVineyards = new Bodega(null, "Bodega Ullum Vineyards",
                                "Pequeña bodega artesanal con excelentes tintos", "Desde 2013", "Anual",
                                "lat:-31.1000, lon:-68.3000",
                                ullum);
                Bodega lasPiedras = new Bodega(null, "Bodega Las Piedras", "Vinos de alta calidad de pequeños viñedos",
                                "Fundada en 2008", "Anual", "lat:-31.0500, lon:-68.2500", ullum);
                Bodega aconcaguaWines = new Bodega(null, "Aconcagua Wines", "Famosa por sus Cabernets y Syrah",
                                "Desde 1990",
                                "Anual", "lat:-32.8000, lon:-70.7500", aconcagua);
                Bodega aconcaguaValley = new Bodega(null, "Bodega Aconcagua Valley",
                                "Viñedos de altura en el corazón del Valle Aconcagua", "Fundada en 1995", "Anual",
                                "lat:-32.8500, lon:-70.7000", aconcagua);
                Bodega cachapoalValley = new Bodega(null, "Bodega Cachapoal Valley",
                                "Vinos Premium con un gran terroir",
                                "Desde 1997", "Anual", "lat:-34.3000, lon:-70.8000", cachapoal);
                Bodega granCachapoal = new Bodega(null, "Gran Cachapoal", "Especializados en Cabernet Sauvignon",
                                "Desde 2003",
                                "Anual", "lat:-34.2500, lon:-70.7500", cachapoal);
                Bodega montGras = new Bodega(null, "Bodega MontGras", "Bodega innovadora, con vinos de alta gama",
                                "Fundada en 1993", "Anual", "lat:-34.6000, lon:-71.3000", colchagua);
                Bodega losHermanos = new Bodega(null, "Bodega Los Hermanos",
                                "Bodega familiar que produce vinos excepcionales",
                                "Desde 2001", "Anual", "lat:-34.5500, lon:-71.2500", colchagua);
                Bodega curicoWines = new Bodega(null, "Bodega Curicó Wines",
                                "Diversidad vinícola en una región de viñedos tradicionales", "Desde 2000", "Anual",
                                "lat:-34.9000, lon:-71.2000", curico);
                Bodega vinoCurico = new Bodega(null, "Bodega Vino Curico",
                                "Vinos de terroir, con una fuerte presencia local",
                                "Fundada en 2005", "Anual", "lat:-34.8500, lon:-71.1500", curico);
                Bodega bodegaTulumVineyards = new Bodega(null, "Tulum Vineyards",
                                "Famosa por su Syrah con cuerpo y estructura",
                                "Desde 2008", "Anual", "lat:31.5000, lon:-68.6000", tulum);
                Bodega bodegaSanJuanVino = new Bodega(null, "Bodega San Juan Vino", "Productores artesanales de Syrah",
                                "Desde 2010", "Anual", "lat:31.5500, lon:-68.7000", tulum);
                Bodega bodegaZondaVineyards = new Bodega(null, "Zonda Vineyards",
                                "Vinos elegantes y finos, con un toque de historia", "Desde 2005", "Anual",
                                "lat:31.3000, lon:-68.5000",
                                zonda);
                Bodega bodegaVinoElegante = new Bodega(null, "Bodega Vino Elegante",
                                "Especialistas en la crianza de Cabernet Franc", "Fundada en 2012", "Anual",
                                "lat:31.3500, lon:-68.4500", zonda);
                Bodega bodegaPedernalWines = new Bodega(null, "Bodega Pedernal Wines",
                                "Vinos premiados de alta calidad",
                                "Desde 2009", "Anual", "lat:31.4000, lon:-68.2500", pedernal);
                Bodega bodegaGranPedernal = new Bodega(null, "Bodega Gran Pedernal",
                                "Enólogo especializado en vinos de alta gama", "Fundada en 2006", "Anual",
                                "lat:31.3500, lon:-68.2000",
                                pedernal);
                Bodega bodegaCalingasta = new Bodega(null, "Bodega Calingasta",
                                "Viñedos de altura con producción limitada",
                                "Desde 2011", "Anual", "lat:31.6000, lon:-68.4500", calingasta);
                Bodega bodegaVallesDeCalingasta = new Bodega(null, "Valles de Calingasta",
                                "Vinos frescos y elegantes, de zonas altas", "Fundada en 2014", "Anual",
                                "lat:31.6500, lon:-68.4000",
                                calingasta);
                Bodega bodegaUllumVineyards = new Bodega(null, "Bodega Ullum Vineyards",
                                "Pequeña bodega artesanal con excelentes tintos", "Desde 2013", "Anual",
                                "lat:31.1000, lon:-68.3000",
                                ullum);
                Bodega bodegaLasPiedras = new Bodega(null, "Bodega Las Piedras",
                                "Vinos de alta calidad de pequeños viñedos",
                                "Fundada en 2008", "Anual", "lat:31.0500, lon:-68.2500", ullum);
                Bodega bodegaAconcaguaWines = new Bodega(null, "Aconcagua Wines", "Famosa por sus Cabernets y Syrah",
                                "Desde 1990", "Anual", "lat:-32.8000, lon:-70.7500", aconcagua);
                Bodega bodegaAconcaguaValley = new Bodega(null, "Bodega Aconcagua Valley",
                                "Viñedos de altura en el corazón del Valle Aconcagua", "Fundada en 1995", "Anual",
                                "lat:-32.8500, lon:-70.7000", aconcagua);
                Bodega bodegaCachapoalValley = new Bodega(null, "Bodega Cachapoal Valley",
                                "Vinos Premium con un gran terroir",
                                "Desde 1997", "Anual", "lat:-34.3000, lon:-70.8000", cachapoal);
                Bodega bodegaGranCachapoal = new Bodega(null, "Gran Cachapoal", "Especializados en Cabernet Sauvignon",
                                "Desde 2003", "Anual", "lat:-34.2500, lon:-70.7500", cachapoal);
                Bodega bodegaMontGras = new Bodega(null, "Bodega MontGras", "Bodega innovadora, con vinos de alta gama",
                                "Fundada en 1993", "Anual", "lat:-34.6000, lon:-71.3000", colchagua);
                Bodega bodegaLosHermanos = new Bodega(null, "Bodega Los Hermanos",
                                "Bodega familiar que produce vinos excepcionales", "Desde 2001", "Anual",
                                "lat:-34.5500, lon:-71.2500",
                                colchagua);
                Bodega bodegaCuricoWines = new Bodega(null, "Bodega Curicó Wines",
                                "Diversidad vinícola en una región de viñedos tradicionales", "Desde 2000", "Anual",
                                "lat:-34.9000, lon:-71.2000", curico);
                Bodega bodegaVinoCurico = new Bodega(null, "Bodega Vino Curico",
                                "Vinos de terroir, con una fuerte presencia local", "Fundada en 2005", "Anual",
                                "lat:-34.8500, lon:-71.1500", curico);
                Bodega bodegaLeydaValley = new Bodega(null, "Bodega Leyda Valley", "Sauvignon Blanc sobresaliente",
                                "Desde 2002", "Anual", "lat:-33.7500, lon:-71.5000", leyda);
                Bodega bodegaLeydaVineyard = new Bodega(null, "Bodega Leyda Vineyard",
                                "Pequeña bodega con gran calidad de vinos frescos", "Desde 2007", "Anual",
                                "lat:-33.7700, lon:-71.5500",
                                leyda);
                Bodega bodegaCopiapo = new Bodega(null, "Bodega Copiapó", "Nueva región emergente", "Desde 2015",
                                "Anual",
                                "lat:-27.4000, lon:-70.3000", copiapo);
                Bodega bodegaHuasco = new Bodega(null, "Bodega Huasco", "Viñedos desérticos", "Desde 2018", "Anual",
                                "lat:-28.0000, lon:-70.5000", huasco);
                Bodega bodegaItata = new Bodega(null, "Bodega Itata", "Vinos ancestrales", "Desde 2000", "Anual",
                                "lat:-36.3000, lon:-72.0000", itata);
                Bodega bodegaMaule = new Bodega(null, "Bodega Valle del Maule", "Carignan y variedades tintas",
                                "Desde 1995",
                                "Anual", "lat:-35.0000, lon:-71.5000", maule);
                Bodega bodegaCasablanca = new Bodega(null, "Bodega Casablanca", "Chardonnay y Sauvignon Blanc",
                                "Desde 2000",
                                "Anual", "lat:-33.4000, lon:-71.5000", casablanca);
                Bodega bodegaSanAntonio = new Bodega(null, "Bodega San Antonio", "Pequeñas bodegas innovadoras",
                                "Desde 2005",
                                "Anual", "lat:-33.5000, lon:-71.3000", sanAntonio);
                Bodega bodegaValeDosVinhedos = new Bodega(null, "Bodega Vale dos Vinhedos", "Vinos espumosos",
                                "Desde 1998",
                                "Anual", "lat:-29.2000, lon:-51.2000", valeDosVinhedos);
                Bodega bodegaSerraGaucha = new Bodega(null, "Bodega Serra Gaúcha", "Región clásica vinícola de Brasil",
                                "Desde 1990", "Anual", "lat:-29.3000, lon:-51.3000", serraGaucha);
                Bodega bodegaCamposDeCima = new Bodega(null, "Bodega Campos de Cima", "Alta calidad emergente",
                                "Desde 2010",
                                "Anual", "lat:-28.5000, lon:-51.5000", camposDeCima);
                Bodega bodegaCanelonesRegion = new Bodega(null, "Bodega Canelones", "Excelentes Tannat", "Desde 2000",
                                "Anual",
                                "lat:-34.7000, lon:-56.2000", canelonesRegion);
                Bodega bodegaMontevideoRegion = new Bodega(null, "Bodega Montevideo", "Vinos boutique", "Desde 2007",
                                "Anual",
                                "lat:-34.9000, lon:-56.2000", montevideoRegion);
                Bodega bodegaIcaRegion = new Bodega(null, "Bodega Ica", "Pisco y vinos dulces", "Desde 2010", "Anual",
                                "lat:-13.7000, lon:-75.2000", icaRegion);
                Bodega bodegaCuscoRegion = new Bodega(null, "Bodega Cusco", "Viñedos de altura", "Desde 2015", "Anual",
                                "lat:-13.2000, lon:-72.1000", cuscoRegion);
                Bodega bodegaValleCalchaqui = new Bodega(null, "Bodega Valle Calchaquí",
                                "Terruños extremos con gran altura",
                                "Desde 2008", "Anual", "lat:-25.5000, lon:-65.5000", valleCalchaqui);
                Bodega bodegaCafayate = new Bodega(null, "Bodega Cafayate", "Famosa por su Torrontés único",
                                "Desde 2005",
                                "Anual", "lat:-25.0000, lon:-65.5000", cafayate);
                Bodega bodegaQuebradaDeHumahuaca = new Bodega(null, "Bodega Quebrada de Humahuaca",
                                "Viñedos en paisajes Patrimonio de la Humanidad", "Desde 2010", "Anual",
                                "lat:-24.5000, lon:-65.2000",
                                quebradaDeHumahuaca);
                Bodega bodegaTucumanValles = new Bodega(null, "Bodega Valles de Tucumán",
                                "Viñedos en los Valles Calchaquíes",
                                "Desde 2015", "Anual", "lat:-26.0000, lon:-65.5000", tucumanValles);
                Bodega bodegaRioColorado = new Bodega(null, "Bodega Río Colorado", "Pequeñas bodegas artesanales",
                                "Desde 2012",
                                "Anual", "lat:-31.0000, lon:-64.3000", rioColorado);
                Bodega bodegaPlanaltoCatarinense = new Bodega(null, "Bodega Planalto Catarinense",
                                "Viñedos de altura con gran acidez", "Desde 2011", "Anual",
                                "lat:-27.0000, lon:-50.5000",
                                planaltoCatarinense);
                Bodega bodegaBioBioRegion = new Bodega(null, "Bodega Bío Bío", "Viñedos al sur con gran frescura",
                                "Desde 2005",
                                "Anual", "lat:-38.0000, lon:-72.5000", bioBioRegion);
                Bodega bodegaSanPedro = new Bodega(null, "Bodega Araucanía", "Nuevos viñedos en tierras mapuches",
                                "Desde 2014",
                                "Anual", "lat:-38.5000, lon:-73.0000", sanPedro);
                Bodega bodegaArtigas = new Bodega(null, "Bodega Artigas", "Producción del 60% de los vinos uruguayos",
                                "Desde 2000", "Anual", "lat:-30.5000, lon:-56.5000", artigas);
                Bodega bodegaCerroLargo = new Bodega(null, "Bodega Cerro Largo", "Viñedos emergentes en la región este",
                                "Desde 2015", "Anual", "lat:-33.0000, lon:-54.5000", cerroLargo);
                Bodega bodegaRivera = new Bodega(null, "Bodega Rivera", "Viñedos en la frontera con Brasil",
                                "Desde 2012",
                                "Anual", "lat:-30.0000, lon:-55.0000", rivera);
                Bodega bodegaChincha = new Bodega(null, "Bodega Chincha", "Viñedos con historia precolombina",
                                "Desde 2008",
                                "Anual", "lat:-13.4000, lon:-75.7000", chincha);
                Bodega bodegaNazca = new Bodega(null, "Bodega Nazca", "Viñedos en terrenos desérticos", "Desde 2012",
                                "Anual",
                                "lat:-14.8000, lon:-74.9000", nazca);
                Bodega bodegaLimaValley = new Bodega(null, "Bodega Lima Valley", "Viñedos urbanos únicos", "Desde 2016",
                                "Anual", "lat:-12.0000, lon:-77.1000", limaValley);

                // Persistir todas las bodegas
                bodegaRepository.save(bodegaCopiapo);
                bodegaRepository.save(bodegaHuasco);
                bodegaRepository.save(bodegaItata);
                bodegaRepository.save(bodegaMaule);
                bodegaRepository.save(bodegaCasablanca);
                bodegaRepository.save(bodegaSanAntonio);
                bodegaRepository.save(bodegaValeDosVinhedos);
                bodegaRepository.save(bodegaSerraGaucha);
                bodegaRepository.save(bodegaCamposDeCima);
                bodegaRepository.save(bodegaCanelonesRegion);
                bodegaRepository.save(bodegaMontevideoRegion);
                bodegaRepository.save(bodegaIcaRegion);
                bodegaRepository.save(bodegaCuscoRegion);
                bodegaRepository.save(bodegaValleCalchaqui);
                bodegaRepository.save(bodegaCafayate);
                bodegaRepository.save(bodegaQuebradaDeHumahuaca);
                bodegaRepository.save(bodegaTucumanValles);
                bodegaRepository.save(bodegaRioColorado);
                bodegaRepository.save(bodegaPlanaltoCatarinense);
                bodegaRepository.save(bodegaBioBioRegion);
                bodegaRepository.save(bodegaSanPedro);
                bodegaRepository.save(bodegaArtigas);
                bodegaRepository.save(bodegaCerroLargo);
                bodegaRepository.save(bodegaRivera);
                bodegaRepository.save(bodegaChincha);
                bodegaRepository.save(bodegaNazca);
                bodegaRepository.save(bodegaLimaValley);
                bodegaRepository.save(bodegaTulumVineyards);
                bodegaRepository.save(bodegaSanJuanVino);
                bodegaRepository.save(bodegaZondaVineyards);
                bodegaRepository.save(bodegaVinoElegante);
                bodegaRepository.save(bodegaPedernalWines);
                bodegaRepository.save(bodegaGranPedernal);
                bodegaRepository.save(bodegaCalingasta);
                bodegaRepository.save(bodegaVallesDeCalingasta);
                bodegaRepository.save(bodegaUllumVineyards);
                bodegaRepository.save(bodegaLasPiedras);
                bodegaRepository.save(bodegaAconcaguaWines);
                bodegaRepository.save(bodegaAconcaguaValley);
                bodegaRepository.save(bodegaCachapoalValley);
                bodegaRepository.save(bodegaGranCachapoal);
                bodegaRepository.save(bodegaMontGras);
                bodegaRepository.save(bodegaLosHermanos);
                bodegaRepository.save(bodegaCuricoWines);
                bodegaRepository.save(bodegaVinoCurico);
                bodegaRepository.save(bodegaLeydaValley);
                bodegaRepository.save(bodegaLeydaVineyard);
                bodegaRepository.save(tulumVineyards);
                bodegaRepository.save(sanJuanVino);
                bodegaRepository.save(zondaVineyards);
                bodegaRepository.save(vinoElegante);
                bodegaRepository.save(pedernalWines);
                bodegaRepository.save(granPedernal);
                bodegaRepository.save(calingastaVineyards);
                bodegaRepository.save(vallesDeCalingasta);
                bodegaRepository.save(ullumVineyards);
                bodegaRepository.save(lasPiedras);
                bodegaRepository.save(aconcaguaWines);
                bodegaRepository.save(aconcaguaValley);
                bodegaRepository.save(cachapoalValley);
                bodegaRepository.save(granCachapoal);
                bodegaRepository.save(montGras);
                bodegaRepository.save(losHermanos);
                bodegaRepository.save(curicoWines);
                bodegaRepository.save(vinoCurico);

                // Crear Vinos y Varietales
                Vino vinoCopiapo1 = new Vino(null, new Date(), "Copiapó Reserva", "Vino de altura, excelente cuerpo",
                                1500.50f,
                                new ArrayList<>(), new ArrayList<>(), bodegaCopiapo);
                Vino vinoCopiapo2 = new Vino(null, new Date(), "Copiapó Gran Reserva", "Vino de viñedos desérticos",
                                2000.75f,
                                new ArrayList<>(), new ArrayList<>(), bodegaCopiapo);
                Vino vinoHuasco1 = new Vino(null, new Date(), "Huasco Especial", "Notas secas y especiadas", 1800.30f,
                                new ArrayList<>(), new ArrayList<>(), bodegaHuasco);
                Vino vinoHuasco2 = new Vino(null, new Date(), "Huasco Tinto", "Vino robusto con toques a frutos negros",
                                1600.20f, new ArrayList<>(), new ArrayList<>(), bodegaHuasco);
                Vino vinoItata1 = new Vino(null, new Date(), "Itata Gran Reserva", "Vino de cepas ancestrales",
                                2200.40f,
                                new ArrayList<>(), new ArrayList<>(), bodegaItata);
                Vino vinoItata2 = new Vino(null, new Date(), "Itata Especial", "Vino de clima frío con sabor único",
                                2100.10f,
                                new ArrayList<>(), new ArrayList<>(), bodegaItata);
                Vino vinoMaule1 = new Vino(null, new Date(), "Maule Reserva", "Carignan clásico, buena estructura",
                                1900.80f,
                                new ArrayList<>(), new ArrayList<>(), bodegaMaule);
                Vino vinoMaule2 = new Vino(null, new Date(), "Maule Gran Reserva",
                                "Vino potente con notas de frutos rojos",
                                2500.60f, new ArrayList<>(), new ArrayList<>(), bodegaMaule);
                Vino vinoCasablanca1 = new Vino(null, new Date(), "Casablanca Blanc", "Sauvignon Blanc fresco",
                                1400.70f,
                                new ArrayList<>(), new ArrayList<>(), bodegaCasablanca);
                Vino vinoCasablanca2 = new Vino(null, new Date(), "Casablanca Chardonnay", "Vino con buen balance",
                                1600.25f,
                                new ArrayList<>(), new ArrayList<>(), bodegaCasablanca);
                Vino vinoSanAntonio1 = new Vino(null, new Date(), "San Antonio Select",
                                "Vino innovador con notas herbáceas",
                                1800.50f, new ArrayList<>(), new ArrayList<>(), bodegaSanAntonio);
                Vino vinoSanAntonio2 = new Vino(null, new Date(), "San Antonio Tinto",
                                "Vino con sabor mineral y toques florales", 1700.40f, new ArrayList<>(),
                                new ArrayList<>(), bodegaSanAntonio);
                Vino vinoValeDosVinhedos1 = new Vino(null, new Date(), "Vale dos Vinhedos Espumoso",
                                "Vino espumoso fresco y burbujeante", 2500.90f, new ArrayList<>(), new ArrayList<>(),
                                bodegaValeDosVinhedos);
                Vino vinoValeDosVinhedos2 = new Vino(null, new Date(), "Vale dos Vinhedos Brut",
                                "Espumoso seco con acidez equilibrada", 2300.60f, new ArrayList<>(), new ArrayList<>(),
                                bodegaValeDosVinhedos);
                Vino vinoSerraGaucha1 = new Vino(null, new Date(), "Serra Gaúcha Clásico",
                                "Vino tinto robusto, notas de madera", 2200.40f, new ArrayList<>(), new ArrayList<>(),
                                bodegaSerraGaucha);
                Vino vinoSerraGaucha2 = new Vino(null, new Date(), "Serra Gaúcha Reserva",
                                "Vino complejo con frutos rojos y especias", 2400.50f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaSerraGaucha);
                Vino vinoCamposDeCima1 = new Vino(null, new Date(), "Campos de Cima Premium",
                                "Vino tinto con taninos firmes",
                                2600.30f, new ArrayList<>(), new ArrayList<>(), bodegaCamposDeCima);
                Vino vinoCamposDeCima2 = new Vino(null, new Date(), "Campos de Cima Elegance",
                                "Vino elegante con sabores frutales", 2700.20f, new ArrayList<>(), new ArrayList<>(),
                                bodegaCamposDeCima);
                Vino vinoCanelonesRegion1 = new Vino(null, new Date(), "Canelones Tannat",
                                "Vino robusto con frutos oscuros",
                                2100.80f, new ArrayList<>(), new ArrayList<>(), bodegaCanelonesRegion);
                Vino vinoCanelonesRegion2 = new Vino(null, new Date(), "Canelones Gran Reserva",
                                "Vino con gran concentración",
                                2400.50f, new ArrayList<>(), new ArrayList<>(), bodegaCanelonesRegion);
                Vino vinoMontevideoRegion1 = new Vino(null, new Date(), "Montevideo Boutique",
                                "Vino suave con notas de cereza",
                                1700.30f, new ArrayList<>(), new ArrayList<>(), bodegaMontevideoRegion);
                Vino vinoMontevideoRegion2 = new Vino(null, new Date(), "Montevideo Especial",
                                "Vino de pequeños lotes, excelente estructura", 1900.40f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaMontevideoRegion);
                Vino vinoIcaRegion1 = new Vino(null, new Date(), "Ica Pisco", "Vino dulce con toques cítricos",
                                1300.50f,
                                new ArrayList<>(), new ArrayList<>(), bodegaIcaRegion);
                Vino vinoIcaRegion2 = new Vino(null, new Date(), "Ica Reserva", "Vino dulce con aroma a durazno",
                                1600.75f,
                                new ArrayList<>(), new ArrayList<>(), bodegaIcaRegion);
                Vino vinoCuscoRegion1 = new Vino(null, new Date(), "Cusco Tinto", "Vino de altura con gran cuerpo",
                                2000.60f,
                                new ArrayList<>(), new ArrayList<>(), bodegaCuscoRegion);
                Vino vinoCuscoRegion2 = new Vino(null, new Date(), "Cusco Gran Reserva",
                                "Vino complejo con gran frescura",
                                2100.80f, new ArrayList<>(), new ArrayList<>(), bodegaCuscoRegion);
                Vino vinoValleCalchaqui1 = new Vino(null, new Date(), "Valle Calchaquí Alto",
                                "Vino potente con notas de especias", 2700.40f, new ArrayList<>(), new ArrayList<>(),
                                bodegaValleCalchaqui);
                Vino vinoValleCalchaqui2 = new Vino(null, new Date(), "Valle Calchaquí Reserva",
                                "Vino con excelente concentración", 2800.30f, new ArrayList<>(), new ArrayList<>(),
                                bodegaValleCalchaqui);
                Vino vinoCafayate1 = new Vino(null, new Date(), "Cafayate Torrontés", "Aromático y floral", 1500.20f,
                                new ArrayList<>(), new ArrayList<>(), bodegaCafayate);
                Vino vinoCafayate2 = new Vino(null, new Date(), "Cafayate Gran Reserva",
                                "Vino elegante, con taninos suaves",
                                2000.90f, new ArrayList<>(), new ArrayList<>(), bodegaCafayate);
                Vino vinoQuebradaDeHumahuaca1 = new Vino(null, new Date(), "Quebrada de Humahuaca Tinto",
                                "Vino con toque mineral", 2200.40f, new ArrayList<>(), new ArrayList<>(),
                                bodegaQuebradaDeHumahuaca);
                Vino vinoQuebradaDeHumahuaca2 = new Vino(null, new Date(), "Quebrada de Humahuaca Reserva",
                                "Vino en su máxima expresión", 2500.60f, new ArrayList<>(), new ArrayList<>(),
                                bodegaQuebradaDeHumahuaca);
                Vino vinoPlanaltoCatarinense1 = new Vino(null, new Date(), "Planalto Catarinense Tinto",
                                "Vino suave con notas de frutos rojos", 2100.75f, new ArrayList<>(), new ArrayList<>(),
                                bodegaPlanaltoCatarinense);
                Vino vinoPlanaltoCatarinense2 = new Vino(null, new Date(), "Planalto Catarinense Reserva",
                                "Vino con cuerpo, fresco y afrutado", 2300.80f, new ArrayList<>(), new ArrayList<>(),
                                bodegaPlanaltoCatarinense);
                Vino vinoBioBioRegion1 = new Vino(null, new Date(), "Bío Bío Fresco",
                                "Vino fresco con notas de frutos rojos",
                                1500.90f, new ArrayList<>(), new ArrayList<>(), bodegaBioBioRegion);
                Vino vinoBioBioRegion2 = new Vino(null, new Date(), "Bío Bío Gran Reserva",
                                "Vino robusto con notas de especias", 1800.75f, new ArrayList<>(), new ArrayList<>(),
                                bodegaBioBioRegion);
                Vino vinoSanPedro1 = new Vino(null, new Date(), "San Pedro Tinto",
                                "Vino de cuerpo medio con notas herbáceas",
                                1700.80f, new ArrayList<>(), new ArrayList<>(), bodegaSanPedro);
                Vino vinoSanPedro2 = new Vino(null, new Date(), "San Pedro Reserva", "Vino profundo con taninos suaves",
                                2000.50f, new ArrayList<>(), new ArrayList<>(), bodegaSanPedro);
                Vino vinoArtigas1 = new Vino(null, new Date(), "Artigas Tannat", "Vino robusto y complejo", 1900.20f,
                                new ArrayList<>(), new ArrayList<>(), bodegaArtigas);
                Vino vinoArtigas2 = new Vino(null, new Date(), "Artigas Gran Reserva",
                                "Vino con buen cuerpo y estructura",
                                2300.40f, new ArrayList<>(), new ArrayList<>(), bodegaArtigas);
                Vino vinoCerroLargo1 = new Vino(null, new Date(), "Cerro Largo Especial",
                                "Vino de tierras emergentes, suave y afrutado", 1800.50f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaCerroLargo);
                Vino vinoCerroLargo2 = new Vino(null, new Date(), "Cerro Largo Tinto",
                                "Vino ligero con notas de ciruela",
                                1700.70f, new ArrayList<>(), new ArrayList<>(), bodegaCerroLargo);
                Vino vinoRivera1 = new Vino(null, new Date(), "Rivera Reserva",
                                "Vino tinto profundo con taninos firmes",
                                2000.90f, new ArrayList<>(), new ArrayList<>(), bodegaRivera);
                Vino vinoRivera2 = new Vino(null, new Date(), "Rivera Gran Reserva",
                                "Vino con notas a madera y especias",
                                2200.80f, new ArrayList<>(), new ArrayList<>(), bodegaRivera);
                Vino vinoChincha1 = new Vino(null, new Date(), "Chincha Tannat", "Vino con cuerpo y taninos marcados",
                                1800.50f,
                                new ArrayList<>(), new ArrayList<>(), bodegaChincha);
                Vino vinoChincha2 = new Vino(null, new Date(), "Chincha Reserva", "Vino suave y especiado", 2000.60f,
                                new ArrayList<>(), new ArrayList<>(), bodegaChincha);
                Vino vinoNazca1 = new Vino(null, new Date(), "Nazca Malbec", "Vino tinto con notas de frutos negros",
                                1900.40f,
                                new ArrayList<>(), new ArrayList<>(), bodegaNazca);
                Vino vinoNazca2 = new Vino(null, new Date(), "Nazca Gran Reserva",
                                "Vino con excelente concentración y taninos",
                                2100.80f, new ArrayList<>(), new ArrayList<>(), bodegaNazca);
                Vino vinoLimaValley1 = new Vino(null, new Date(), "Lima Valley Chardonnay",
                                "Vino fresco y afrutado, ideal para el calor", 1600.50f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaLimaValley);
                Vino vinoLimaValley2 = new Vino(null, new Date(), "Lima Valley Especial",
                                "Vino complejo con notas minerales",
                                1700.75f, new ArrayList<>(), new ArrayList<>(), bodegaLimaValley);
                Vino vinoTulumVineyards1 = new Vino(null, new Date(), "Tulum Vineyard Malbec",
                                "Vino tinto de gran cuerpo y complejidad", 2200.80f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaTulumVineyards);
                Vino vinoTulumVineyards2 = new Vino(null, new Date(), "Tulum Vineyard Reserva",
                                "Vino de alto nivel, con taninos suaves", 2500.90f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaTulumVineyards);
                Vino vinoSanJuanVino1 = new Vino(null, new Date(), "San Juan Vino Tinto", "Vino suave y afrutado",
                                1600.40f,
                                new ArrayList<>(), new ArrayList<>(), bodegaSanJuanVino);
                Vino vinoSanJuanVino2 = new Vino(null, new Date(), "San Juan Vino Reserva",
                                "Vino con mayor complejidad y cuerpo", 1800.75f, new ArrayList<>(), new ArrayList<>(),
                                bodegaSanJuanVino);
                Vino vinoZondaVineyards1 = new Vino(null, new Date(), "Zonda Malbec",
                                "Vino joven, afrutado, de buen cuerpo",
                                1700.20f, new ArrayList<>(), new ArrayList<>(), bodegaZondaVineyards);
                Vino vinoZondaVineyards2 = new Vino(null, new Date(), "Zonda Reserva",
                                "Vino intenso con notas de roble",
                                2000.60f, new ArrayList<>(), new ArrayList<>(), bodegaZondaVineyards);
                Vino vinoVinoElegante1 = new Vino(null, new Date(), "Vino Elegante Malbec",
                                "Vino con gran concentración y aroma floral", 1800.30f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaVinoElegante);
                Vino vinoVinoElegante2 = new Vino(null, new Date(), "Vino Elegante Reserva",
                                "Vino madurado con taninos finos",
                                2100.40f, new ArrayList<>(), new ArrayList<>(), bodegaVinoElegante);
                Vino vinoPedernalWines1 = new Vino(null, new Date(), "Pedernal Wines Tinto",
                                "Vino con aromas de frutos rojos",
                                2000.90f, new ArrayList<>(), new ArrayList<>(), bodegaPedernalWines);
                Vino vinoPedernalWines2 = new Vino(null, new Date(), "Pedernal Wines Reserva",
                                "Vino robusto con buen equilibrio", 2200.70f, new ArrayList<>(), new ArrayList<>(),
                                bodegaPedernalWines);
                Vino vinoGranPedernal1 = new Vino(null, new Date(), "Gran Pedernal Tinto",
                                "Vino de estructura fuerte y cuerpo intenso", 2500.80f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaGranPedernal);
                Vino vinoGranPedernal2 = new Vino(null, new Date(), "Gran Pedernal Reserva",
                                "Vino complejo con gran potencial de guarda", 2800.90f, new ArrayList<>(),
                                new ArrayList<>(),
                                bodegaGranPedernal);
                Vino vinoCalingasta1 = new Vino(null, new Date(), "Calingasta Malbec",
                                "Vino joven con toques a ciruela",
                                1600.20f, new ArrayList<>(), new ArrayList<>(), bodegaCalingasta);
                Vino vinoCalingasta2 = new Vino(null, new Date(), "Calingasta Reserva",
                                "Vino madurado con buen equilibrio",
                                1900.60f, new ArrayList<>(), new ArrayList<>(), bodegaCalingasta);
                Vino vinoVallesDeCalingasta1 = new Vino(null, new Date(), "Valles de Calingasta Tinto",
                                "Vino con buen cuerpo y acidez", 1700.40f, new ArrayList<>(), new ArrayList<>(),
                                bodegaVallesDeCalingasta);
                Vino vinoVallesDeCalingasta2 = new Vino(null, new Date(), "Valles de Calingasta Gran Reserva",
                                "Vino elegante con notas especiadas", 2200.80f, new ArrayList<>(), new ArrayList<>(),
                                bodegaVallesDeCalingasta);

                vinoRepository.save(vinoBioBioRegion1);
                vinoRepository.save(vinoBioBioRegion2);
                vinoRepository.save(vinoSanPedro1);
                vinoRepository.save(vinoSanPedro2);
                vinoRepository.save(vinoArtigas2);
                vinoRepository.save(vinoCerroLargo1);
                vinoRepository.save(vinoCerroLargo2);
                vinoRepository.save(vinoRivera1);
                vinoRepository.save(vinoChincha1);
                vinoRepository.save(vinoChincha2);
                vinoRepository.save(vinoNazca1);
                vinoRepository.save(vinoNazca2);
                vinoRepository.save(vinoLimaValley1);
                vinoRepository.save(vinoLimaValley2);
                vinoRepository.save(vinoTulumVineyards1);
                vinoRepository.save(vinoTulumVineyards2);
                vinoRepository.save(vinoSanJuanVino1);
                vinoRepository.save(vinoSanJuanVino2);
                vinoRepository.save(vinoZondaVineyards1);
                vinoRepository.save(vinoZondaVineyards2);
                vinoRepository.save(vinoVinoElegante1);
                vinoRepository.save(vinoVinoElegante2);
                vinoRepository.save(vinoPedernalWines1);
                vinoRepository.save(vinoPedernalWines2);
                vinoRepository.save(vinoGranPedernal1);
                vinoRepository.save(vinoGranPedernal2);
                vinoRepository.save(vinoCalingasta1);
                vinoRepository.save(vinoCalingasta2);
                vinoRepository.save(vinoVallesDeCalingasta1);
                vinoRepository.save(vinoVallesDeCalingasta2);
                vinoRepository.save(vinoCopiapo1);
                vinoRepository.save(vinoCopiapo2);
                vinoRepository.save(vinoHuasco1);
                vinoRepository.save(vinoHuasco2);
                vinoRepository.save(vinoItata1);
                vinoRepository.save(vinoItata2);
                vinoRepository.save(vinoMaule1);
                vinoRepository.save(vinoMaule2);
                vinoRepository.save(vinoCasablanca1);
                vinoRepository.save(vinoCasablanca2);
                vinoRepository.save(vinoSanAntonio1);
                vinoRepository.save(vinoSanAntonio2);
                vinoRepository.save(vinoValeDosVinhedos1);
                vinoRepository.save(vinoValeDosVinhedos2);
                vinoRepository.save(vinoSerraGaucha1);
                vinoRepository.save(vinoSerraGaucha2);
                vinoRepository.save(vinoCamposDeCima1);
                vinoRepository.save(vinoCamposDeCima2);
                vinoRepository.save(vinoCanelonesRegion1);
                vinoRepository.save(vinoCanelonesRegion2);
                vinoRepository.save(vinoMontevideoRegion1);
                vinoRepository.save(vinoMontevideoRegion2);
                vinoRepository.save(vinoIcaRegion1);
                vinoRepository.save(vinoIcaRegion2);
                vinoRepository.save(vinoCuscoRegion1);
                vinoRepository.save(vinoCuscoRegion2);
                vinoRepository.save(vinoValleCalchaqui1);
                vinoRepository.save(vinoValleCalchaqui2);
                vinoRepository.save(vinoCafayate1);
                vinoRepository.save(vinoCafayate2);
                vinoRepository.save(vinoQuebradaDeHumahuaca1);
                vinoRepository.save(vinoQuebradaDeHumahuaca2);

                // Crear varietales
                Varietal malbecVarietal = new Varietal(null, "Malbec", 100.0f, null);
                Varietal cabernetVarietal = new Varietal(null, "Cabernet Sauvignon", 100.0f, null);
                Varietal syrahVarietal = new Varietal(null, "Syrah", 100.0f, null);
                Varietal merlotVarietal = new Varietal(null, "Merlot", 100.0f, null);
                Varietal chardonnayVarietal = new Varietal(null, "Chardonnay", 100.0f, null);

                // Persistir varietales
                varietalRepository.save(malbecVarietal);
                varietalRepository.save(cabernetVarietal);
                varietalRepository.save(syrahVarietal);
                varietalRepository.save(merlotVarietal);
                varietalRepository.save(chardonnayVarietal);

                // Asignar varietales a los vinos
                vinoBioBioRegion1.setVarietal(Arrays.asList(malbecVarietal, cabernetVarietal));
                vinoSanPedro1.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));
                vinoArtigas1.setVarietal(Arrays.asList(chardonnayVarietal, malbecVarietal));
                vinoCerroLargo1.setVarietal(Arrays.asList(cabernetVarietal, syrahVarietal));
                vinoRivera1.setVarietal(Arrays.asList(merlotVarietal, chardonnayVarietal));
                vinoChincha1.setVarietal(Arrays.asList(malbecVarietal, syrahVarietal));
                vinoNazca1.setVarietal(Arrays.asList(cabernetVarietal, merlotVarietal));
                vinoLimaValley1.setVarietal(Arrays.asList(chardonnayVarietal, malbecVarietal));
                vinoTulumVineyards1.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));
                vinoSanJuanVino1.setVarietal(Arrays.asList(cabernetVarietal, syrahVarietal));
                vinoZondaVineyards1.setVarietal(Arrays.asList(merlotVarietal, chardonnayVarietal));
                vinoVinoElegante1.setVarietal(Arrays.asList(malbecVarietal, syrahVarietal));
                vinoPedernalWines1.setVarietal(Arrays.asList(cabernetVarietal, merlotVarietal));
                vinoGranPedernal1.setVarietal(Arrays.asList(chardonnayVarietal, malbecVarietal));
                vinoCalingasta1.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));
                vinoVallesDeCalingasta1.setVarietal(Arrays.asList(cabernetVarietal, chardonnayVarietal));
                vinoCopiapo1.setVarietal(Arrays.asList(malbecVarietal, syrahVarietal));
                vinoHuasco1.setVarietal(Arrays.asList(merlotVarietal, chardonnayVarietal));
                vinoItata1.setVarietal(Arrays.asList(cabernetVarietal, syrahVarietal));
                vinoMaule1.setVarietal(Arrays.asList(malbecVarietal, merlotVarietal));
                vinoCasablanca1.setVarietal(Arrays.asList(chardonnayVarietal, syrahVarietal));
                vinoSanAntonio1.setVarietal(Arrays.asList(cabernetVarietal, merlotVarietal));
                vinoValeDosVinhedos1.setVarietal(Arrays.asList(malbecVarietal, chardonnayVarietal));
                vinoSerraGaucha1.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));
                vinoCamposDeCima1.setVarietal(Arrays.asList(cabernetVarietal, chardonnayVarietal));
                vinoCanelonesRegion1.setVarietal(Arrays.asList(malbecVarietal, syrahVarietal));
                vinoMontevideoRegion1.setVarietal(Arrays.asList(merlotVarietal, chardonnayVarietal));
                vinoIcaRegion1.setVarietal(Arrays.asList(cabernetVarietal, syrahVarietal));
                vinoCuscoRegion1.setVarietal(Arrays.asList(malbecVarietal, merlotVarietal));
                vinoValleCalchaqui1.setVarietal(Arrays.asList(chardonnayVarietal, syrahVarietal));
                vinoCafayate1.setVarietal(Arrays.asList(cabernetVarietal, merlotVarietal));
                vinoQuebradaDeHumahuaca1.setVarietal(Arrays.asList(malbecVarietal, chardonnayVarietal));
                vinoPlanaltoCatarinense1.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));
                vinoBioBioRegion2.setVarietal(Arrays.asList(cabernetVarietal, chardonnayVarietal));
                vinoSanPedro2.setVarietal(Arrays.asList(malbecVarietal, syrahVarietal));
                vinoArtigas2.setVarietal(Arrays.asList(merlotVarietal, chardonnayVarietal));
                vinoCerroLargo2.setVarietal(Arrays.asList(cabernetVarietal, syrahVarietal));
                vinoRivera2.setVarietal(Arrays.asList(malbecVarietal, merlotVarietal));
                vinoChincha2.setVarietal(Arrays.asList(chardonnayVarietal, syrahVarietal));
                vinoNazca2.setVarietal(Arrays.asList(cabernetVarietal, merlotVarietal));
                vinoLimaValley2.setVarietal(Arrays.asList(malbecVarietal, chardonnayVarietal));
                vinoTulumVineyards2.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));
                vinoSanJuanVino2.setVarietal(Arrays.asList(cabernetVarietal, syrahVarietal));
                vinoZondaVineyards2.setVarietal(Arrays.asList(merlotVarietal, chardonnayVarietal));
                vinoVinoElegante2.setVarietal(Arrays.asList(malbecVarietal, syrahVarietal));
                vinoPedernalWines2.setVarietal(Arrays.asList(cabernetVarietal, merlotVarietal));
                vinoGranPedernal2.setVarietal(Arrays.asList(chardonnayVarietal, malbecVarietal));
                vinoCalingasta2.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));
                vinoVallesDeCalingasta2.setVarietal(Arrays.asList(cabernetVarietal, chardonnayVarietal));
                vinoCopiapo2.setVarietal(Arrays.asList(malbecVarietal, syrahVarietal));
                vinoHuasco2.setVarietal(Arrays.asList(merlotVarietal, chardonnayVarietal));
                vinoItata2.setVarietal(Arrays.asList(cabernetVarietal, syrahVarietal));
                vinoMaule2.setVarietal(Arrays.asList(malbecVarietal, merlotVarietal));
                vinoCasablanca2.setVarietal(Arrays.asList(chardonnayVarietal, syrahVarietal));
                vinoSanAntonio2.setVarietal(Arrays.asList(cabernetVarietal, merlotVarietal));
                vinoValeDosVinhedos2.setVarietal(Arrays.asList(malbecVarietal, chardonnayVarietal));
                vinoSerraGaucha2.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));
                vinoCamposDeCima2.setVarietal(Arrays.asList(cabernetVarietal, chardonnayVarietal));
                vinoCanelonesRegion2.setVarietal(Arrays.asList(malbecVarietal, syrahVarietal));
                vinoMontevideoRegion2.setVarietal(Arrays.asList(merlotVarietal, chardonnayVarietal));
                vinoIcaRegion2.setVarietal(Arrays.asList(cabernetVarietal, syrahVarietal));
                vinoCuscoRegion2.setVarietal(Arrays.asList(malbecVarietal, merlotVarietal));
                vinoValleCalchaqui2.setVarietal(Arrays.asList(chardonnayVarietal, syrahVarietal));
                vinoCafayate2.setVarietal(Arrays.asList(cabernetVarietal, merlotVarietal));
                vinoQuebradaDeHumahuaca2.setVarietal(Arrays.asList(malbecVarietal, chardonnayVarietal));
                vinoPlanaltoCatarinense2.setVarietal(Arrays.asList(syrahVarietal, merlotVarietal));

                vinoRepository.save(vinoBioBioRegion1);
                vinoRepository.save(vinoBioBioRegion2);
                vinoRepository.save(vinoSanPedro1);
                vinoRepository.save(vinoSanPedro2);
                vinoRepository.save(vinoArtigas2);
                vinoRepository.save(vinoCerroLargo1);
                vinoRepository.save(vinoCerroLargo2);
                vinoRepository.save(vinoRivera1);
                vinoRepository.save(vinoChincha1);
                vinoRepository.save(vinoChincha2);
                vinoRepository.save(vinoNazca1);
                vinoRepository.save(vinoNazca2);
                vinoRepository.save(vinoLimaValley1);
                vinoRepository.save(vinoLimaValley2);
                vinoRepository.save(vinoTulumVineyards1);
                vinoRepository.save(vinoTulumVineyards2);
                vinoRepository.save(vinoSanJuanVino1);
                vinoRepository.save(vinoSanJuanVino2);
                vinoRepository.save(vinoZondaVineyards1);
                vinoRepository.save(vinoZondaVineyards2);
                vinoRepository.save(vinoVinoElegante1);
                vinoRepository.save(vinoVinoElegante2);
                vinoRepository.save(vinoPedernalWines1);
                vinoRepository.save(vinoPedernalWines2);
                vinoRepository.save(vinoGranPedernal1);
                vinoRepository.save(vinoGranPedernal2);
                vinoRepository.save(vinoCalingasta1);
                vinoRepository.save(vinoCalingasta2);
                vinoRepository.save(vinoVallesDeCalingasta1);
                vinoRepository.save(vinoVallesDeCalingasta2);
                vinoRepository.save(vinoCopiapo1);
                vinoRepository.save(vinoCopiapo2);
                vinoRepository.save(vinoHuasco1);
                vinoRepository.save(vinoHuasco2);
                vinoRepository.save(vinoItata1);
                vinoRepository.save(vinoItata2);
                vinoRepository.save(vinoMaule1);
                vinoRepository.save(vinoMaule2);
                vinoRepository.save(vinoCasablanca1);
                vinoRepository.save(vinoCasablanca2);
                vinoRepository.save(vinoSanAntonio1);
                vinoRepository.save(vinoSanAntonio2);
                vinoRepository.save(vinoValeDosVinhedos1);
                vinoRepository.save(vinoValeDosVinhedos2);
                vinoRepository.save(vinoSerraGaucha1);
                vinoRepository.save(vinoSerraGaucha2);
                vinoRepository.save(vinoCamposDeCima1);
                vinoRepository.save(vinoCamposDeCima2);
                vinoRepository.save(vinoCanelonesRegion1);
                vinoRepository.save(vinoCanelonesRegion2);
                vinoRepository.save(vinoMontevideoRegion1);
                vinoRepository.save(vinoMontevideoRegion2);
                vinoRepository.save(vinoIcaRegion1);
                vinoRepository.save(vinoIcaRegion2);
                vinoRepository.save(vinoCuscoRegion1);
                vinoRepository.save(vinoCuscoRegion2);
                vinoRepository.save(vinoValleCalchaqui1);
                vinoRepository.save(vinoValleCalchaqui2);
                vinoRepository.save(vinoCafayate1);
                vinoRepository.save(vinoCafayate2);
                vinoRepository.save(vinoQuebradaDeHumahuaca1);
                vinoRepository.save(vinoQuebradaDeHumahuaca2);
                vinoRepository.save(vinoBioBioRegion1);
                vinoRepository.save(vinoBioBioRegion2);
                vinoRepository.save(vinoSanPedro1);
                vinoRepository.save(vinoSanPedro2);
                vinoRepository.save(vinoArtigas1);
                vinoRepository.save(vinoArtigas2);
                vinoRepository.save(vinoCerroLargo1);
                vinoRepository.save(vinoCerroLargo2);
                vinoRepository.save(vinoRivera1);
                vinoRepository.save(vinoChincha1);
                vinoRepository.save(vinoChincha2);
                vinoRepository.save(vinoNazca1);
                vinoRepository.save(vinoNazca2);
                vinoRepository.save(vinoLimaValley1);
                vinoRepository.save(vinoLimaValley2);
                vinoRepository.save(vinoTulumVineyards1);
                vinoRepository.save(vinoTulumVineyards2);
                vinoRepository.save(vinoSanJuanVino1);
                vinoRepository.save(vinoSanJuanVino2);
                vinoRepository.save(vinoZondaVineyards1);
                vinoRepository.save(vinoZondaVineyards2);
                vinoRepository.save(vinoVinoElegante1);
                vinoRepository.save(vinoVinoElegante2);
                vinoRepository.save(vinoPedernalWines1);
                vinoRepository.save(vinoPedernalWines2);
                vinoRepository.save(vinoGranPedernal1);
                vinoRepository.save(vinoGranPedernal2);
                vinoRepository.save(vinoCalingasta1);
                vinoRepository.save(vinoCalingasta2);
                vinoRepository.save(vinoVallesDeCalingasta1);
                vinoRepository.save(vinoVallesDeCalingasta2);
                vinoRepository.save(vinoCopiapo1);
                vinoRepository.save(vinoCopiapo2);
                vinoRepository.save(vinoHuasco1);
                vinoRepository.save(vinoHuasco2);
                vinoRepository.save(vinoItata1);
                vinoRepository.save(vinoItata2);
                vinoRepository.save(vinoMaule1);
                vinoRepository.save(vinoMaule2);
                vinoRepository.save(vinoCasablanca1);
                vinoRepository.save(vinoCasablanca2);
                vinoRepository.save(vinoSanAntonio1);
                vinoRepository.save(vinoSanAntonio2);
                vinoRepository.save(vinoValeDosVinhedos1);
                vinoRepository.save(vinoValeDosVinhedos2);
                vinoRepository.save(vinoSerraGaucha1);
                vinoRepository.save(vinoSerraGaucha2);
                vinoRepository.save(vinoCamposDeCima1);
                vinoRepository.save(vinoCamposDeCima2);
                vinoRepository.save(vinoCanelonesRegion1);
                vinoRepository.save(vinoCanelonesRegion2);
                vinoRepository.save(vinoMontevideoRegion1);
                vinoRepository.save(vinoMontevideoRegion2);
                vinoRepository.save(vinoIcaRegion1);
                vinoRepository.save(vinoIcaRegion2);
                vinoRepository.save(vinoCuscoRegion1);
                vinoRepository.save(vinoCuscoRegion2);
                vinoRepository.save(vinoValleCalchaqui1);
                vinoRepository.save(vinoValleCalchaqui2);
                vinoRepository.save(vinoCafayate1);
                vinoRepository.save(vinoCafayate2);
                vinoRepository.save(vinoQuebradaDeHumahuaca1);
                vinoRepository.save(vinoQuebradaDeHumahuaca2);

                // Persistir vinos
                
                

                Resena reseñaBioBioRegion1_1 = new Resena(null,
                "Excelente vino de Bío Bío, muy fresco y con un toque mineral único.", new Date(), 4.7f,
                true,
                vinoBioBioRegion1);
                
                Resena reseñaBioBioRegion1_2 = new Resena(null,
                                "Un vino con cuerpo y buena acidez, ideal para maridar con pescados.", new Date(), 4.3f,
                                true,
                                vinoBioBioRegion1);
                Resena reseñaBioBioRegion1_3 = new Resena(null, "Un vino elegante, pero le falta algo de complejidad.",
                                new Date(), 3.8f, false, vinoBioBioRegion1);
                Resena reseñaBioBioRegion1_4 = new Resena(null,
                                "Un gran vino que resalta la frescura de la región, muy recomendable.", new Date(),
                                4.6f, true,
                                vinoBioBioRegion1);
                Resena reseñaBioBioRegion1_5 = new Resena(null,
                                "Delicado pero con carácter. Perfecto para una cena ligera.",
                                new Date(), 4.2f, true, vinoBioBioRegion1);

                // Persistir 
                Resena reseñaBioBioRegion2_1 = new Resena(null,
                                "Un vino que refleja la frescura del sur de Chile, muy bien logrado.", new Date(), 4.5f,
                                true,
                                vinoBioBioRegion2);
                Resena reseñaBioBioRegion2_2 = new Resena(null,
                                "Interesante mezcla de acidez y fruta, con un final agradable.",
                                new Date(), 4.0f, true, vinoBioBioRegion2);
                Resena reseñaBioBioRegion2_3 = new Resena(null,
                                "Sutil y fresco, pero se queda corto en cuanto a intensidad de sabores.", new Date(),
                                3.6f, false,
                                vinoBioBioRegion2);
                Resena reseñaBioBioRegion2_4 = new Resena(null,
                                "Muy bien equilibrado, ideal para acompañar mariscos o ensaladas.", new Date(), 4.3f,
                                true,
                                vinoBioBioRegion2);
                Resena reseñaBioBioRegion2_5 = new Resena(null,
                                "Un vino para quienes disfrutan de vinos frescos y ligeros.",
                                new Date(), 4.1f, true, vinoBioBioRegion2);

                // Persistir 
                Resena reseñaSanPedro1_1 = new Resena(null,
                                "Un vino redondo con taninos suaves, ideal para carne asada.",
                                new Date(), 4.8f, true, vinoSanPedro1);
                Resena reseñaSanPedro1_2 = new Resena(null,
                                "Bajo en acidez pero con una rica estructura, perfecto para una tarde en familia.",
                                new Date(), 4.4f,
                                true, vinoSanPedro1);
                Resena reseñaSanPedro1_3 = new Resena(null,
                                "Vino con notas de frutas maduras, aunque le falta un poco de complejidad.", new Date(),
                                3.9f, false,
                                vinoSanPedro1);
                Resena reseñaSanPedro1_4 = new Resena(null,
                                "Ideal para acompañar pastas o carnes blancas, tiene un sabor muy agradable.",
                                new Date(), 4.5f, true,
                                vinoSanPedro1);
                Resena reseñaSanPedro1_5 = new Resena(null,
                                "Buen equilibrio entre acidez y dulzura, aunque no es tan memorable.", new Date(), 4.0f,
                                true,
                                vinoSanPedro1);

                Resena reseñaSanPedro2_1 = new Resena(null,
                                "Un vino muy equilibrado, con buena estructura y persistente en el paladar.",
                                new Date(), 4.6f, true,
                                vinoSanPedro2);
                Resena reseñaSanPedro2_2 = new Resena(null,
                                "Agradable y suave, pero le falta algo de complejidad para destacar.", new Date(), 3.9f,
                                false,
                                vinoSanPedro2);
                Resena reseñaSanPedro2_3 = new Resena(null,
                                "Perfecto para acompañar parrilladas, con notas de frutos rojos.",
                                new Date(), 4.2f, true, vinoSanPedro2);
                Resena reseñaSanPedro2_4 = new Resena(null,
                                "Gran calidad para un vino de esta región, con taninos redondeados.", new Date(), 4.4f,
                                true,
                                vinoSanPedro2);
                Resena reseñaSanPedro2_5 = new Resena(null, "Vino con un final largo, ideal para disfrutar lentamente.",
                                new Date(), 4.3f, true, vinoSanPedro2);

              
                Resena reseñaArtigas1_2 = new Resena(null,
                                "Muy bien equilibrado, con una acidez refrescante y buen cuerpo.",
                                new Date(), 4.5f, true, vinoArtigas1);
                Resena reseñaArtigas1_3 = new Resena(null,
                                "Notas de especias y frutas rojas, un vino para disfrutar con carnes.", new Date(),
                                4.2f, true,
                                vinoArtigas1);
                Resena reseñaArtigas1_4 = new Resena(null,
                                "Algo ácido al principio, pero se suaviza y se vuelve muy agradable.", new Date(), 4.0f,
                                true,
                                vinoArtigas1);
                Resena reseñaArtigas1_5 = new Resena(null,
                                "Un vino robusto y con carácter, aunque podría tener un toque más afrutado.",
                                new Date(), 3.9f, false,
                                vinoArtigas1);

                Resena reseñaArtigas2_1 = new Resena(null,
                                "Vino elegante, con notas de frutos negros y un final persistente.",
                                new Date(), 4.6f, true, vinoArtigas2);
                Resena reseñaArtigas2_2 = new Resena(null,
                                "Buen equilibrio entre acidez y suavidad, ideal para maridar con carnes rojas.",
                                new Date(), 4.4f, true,
                                vinoArtigas2);
                Resena reseñaArtigas2_3 = new Resena(null,
                                "Un vino robusto, con un toque especiado que le da complejidad.",
                                new Date(), 4.3f, true, vinoArtigas2);
                Resena reseñaArtigas2_4 = new Resena(null,
                                "Fresco pero con carácter, un excelente vino para el día a día.",
                                new Date(), 4.2f, true, vinoArtigas2);
                Resena reseñaArtigas2_5 = new Resena(null,
                                "No destaca demasiado en aromas, pero tiene una buena estructura.",
                                new Date(), 3.9f, false, vinoArtigas2);


                Resena reseñaCerroLargo1_1 = new Resena(null,
                                "Un vino que se disfruta mucho, con notas de frutos rojos y un toque sutil de madera.",
                                new Date(),
                                4.7f, true, vinoCerroLargo1);
                Resena reseñaCerroLargo1_2 = new Resena(null, "Muy buena acidez, equilibrado y fácil de beber.",
                                new Date(),
                                4.3f, true, vinoCerroLargo1);
                Resena reseñaCerroLargo1_3 = new Resena(null,
                                "Un vino delicado, con taninos suaves y un final redondo.",
                                new Date(), 4.4f, true, vinoCerroLargo1);
                Resena reseñaCerroLargo1_4 = new Resena(null,
                                "Agradable, pero le falta algo de intensidad y complejidad.",
                                new Date(), 3.9f, false, vinoCerroLargo1);
                Resena reseñaCerroLargo1_5 = new Resena(null,
                                "Vino refrescante y fácil de disfrutar, ideal para reuniones informales.", new Date(),
                                4.2f, true,
                                vinoCerroLargo1);

                Resena reseñaCerroLargo2_1 = new Resena(null,
                                "Gran vino de la región, con un cuerpo bien equilibrado y buena persistencia.",
                                new Date(), 4.6f, true,
                                vinoCerroLargo2);
                Resena reseñaCerroLargo2_2 = new Resena(null,
                                "Taninos redondeados y una acidez que lo hace muy agradable al paladar.", new Date(),
                                4.5f, true,
                                vinoCerroLargo2);
                Resena reseñaCerroLargo2_3 = new Resena(null,
                                "Este vino es elegante y se puede disfrutar con una variedad de comidas.", new Date(),
                                4.3f, true,
                                vinoCerroLargo2);
                Resena reseñaCerroLargo2_4 = new Resena(null,
                                "No es tan impresionante, pero cumple bien con las expectativas.",
                                new Date(), 4.0f, true, vinoCerroLargo2);
                Resena reseñaCerroLargo2_5 = new Resena(null,
                                "Vino con notas herbales y un toque ligeramente afrutado.",
                                new Date(), 3.8f, false, vinoCerroLargo2);


                Resena reseñaRivera1_1 = new Resena(null,
                                "Vino robusto y con mucho cuerpo, ideal para acompañar carnes.",
                                new Date(), 4.8f, true, vinoRivera1);
                Resena reseñaRivera1_2 = new Resena(null,
                                "Excelente para maridar con platos a la parrilla, aunque podría tener un poco más de suavidad.",
                                new Date(), 4.5f, true, vinoRivera1);
                Resena reseñaRivera1_3 = new Resena(null,
                                "Vino con mucha presencia, pero algo desbalanceado en su final.",
                                new Date(), 4.1f, false, vinoRivera1);
                Resena reseñaRivera1_4 = new Resena(null,
                                "Buen vino para ocasiones especiales, con una gran persistencia en el paladar.",
                                new Date(), 4.7f, true,
                                vinoRivera1);
                Resena reseñaRivera1_5 = new Resena(null,
                                "Falta algo de frescura, pero en general es un vino agradable y bien estructurado.",
                                new Date(), 4.0f,
                                true, vinoRivera1);

                Resena reseñaChincha1_1 = new Resena(null, "Un vino con mucha frescura, ideal para un día caluroso.",
                                new Date(), 4.6f, true, vinoChincha1);
                Resena reseñaChincha1_2 = new Resena(null, "Agradable en boca, con un toque frutal que destaca.",
                                new Date(),
                                4.4f, true, vinoChincha1);
                Resena reseñaChincha1_3 = new Resena(null, "Buen equilibrio, aunque le falta algo de complejidad.",
                                new Date(),
                                4.2f, true, vinoChincha1);
                Resena reseñaChincha1_4 = new Resena(null, "Sabor suave y fácil de beber, muy versátil para maridar.",
                                new Date(), 4.3f, true, vinoChincha1);
                Resena reseñaChincha1_5 = new Resena(null, "Vino sencillo, pero bien logrado. Ideal para novatos.",
                                new Date(),
                                3.8f, false, vinoChincha1);


                Resena reseñaChincha2_1 = new Resena(null, "Notable sabor a frutas rojas maduras, muy equilibrado.",
                                new Date(),
                                4.7f, true, vinoChincha2);
                Resena reseñaChincha2_2 = new Resena(null, "Vino con cuerpo medio, ideal para acompañar carnes.",
                                new Date(),
                                4.5f, true, vinoChincha2);
                Resena reseñaChincha2_3 = new Resena(null,
                                "Un toque suave de especias complementa perfectamente los sabores afrutados.",
                                new Date(), 4.4f, true,
                                vinoChincha2);
                Resena reseñaChincha2_4 = new Resena(null,
                                "No tiene mucha complejidad, pero es muy agradable y fácil de beber.", new Date(), 4.1f,
                                true,
                                vinoChincha2);
                Resena reseñaChincha2_5 = new Resena(null,
                                "Un vino bien equilibrado, aunque carece de una final largo.",
                                new Date(), 4.0f, false, vinoChincha2);

                // Persistir 
                Resena reseñaNazca1_1 = new Resena(null,
                                "Excelente vino con un toque a frutos rojos y un leve toque especiado.", new Date(),
                                4.8f, true,
                                vinoNazca1);
                Resena reseñaNazca1_2 = new Resena(null,
                                "Vino bien equilibrado, con una acidez perfecta para maridar con platos de carne.",
                                new Date(), 4.6f,
                                true, vinoNazca1);
                Resena reseñaNazca1_3 = new Resena(null, "Agradable en boca, con un retrogusto afrutado muy agradable.",
                                new Date(), 4.4f, true, vinoNazca1);
                Resena reseñaNazca1_4 = new Resena(null, "Buen cuerpo y estructura, ideal para una comida más pesada.",
                                new Date(), 4.2f, true, vinoNazca1);
                Resena reseñaNazca1_5 = new Resena(null, "Algo monótono, le falta algo de complejidad en el final.",
                                new Date(),
                                3.9f, false, vinoNazca1);

                // Persistir 
                Resena reseñaNazca2_1 = new Resena(null,
                                "Buen vino, con un toque elegante de frutos secos y taninos suaves.",
                                new Date(), 4.7f, true, vinoNazca2);
                Resena reseñaNazca2_2 = new Resena(null,
                                "Interesante combinación de frutas rojas y un final de vainilla, muy bien logrado.",
                                new Date(), 4.5f,
                                true, vinoNazca2);
                Resena reseñaNazca2_3 = new Resena(null,
                                "Le falta algo de cuerpo, pero en general es agradable y fácil de beber.", new Date(),
                                4.3f, true,
                                vinoNazca2);
                Resena reseñaNazca2_4 = new Resena(null,
                                "Vino con un toque afrutado y agradable, pero sin mucha complejidad en el final.",
                                new Date(), 4.0f,
                                false, vinoNazca2);
                Resena reseñaNazca2_5 = new Resena(null,
                                "No es un vino extraordinario, pero es adecuado para ocasiones informales.", new Date(),
                                3.8f, false,
                                vinoNazca2);

                Resena reseñaLimaValley1_1 = new Resena(null,
                                "Fresco, con notas herbales y un final refrescante, ideal para días calurosos.",
                                new Date(), 4.6f, true,
                                vinoLimaValley1);
                Resena reseñaLimaValley1_2 = new Resena(null,
                                "Vino suave y ligero, perfecto para acompañar ensaladas y pescados.", new Date(), 4.3f,
                                true,
                                vinoLimaValley1);
                Resena reseñaLimaValley1_3 = new Resena(null,
                                "Fácil de beber, con una buena acidez que lo hace refrescante.",
                                new Date(), 4.4f, true, vinoLimaValley1);
                Resena reseñaLimaValley1_4 = new Resena(null,
                                "Vino algo básico, pero cumple su función en una reunión informal.", new Date(), 4.1f,
                                true,
                                vinoLimaValley1);
                Resena reseñaLimaValley1_5 = new Resena(null, "Demasiado simple, le falta algo de complejidad.",
                                new Date(),
                                3.8f, false, vinoLimaValley1);

                // Persistir 
                Resena reseñaLimaValley2_1 = new Resena(null,
                                "Muy bien equilibrado, con notas a frutas cítricas y un final agradable.", new Date(),
                                4.7f, true,
                                vinoLimaValley2);
                Resena reseñaLimaValley2_2 = new Resena(null,
                                "Vino ligero y fresco, perfecto para acompañar pescados o mariscos.", new Date(), 4.5f,
                                true,
                                vinoLimaValley2);
                Resena reseñaLimaValley2_3 = new Resena(null,
                                "Fresco, con un toque de acidez que lo hace ideal para disfrutar en climas cálidos.",
                                new Date(), 4.3f,
                                true, vinoLimaValley2);
                Resena reseñaLimaValley2_4 = new Resena(null,
                                "Vino sencillo y fácil de beber, pero le falta algo de complejidad en el final.",
                                new Date(), 4.0f,
                                true, vinoLimaValley2);
                Resena reseñaLimaValley2_5 = new Resena(null,
                                "Bajo en cuerpo, pero refrescante y adecuado para una ocasión informal.", new Date(),
                                3.9f, false,
                                vinoLimaValley2);

                Resena reseñaTulumVineyards1_1 = new Resena(null,
                                "Excelente balance entre frescura y cuerpo, ideal para maridar con mariscos.",
                                new Date(), 4.8f, true,
                                vinoTulumVineyards1);
                Resena reseñaTulumVineyards1_2 = new Resena(null,
                                "Vino bien estructurado, con una acidez que equilibra sus notas afrutadas.", new Date(),
                                4.6f, true,
                                vinoTulumVineyards1);
                Resena reseñaTulumVineyards1_3 = new Resena(null, "Agradable y suave, con una textura cremosa en boca.",
                                new Date(), 4.5f, true, vinoTulumVineyards1);
                Resena reseñaTulumVineyards1_4 = new Resena(null,
                                "Ideal para acompañar carnes blancas, tiene un retrogusto muy delicado.", new Date(),
                                4.4f, true,
                                vinoTulumVineyards1);
                Resena reseñaTulumVineyards1_5 = new Resena(null,
                                "Vino algo simple, pero adecuado para una tarde con amigos.",
                                new Date(), 4.0f, false, vinoTulumVineyards1);

                // Persistir 
                Resena reseñaTulumVineyards2_1 = new Resena(null,
                                "Vino de excelente calidad, con una acidez que lo hace muy refrescante.", new Date(),
                                4.7f, true,
                                vinoTulumVineyards2);
                Resena reseñaTulumVineyards2_2 = new Resena(null,
                                "Notas de frutas tropicales y una textura suave, lo convierten en un vino muy placentero.",
                                new Date(),
                                4.6f, true, vinoTulumVineyards2);
                Resena reseñaTulumVineyards2_3 = new Resena(null,
                                "Perfecto para maridar con platos picantes, tiene un final ligeramente amargo.",
                                new Date(), 4.4f, true,
                                vinoTulumVineyards2);
                Resena reseñaTulumVineyards2_4 = new Resena(null,
                                "Vino bien logrado, pero podría tener más cuerpo y complejidad.", new Date(), 4.1f,
                                true,
                                vinoTulumVineyards2);
                Resena reseñaTulumVineyards2_5 = new Resena(null,
                                "Algo monótono, le falta algo de innovación en el perfil de sabor.", new Date(), 3.9f,
                                false,
                                vinoTulumVineyards2);

                Resena reseñaSanJuanVino1_1 = new Resena(null,
                                "Gran vino de cuerpo robusto y excelente estructura, ideal para platos fuertes.",
                                new Date(), 4.9f,
                                true, vinoSanJuanVino1);
                Resena reseñaSanJuanVino1_2 = new Resena(null,
                                "Vino profundo y elegante, con una mezcla de especias que lo hace muy interesante.",
                                new Date(), 4.7f,
                                true, vinoSanJuanVino1);
                Resena reseñaSanJuanVino1_3 = new Resena(null,
                                "Muy bueno, con un final largo y persistente que destaca en el paladar.", new Date(),
                                4.5f, true,
                                vinoSanJuanVino1);
                Resena reseñaSanJuanVino1_4 = new Resena(null,
                                "Buen equilibrio entre frutas y taninos, aunque le falta algo de complejidad.",
                                new Date(), 4.2f, true,
                                vinoSanJuanVino1);
                Resena reseñaSanJuanVino1_5 = new Resena(null,
                                "Sabor suave, pero demasiado ligero para mi gusto. Ideal para quienes prefieren vinos menos intensos.",
                                new Date(), 3.8f, false, vinoSanJuanVino1);

                // Persistir 
                Resena reseñaSanJuanVino2_1 = new Resena(null,
                                "Vino robusto, con notas especiadas y un toque ahumado que lo hace único.", new Date(),
                                4.8f, true,
                                vinoSanJuanVino2);
                Resena reseñaSanJuanVino2_2 = new Resena(null,
                                "Interesante mezcla de frutas rojas y un final algo terroso, pero bien logrado.",
                                new Date(), 4.6f,
                                true, vinoSanJuanVino2);
                Resena reseñaSanJuanVino2_3 = new Resena(null,
                                "Vino de buen cuerpo, con una acidez perfecta que lo hace ideal para carnes.",
                                new Date(), 4.4f, true,
                                vinoSanJuanVino2);
                Resena reseñaSanJuanVino2_4 = new Resena(null,
                                "Vino agradable, pero la falta de complejidad lo hace menos memorable.", new Date(),
                                4.0f, true,
                                vinoSanJuanVino2);
                Resena reseñaSanJuanVino2_5 = new Resena(null,
                                "No muy interesante, pero cumple con lo básico. Puede ser adecuado para ocasiones informales.",
                                new Date(), 3.8f, false, vinoSanJuanVino2);

                // Persistir 
                Resena reseñaZondaVineyards1_1 = new Resena(null,
                                "Excelente vino con un toque afrutado y un final elegante, ideal para carnes rojas.",
                                new Date(), 4.9f,
                                true, vinoZondaVineyards1);
                Resena reseñaZondaVineyards1_2 = new Resena(null,
                                "Un vino con cuerpo, bien equilibrado, que resalta por sus notas especiadas.",
                                new Date(), 4.7f, true,
                                vinoZondaVineyards1);
                Resena reseñaZondaVineyards1_3 = new Resena(null,
                                "Agradable y con una acidez bien integrada, pero le falta algo de complejidad.",
                                new Date(), 4.5f, true,
                                vinoZondaVineyards1);
                Resena reseñaZondaVineyards1_4 = new Resena(null,
                                "Buen vino, con una estructura sólida y un final bastante persistente.", new Date(),
                                4.3f, true,
                                vinoZondaVineyards1);
                Resena reseñaZondaVineyards1_5 = new Resena(null,
                                "Un vino correcto, pero no destaca por nada en particular.",
                                new Date(), 3.9f, false, vinoZondaVineyards1);

                // Persistir 
                Resena reseñaZondaVineyards2_1 = new Resena(null,
                                "Vino con un equilibrio perfecto entre frutas y taninos, muy bien logrado.", new Date(),
                                4.8f, true,
                                vinoZondaVineyards2);
                Resena reseñaZondaVineyards2_2 = new Resena(null,
                                "Suave y elegante, con un final largo y una mezcla perfecta de especias.", new Date(),
                                4.6f, true,
                                vinoZondaVineyards2);
                Resena reseñaZondaVineyards2_3 = new Resena(null,
                                "Un vino robusto y estructurado, con un toque ahumado que lo hace especial.",
                                new Date(), 4.4f, true,
                                vinoZondaVineyards2);
                Resena reseñaZondaVineyards2_4 = new Resena(null,
                                "Agradable, aunque un poco más sencillo de lo que esperaba.",
                                new Date(), 4.2f, true, vinoZondaVineyards2);
                Resena reseñaZondaVineyards2_5 = new Resena(null,
                                "Buen vino, pero me gustaría que tuviera un perfil de sabor más profundo.", new Date(),
                                4.0f, false,
                                vinoZondaVineyards2);

                Resena reseñaVinoElegante1_1 = new Resena(null,
                                "Un vino refinado con toques de frutas rojas y un final suave.",
                                new Date(), 4.9f, true, vinoVinoElegante1);
                Resena reseñaVinoElegante1_2 = new Resena(null,
                                "Excelente estructura y armonía, con notas especiadas que se combinan perfectamente.",
                                new Date(), 4.7f,
                                true, vinoVinoElegante1);
                Resena reseñaVinoElegante1_3 = new Resena(null,
                                "Vino con mucho carácter y una acidez bien equilibrada. Ideal para carnes a la parrilla.",
                                new Date(),
                                4.5f, true, vinoVinoElegante1);
                Resena reseñaVinoElegante1_4 = new Resena(null,
                                "Agradable y suave, aunque le falta algo de complejidad en su sabor.", new Date(), 4.2f,
                                true,
                                vinoVinoElegante1);
                Resena reseñaVinoElegante1_5 = new Resena(null,
                                "Un buen vino, pero no es tan memorable como otros de esta misma gama.", new Date(),
                                4.0f, false,
                                vinoVinoElegante1);

                Resena reseñaVinoElegante2_1 = new Resena(null,
                                "Sofisticado, con un toque de frutas rojas maduras y un final largo.", new Date(), 4.8f,
                                true,
                                vinoVinoElegante2);
                Resena reseñaVinoElegante2_2 = new Resena(null,
                                "Gran vino, muy bien equilibrado, ideal para acompañar platos gourmet.", new Date(),
                                4.6f, true,
                                vinoVinoElegante2);
                Resena reseñaVinoElegante2_3 = new Resena(null,
                                "Un vino con cuerpo y una acidez perfecta, con notas especiadas muy agradables.",
                                new Date(), 4.4f,
                                true, vinoVinoElegante2);
                Resena reseñaVinoElegante2_4 = new Resena(null,
                                "Un vino muy agradable, aunque algo simple para los paladares más exigentes.",
                                new Date(), 4.2f, true,
                                vinoVinoElegante2);
                Resena reseñaVinoElegante2_5 = new Resena(null,
                                "Vino correcto, pero le falta algo de innovación en su perfil de sabor.", new Date(),
                                4.0f, false,
                                vinoVinoElegante2);

                Resena reseñaPedernalWines1_1 = new Resena(null,
                                "Excelente vino, con una gran combinación de frutas negras y un toque mineral.",
                                new Date(), 4.9f, true,
                                vinoPedernalWines1);
                Resena reseñaPedernalWines1_2 = new Resena(null,
                                "Vino de gran cuerpo y complejidad, ideal para maridar con carnes rojas.", new Date(),
                                4.7f, true,
                                vinoPedernalWines1);
                Resena reseñaPedernalWines1_3 = new Resena(null,
                                "Un vino robusto, pero bien equilibrado, con un final persistente.", new Date(), 4.5f,
                                true,
                                vinoPedernalWines1);
                Resena reseñaPedernalWines1_4 = new Resena(null,
                                "Agradable, aunque le falta algo de profundidad en su perfil de sabor.", new Date(),
                                4.3f, true,
                                vinoPedernalWines1);
                Resena reseñaPedernalWines1_5 = new Resena(null,
                                "Buen vino, pero no tan destacado como otros de la misma gama.", new Date(), 4.0f,
                                false,
                                vinoPedernalWines1);

                Resena reseñaPedernalWines2_1 = new Resena(null,
                                "Vino muy elegante, con notas de frutos rojos y un final persistente.", new Date(),
                                4.9f, true,
                                vinoPedernalWines2);
                Resena reseñaPedernalWines2_2 = new Resena(null,
                                "Ideal para acompañar platos gourmet, con un toque especiado que lo hace único.",
                                new Date(), 4.7f,
                                true, vinoPedernalWines2);
                Resena reseñaPedernalWines2_3 = new Resena(null,
                                "Vino con cuerpo, bien equilibrado, aunque podría tener un poco más de complejidad.",
                                new Date(), 4.5f,
                                true, vinoPedernalWines2);
                Resena reseñaPedernalWines2_4 = new Resena(null,
                                "Buen vino, pero no sobresale tanto como otros de la misma gama.", new Date(), 4.3f,
                                true,
                                vinoPedernalWines2);
                Resena reseñaPedernalWines2_5 = new Resena(null,
                                "Un vino bastante aceptable, pero le falta profundidad en sus aromas y sabores.",
                                new Date(), 4.0f,
                                false, vinoPedernalWines2);

                Resena reseñaGranPedernal1_1 = new Resena(null,
                                "Impresionante vino, con una mezcla perfecta de frutas negras y un toque mineral.",
                                new Date(), 4.9f,
                                true, vinoGranPedernal1);
                Resena reseñaGranPedernal1_2 = new Resena(null,
                                "De gran cuerpo y equilibrio, ideal para platos de caza o carnes rojas.", new Date(),
                                4.7f, true,
                                vinoGranPedernal1);
                Resena reseñaGranPedernal1_3 = new Resena(null,
                                "Un vino robusto y con taninos firmes, pero que se disfruta mucho.", new Date(), 4.5f,
                                true,
                                vinoGranPedernal1);
                Resena reseñaGranPedernal1_4 = new Resena(null,
                                "Agradable, aunque le falta algo de complejidad en sus notas.",
                                new Date(), 4.3f, true, vinoGranPedernal1);
                Resena reseñaGranPedernal1_5 = new Resena(null,
                                "Buen vino, pero no se destaca entre los mejores de su categoría.", new Date(), 4.0f,
                                false,
                                vinoGranPedernal1);

                Resena reseñaGranPedernal2_1 = new Resena(null,
                                "Vino potente, con un equilibrio ideal entre acidez y taninos, con toques de frutas maduras.",
                                new Date(), 4.8f, true, vinoGranPedernal2);
                Resena reseñaGranPedernal2_2 = new Resena(null, "Gran vino, con mucha estructura y un final elegante.",
                                new Date(), 4.6f, true, vinoGranPedernal2);
                Resena reseñaGranPedernal2_3 = new Resena(null,
                                "Vino con cuerpo y una mezcla de sabores que se complementan a la perfección.",
                                new Date(), 4.4f, true,
                                vinoGranPedernal2);
                Resena reseñaGranPedernal2_4 = new Resena(null,
                                "Un vino agradable, pero esperaba más complejidad en su perfil.", new Date(), 4.2f,
                                true,
                                vinoGranPedernal2);
                Resena reseñaGranPedernal2_5 = new Resena(null,
                                "Vino correcto, pero le falta algo de distinción para ser sobresaliente.", new Date(),
                                4.0f, false,
                                vinoGranPedernal2);

                Resena reseñaCalingasta1_1 = new Resena(null,
                                "Vino con un gran balance entre fruta y taninos, con una buena complejidad.",
                                new Date(), 4.8f, true,
                                vinoCalingasta1);
                Resena reseñaCalingasta1_2 = new Resena(null,
                                "Delicioso, con notas de frutos rojos y un toque especiado en el final.", new Date(),
                                4.6f, true,
                                vinoCalingasta1);
                Resena reseñaCalingasta1_3 = new Resena(null,
                                "Un vino bien estructurado, ideal para acompañar carnes y quesos curados.", new Date(),
                                4.4f, true,
                                vinoCalingasta1);
                Resena reseñaCalingasta1_4 = new Resena(null,
                                "Agradable pero sencillo, podría tener un poco más de cuerpo y complejidad.",
                                new Date(), 4.2f, true,
                                vinoCalingasta1);
                Resena reseñaCalingasta1_5 = new Resena(null,
                                "Buen vino, aunque no es tan memorable como otros de su categoría.", new Date(), 4.0f,
                                false,
                                vinoCalingasta1);

                Resena reseñaCalingasta2_1 = new Resena(null,
                                "Excelente vino, con un equilibrio perfecto entre fruta madura y taninos suaves.",
                                new Date(), 4.9f,
                                true, vinoCalingasta2);
                Resena reseñaCalingasta2_2 = new Resena(null,
                                "Vino con una estructura sólida, ideal para maridar con carnes rojas y asados.",
                                new Date(), 4.7f, true,
                                vinoCalingasta2);
                Resena reseñaCalingasta2_3 = new Resena(null,
                                "Agradable, con un final largo y especiado. Un vino con buen potencial de guarda.",
                                new Date(), 4.5f,
                                true, vinoCalingasta2);
                Resena reseñaCalingasta2_4 = new Resena(null,
                                "Un vino decente, aunque le falta algo de complejidad para destacarse.", new Date(),
                                4.3f, true,
                                vinoCalingasta2);
                Resena reseñaCalingasta2_5 = new Resena(null,
                                "Vino correcto, pero le falta algo de carácter para ser verdaderamente memorable.",
                                new Date(), 4.0f,
                                false, vinoCalingasta2);

                Resena reseñaVallesDeCalingasta1_1 = new Resena(null,
                                "Excelente vino con un balance perfecto entre fruta y taninos. Ideal para maridar con carnes.",
                                new Date(), 4.8f, true, vinoVallesDeCalingasta1);
                Resena reseñaVallesDeCalingasta1_2 = new Resena(null,
                                "Un vino bien estructurado con un final largo y especiado. Muy recomendado.",
                                new Date(), 4.6f, true,
                                vinoVallesDeCalingasta1);
                Resena reseñaVallesDeCalingasta1_3 = new Resena(null,
                                "Agradable y con una buena acidez. Perfecto para disfrutar en una comida.", new Date(),
                                4.4f, true,
                                vinoVallesDeCalingasta1);
                Resena reseñaVallesDeCalingasta1_4 = new Resena(null,
                                "Vino correcto, pero me faltó algo más de complejidad en sus aromas.", new Date(), 4.2f,
                                true,
                                vinoVallesDeCalingasta1);
                Resena reseñaVallesDeCalingasta1_5 = new Resena(null,
                                "Buen vino, pero no destaca tanto como otros de la misma gama.", new Date(), 4.0f,
                                false,
                                vinoVallesDeCalingasta1);

                Resena reseñaVallesDeCalingasta2_1 = new Resena(null,
                                "Vino con una excelente mezcla de taninos suaves y fruta madura. Muy recomendable.",
                                new Date(), 4.9f,
                                true, vinoVallesDeCalingasta2);
                Resena reseñaVallesDeCalingasta2_2 = new Resena(null,
                                "Buen cuerpo y una acidez bien equilibrada. Ideal para acompañar carnes.", new Date(),
                                4.7f, true,
                                vinoVallesDeCalingasta2);
                Resena reseñaVallesDeCalingasta2_3 = new Resena(null,
                                "Vino interesante, con un final largo y complejo.",
                                new Date(), 4.5f, true, vinoVallesDeCalingasta2);
                Resena reseñaVallesDeCalingasta2_4 = new Resena(null,
                                "Vino agradable, aunque me gustaría que tuviera más profundidad en los sabores.",
                                new Date(), 4.3f,
                                true, vinoVallesDeCalingasta2);
                Resena reseñaVallesDeCalingasta2_5 = new Resena(null,
                                "Vino correcto, pero no destaca mucho frente a otros de la misma región.", new Date(),
                                4.1f, false,
                                vinoVallesDeCalingasta2);

                Resena reseñaCopiapo1_1 = new Resena(null,
                                "Vino de gran cuerpo y estructura. Muy adecuado para carnes rojas.",
                                new Date(), 4.8f, true, vinoCopiapo1);
                Resena reseñaCopiapo1_2 = new Resena(null,
                                "Aromas complejos de frutas y especias. Un vino que mejora con el tiempo.", new Date(),
                                4.6f, true,
                                vinoCopiapo1);
                Resena reseñaCopiapo1_3 = new Resena(null,
                                "Buen vino, aunque le falta algo de suavidad en los taninos.",
                                new Date(), 4.4f, true, vinoCopiapo1);
                Resena reseñaCopiapo1_4 = new Resena(null,
                                "Agradable, pero no tiene el mismo impacto que otros vinos de la misma zona.",
                                new Date(), 4.2f, true,
                                vinoCopiapo1);
                Resena reseñaCopiapo1_5 = new Resena(null,
                                "Un vino decente, pero esperaba más en cuanto a complejidad y balance.", new Date(),
                                4.0f, false,
                                vinoCopiapo1);

                Resena reseñaCopiapo2_1 = new Resena(null,
                                "Vino potente y con taninos robustos, perfecto para acompañar carnes asadas.",
                                new Date(), 4.9f, true,
                                vinoCopiapo2);
                Resena reseñaCopiapo2_2 = new Resena(null,
                                "Excelente combinación de frutas y especias. Muy recomendable para ocasiones especiales.",
                                new Date(),
                                4.7f, true, vinoCopiapo2);
                Resena reseñaCopiapo2_3 = new Resena(null,
                                "Vino con cuerpo, pero me gustaría que tuviera un poco más de suavidad en el final.",
                                new Date(), 4.5f,
                                true, vinoCopiapo2);
                Resena reseñaCopiapo2_4 = new Resena(null, "Agradable, pero le falta algo de complejidad en su sabor.",
                                new Date(), 4.3f, true, vinoCopiapo2);
                Resena reseñaCopiapo2_5 = new Resena(null,
                                "Buen vino, pero no es tan memorable como otros de la misma región.",
                                new Date(), 4.0f, false, vinoCopiapo2);

                // Persistir 
                Resena reseñaHuasco1_1 = new Resena(null,
                                "Vino fresco, con un buen balance entre acidez y cuerpo. Perfecto para acompañar mariscos.",
                                new Date(),
                                4.8f, true, vinoHuasco1);
                Resena reseñaHuasco1_2 = new Resena(null,
                                "De buen cuerpo, con aromas cítricos y un final mineral muy agradable.", new Date(),
                                4.6f, true,
                                vinoHuasco1);
                Resena reseñaHuasco1_3 = new Resena(null,
                                "Un vino muy equilibrado, ideal para disfrutar en una tarde de verano.", new Date(),
                                4.4f, true,
                                vinoHuasco1);
                Resena reseñaHuasco1_4 = new Resena(null,
                                "Agradable pero algo ligero en sabor. Me faltó algo de complejidad.",
                                new Date(), 4.2f, true, vinoHuasco1);
                Resena reseñaHuasco1_5 = new Resena(null,
                                "Un vino decente, pero esperaba más intensidad en sus aromas.",
                                new Date(), 4.0f, false, vinoHuasco1);


                Resena reseñaHuasco2_1 = new Resena(null,
                                "Un vino refrescante, con un final mineral que lo hace único.",
                                new Date(), 4.9f, true, vinoHuasco2);
                Resena reseñaHuasco2_2 = new Resena(null,
                                "De cuerpo medio, con aromas frutales y un toque floral. Muy agradable.", new Date(),
                                4.7f, true,
                                vinoHuasco2);
                Resena reseñaHuasco2_3 = new Resena(null,
                                "Buen vino, aunque me gustaría que tuviera un poco más de complejidad.", new Date(),
                                4.5f, true,
                                vinoHuasco2);
                Resena reseñaHuasco2_4 = new Resena(null, "Agradable, pero no tiene el impacto que esperaba.",
                                new Date(), 4.3f,
                                true, vinoHuasco2);
                Resena reseñaHuasco2_5 = new Resena(null,
                                "Un vino correcto, pero no se destaca frente a otros de la misma gama.", new Date(),
                                4.0f, false,
                                vinoHuasco2);

                Resena reseñaItata1_1 = new Resena(null,
                                "Vino de gran frescura, ideal para acompañar platos ligeros como ensaladas y mariscos.",
                                new Date(),
                                4.8f, true, vinoItata1);
                Resena reseñaItata1_2 = new Resena(null,
                                "Un vino con una acidez vibrante y notas cítricas, perfecto para disfrutar en una tarde cálida.",
                                new Date(), 4.6f, true, vinoItata1);
                Resena reseñaItata1_3 = new Resena(null,
                                "Un excelente vino joven, con aromas florales y frutales que lo hacen muy atractivo.",
                                new Date(), 4.4f,
                                true, vinoItata1);
                Resena reseñaItata1_4 = new Resena(null,
                                "Buen vino, pero me gustaría que tuviera un poco más de cuerpo y complejidad.",
                                new Date(), 4.2f, true,
                                vinoItata1);
                Resena reseñaItata1_5 = new Resena(null,
                                "Agradable, pero no me sorprendió tanto como otros de la región.",
                                new Date(), 4.0f, false, vinoItata1);

                // Persistir 
                Resena reseñaItata2_1 = new Resena(null,
                                "Vino muy fresco con notas de frutas tropicales y un final mineral. Perfecto para maridar con pescados.",
                                new Date(), 4.9f, true, vinoItata2);
                Resena reseñaItata2_2 = new Resena(null,
                                "Aromas frescos y una acidez equilibrada. Un vino perfecto para disfrutar solo o con una comida ligera.",
                                new Date(), 4.7f, true, vinoItata2);
                Resena reseñaItata2_3 = new Resena(null,
                                "Vino agradable, pero me gustaría que tuviera más profundidad en el paladar.",
                                new Date(), 4.5f, true,
                                vinoItata2);
                Resena reseñaItata2_4 = new Resena(null,
                                "Un buen vino, aunque me gustaría que tuviera más estructura y cuerpo.", new Date(),
                                4.3f, true,
                                vinoItata2);
                Resena reseñaItata2_5 = new Resena(null,
                                "Vino correcto, pero no se destaca frente a otros de la misma gama.",
                                new Date(), 4.0f, false, vinoItata2);

                // Persistir 
                Resena reseñaMaule1_1 = new Resena(null,
                                "Vino robusto, con un excelente balance entre acidez y taninos. Ideal para carnes a la parrilla.",
                                new Date(), 4.8f, true, vinoMaule1);
                Resena reseñaMaule1_2 = new Resena(null,
                                "Aromas complejos de frutas rojas y especias, muy bien equilibrado. Un vino elegante.",
                                new Date(),
                                4.6f, true, vinoMaule1);
                Resena reseñaMaule1_3 = new Resena(null,
                                "Buen vino, aunque podría tener más cuerpo. Perfecto para una comida en familia.",
                                new Date(), 4.4f,
                                true, vinoMaule1);
                Resena reseñaMaule1_4 = new Resena(null,
                                "Agradable pero un poco plano en el paladar. Le falta algo de complejidad.", new Date(),
                                4.2f, true,
                                vinoMaule1);
                Resena reseñaMaule1_5 = new Resena(null,
                                "Vino sencillo, no tan memorable. Cumple su función pero no sorprende.", new Date(),
                                4.0f, false,
                                vinoMaule1);

                Resena reseñaMaule2_1 = new Resena(null,
                                "Un vino con una excelente mezcla de frutas y especias. Perfecto para una noche con amigos.",
                                new Date(), 4.9f, true, vinoMaule2);
                Resena reseñaMaule2_2 = new Resena(null,
                                "Vino estructurado con taninos firmes y un final largo. Ideal para acompañar platos intensos.",
                                new Date(), 4.7f, true, vinoMaule2);
                Resena reseñaMaule2_3 = new Resena(null,
                                "Buen vino, aunque la acidez podría estar un poco más equilibrada. Aún así, recomendable.",
                                new Date(),
                                4.5f, true, vinoMaule2);
                Resena reseñaMaule2_4 = new Resena(null,
                                "Vino correcto, pero no tiene tanto impacto como esperaba. Le falta algo de complejidad.",
                                new Date(),
                                4.3f, true, vinoMaule2);
                Resena reseñaMaule2_5 = new Resena(null,
                                "Vino decente, pero no es tan memorable como otros de la misma gama.",
                                new Date(), 4.0f, false, vinoMaule2);

                // Persistir 
                Resena reseñaCasablanca1_1 = new Resena(null,
                                "Excelente vino blanco, con una acidez brillante y notas de frutas cítricas, ideal para mariscos.",
                                new Date(), 4.8f, true, vinoCasablanca1);
                Resena reseñaCasablanca1_2 = new Resena(null,
                                "Fresco, con aromas de hierba recién cortada y frutas tropicales. Perfecto para una tarde cálida.",
                                new Date(), 4.6f, true, vinoCasablanca1);
                Resena reseñaCasablanca1_3 = new Resena(null,
                                "Vino ligero y fácil de beber, aunque le falta algo de cuerpo y complejidad.",
                                new Date(), 4.4f, true,
                                vinoCasablanca1);
                Resena reseñaCasablanca1_4 = new Resena(null,
                                "Buen vino, pero me gustaría que tuviera un poco más de estructura y sabor.",
                                new Date(), 4.2f, true,
                                vinoCasablanca1);
                Resena reseñaCasablanca1_5 = new Resena(null,
                                "Vino agradable pero algo simple en el paladar. No se destaca demasiado.", new Date(),
                                4.0f, false,
                                vinoCasablanca1);

                Resena reseñaCasablanca2_1 = new Resena(null,
                                "Un vino excelente con una acidez perfecta y un toque floral que lo hace muy refrescante.",
                                new Date(),
                                4.9f, true, vinoCasablanca2);
                Resena reseñaCasablanca2_2 = new Resena(null,
                                "Aromas de frutas frescas y un sabor suave pero intenso. Perfecto para acompañar pescados y mariscos.",
                                new Date(), 4.7f, true, vinoCasablanca2);
                Resena reseñaCasablanca2_3 = new Resena(null,
                                "Vino bien equilibrado, pero algo simple en el final. Aún así, recomendable para una comida ligera.",
                                new Date(), 4.5f, true, vinoCasablanca2);
                Resena reseñaCasablanca2_4 = new Resena(null,
                                "Vino agradable, pero me faltó un poco más de complejidad en el sabor. Buen vino para ocasiones casuales.",
                                new Date(), 4.3f, true, vinoCasablanca2);
                Resena reseñaCasablanca2_5 = new Resena(null,
                                "Un vino correcto, pero no me sorprendió tanto como esperaba. No tiene tanta personalidad.",
                                new Date(),
                                4.0f, false, vinoCasablanca2);

                Resena reseñaSanAntonio1_1 = new Resena(null,
                                "Vino de gran estructura con taninos firmes, ideal para acompañar carnes a la parrilla.",
                                new Date(),
                                4.8f, true, vinoSanAntonio1);
                Resena reseñaSanAntonio1_2 = new Resena(null,
                                "Frutal y con un toque de especias, un vino con gran potencial de guarda.", new Date(),
                                4.6f, true,
                                vinoSanAntonio1);
                Resena reseñaSanAntonio1_3 = new Resena(null,
                                "Vino con mucho cuerpo, pero algo fuerte para mi gusto. Le faltó un poco de suavidad en el final.",
                                new Date(), 4.4f, true, vinoSanAntonio1);
                Resena reseñaSanAntonio1_4 = new Resena(null,
                                "Buen vino, aunque los taninos son un poco secos. Necesita tiempo para desarrollarse completamente.",
                                new Date(), 4.2f, true, vinoSanAntonio1);
                Resena reseñaSanAntonio1_5 = new Resena(null,
                                "Agradable pero no tan memorable. Es un vino decente, pero podría mejorar.", new Date(),
                                4.0f, false,
                                vinoSanAntonio1);

                Resena reseñaSanAntonio2_1 = new Resena(null,
                                "Vino potente con un toque de especias y frutos negros. Ideal para acompañar un buen filete.",
                                new Date(), 4.9f, true, vinoSanAntonio2);
                Resena reseñaSanAntonio2_2 = new Resena(null,
                                "Muy bien equilibrado con un final largo. Perfecto para una comida más elaborada.",
                                new Date(), 4.7f,
                                true, vinoSanAntonio2);
                Resena reseñaSanAntonio2_3 = new Resena(null,
                                "Un vino con mucha personalidad y un toque a madera muy bien integrado.", new Date(),
                                4.5f, true,
                                vinoSanAntonio2);
                Resena reseñaSanAntonio2_4 = new Resena(null,
                                "Aromas intensos, pero el sabor es algo fuerte y puede no ser del gusto de todos. Aun así, muy bueno.",
                                new Date(), 4.3f, true, vinoSanAntonio2);
                Resena reseñaSanAntonio2_5 = new Resena(null,
                                "Vino bien hecho, pero no me terminó de convencer. No me sorprendió tanto como esperaba.",
                                new Date(),
                                4.0f, false, vinoSanAntonio2);

                Resena reseñaValeDosVinhedos1_1 = new Resena(null,
                                "Vino con gran cuerpo, estructura sólida y taninos presentes. Ideal para carnes rojas.",
                                new Date(),
                                4.8f, true, vinoValeDosVinhedos1);
                Resena reseñaValeDosVinhedos1_2 = new Resena(null,
                                "Un vino elegante, con toques de frutos rojos y un final largo. Perfecto para platos intensos.",
                                new Date(), 4.6f, true, vinoValeDosVinhedos1);
                Resena reseñaValeDosVinhedos1_3 = new Resena(null,
                                "Vino bien balanceado, pero me gustaría que tuviera un poco más de acidez para hacer más fresco el final.",
                                new Date(), 4.4f, true, vinoValeDosVinhedos1);
                Resena reseñaValeDosVinhedos1_4 = new Resena(null,
                                "Vino potente y robusto, ideal para un buen asado, pero no tiene tanta complejidad en el sabor.",
                                new Date(), 4.2f, true, vinoValeDosVinhedos1);
                Resena reseñaValeDosVinhedos1_5 = new Resena(null,
                                "Buen vino, pero no es tan destacado frente a otros de la misma región.", new Date(),
                                4.0f, false,
                                vinoValeDosVinhedos1);

                Resena reseñaValeDosVinhedos2_1 = new Resena(null,
                                "Vino bien estructurado con sabores a frutos rojos maduros y un toque de especias. Excelente acompañante para carnes.",
                                new Date(), 4.9f, true, vinoValeDosVinhedos2);
                Resena reseñaValeDosVinhedos2_2 = new Resena(null,
                                "Gran equilibrio entre taninos y acidez, con un final elegante. Muy recomendable para cenas formales.",
                                new Date(), 4.7f, true, vinoValeDosVinhedos2);
                Resena reseñaValeDosVinhedos2_3 = new Resena(null,
                                "Vino con cuerpo, pero me gustaría que tuviera más complejidad en el bouquet. Buen vino pero no sobresale.",
                                new Date(), 4.5f, true, vinoValeDosVinhedos2);
                Resena reseñaValeDosVinhedos2_4 = new Resena(null,
                                "Aromas intensos de frutos negros y madera. Perfecto para carnes a la parrilla, aunque podría ser más suave.",
                                new Date(), 4.3f, true, vinoValeDosVinhedos2);
                Resena reseñaValeDosVinhedos2_5 = new Resena(null,
                                "Agradable, pero le falta profundidad y algo de frescura. Recomendable para aquellos que buscan un vino fácil de beber.",
                                new Date(), 4.0f, false, vinoValeDosVinhedos2);


                Resena reseñaSerraGaucha1_1 = new Resena(null,
                                "Vino intenso con aromas a frutos negros y especias. Ideal para carnes a la parrilla.",
                                new Date(),
                                4.8f, true, vinoSerraGaucha1);
                Resena reseñaSerraGaucha1_2 = new Resena(null,
                                "Un vino robusto con gran estructura, pero algo fuerte en el paladar. Aún así, muy bien logrado.",
                                new Date(), 4.6f, true, vinoSerraGaucha1);
                Resena reseñaSerraGaucha1_3 = new Resena(null,
                                "Buen equilibrio, aunque le falta algo de frescura para hacer más ligero el final. Buen acompañante para comidas pesadas.",
                                new Date(), 4.4f, true, vinoSerraGaucha1);
                Resena reseñaSerraGaucha1_4 = new Resena(null,
                                "Vino con cuerpo y buen potencial de guarda, pero me gustaría que fuera más redondo en su sabor.",
                                new Date(), 4.2f, true, vinoSerraGaucha1);
                Resena reseñaSerraGaucha1_5 = new Resena(null,
                                "Vino demasiado pesado para mi gusto. Me gustaría que tuviera un perfil más suave y accesible.",
                                new Date(), 4.0f, false, vinoSerraGaucha1);


                Resena reseñaSerraGaucha2_1 = new Resena(null,
                                "Vino elegante con una acidez equilibrada y una textura suave. Ideal para acompañar aves y pescados.",
                                new Date(), 4.9f, true, vinoSerraGaucha2);
                Resena reseñaSerraGaucha2_2 = new Resena(null,
                                "Fresco y afrutado, con un toque mineral que lo hace interesante. Muy recomendable para un almuerzo ligero.",
                                new Date(), 4.7f, true, vinoSerraGaucha2);
                Resena reseñaSerraGaucha2_3 = new Resena(null,
                                "Vino con una buena acidez, pero me gustaría que tuviera más cuerpo y complejidad en el final.",
                                new Date(), 4.5f, true, vinoSerraGaucha2);
                Resena reseñaSerraGaucha2_4 = new Resena(null,
                                "Buen vino, pero no es tan complejo. Ideal para una comida informal, aunque no es tan memorable.",
                                new Date(), 4.3f, true, vinoSerraGaucha2);
                Resena reseñaSerraGaucha2_5 = new Resena(null,
                                "Vino correcto pero muy simple, no destaca frente a otros vinos de la región.",
                                new Date(), 4.0f, false,
                                vinoSerraGaucha2);

                Resena reseñaCamposDeCima1_1 = new Resena(null,
                                "Vino delicado y equilibrado, con una acidez refrescante y sabores a frutas rojas maduras.",
                                new Date(),
                                4.8f, true, vinoCamposDeCima1);
                Resena reseñaCamposDeCima1_2 = new Resena(null,
                                "Fresco y ligero, ideal para una tarde cálida. Los aromas florales le dan un toque especial.",
                                new Date(), 4.6f, true, vinoCamposDeCima1);
                Resena reseñaCamposDeCima1_3 = new Resena(null,
                                "A pesar de ser ligero, tiene una gran profundidad de sabor. Perfecto para acompañar ensaladas y platos sencillos.",
                                new Date(), 4.4f, true, vinoCamposDeCima1);
                Resena reseñaCamposDeCima1_4 = new Resena(null,
                                "Vino suave, pero algo monótono en su sabor. No me sorprendió tanto como esperaba.",
                                new Date(), 4.2f,
                                true, vinoCamposDeCima1);
                Resena reseñaCamposDeCima1_5 = new Resena(null,
                                "Un vino correcto pero sin mucho carácter. Ideal para aquellos que prefieren vinos más suaves.",
                                new Date(), 4.0f, false, vinoCamposDeCima1);

                // Persistir 
                Resena reseñaCamposDeCima2_1 = new Resena(null,
                                "Excelente vino, con una mezcla perfecta de frescura y complejidad. Ideal para maridar con pescado y mariscos.",
                                new Date(), 4.9f, true, vinoCamposDeCima2);
                Resena reseñaCamposDeCima2_2 = new Resena(null,
                                "Gran equilibrio entre fruta y acidez. El final es largo y agradable. Muy recomendable.",
                                new Date(),
                                4.7f, true, vinoCamposDeCima2);
                Resena reseñaCamposDeCima2_3 = new Resena(null,
                                "Un vino bien logrado, aunque me gustaría que tuviera un poco más de estructura en el cuerpo. Aún así, agradable.",
                                new Date(), 4.5f, true, vinoCamposDeCima2);
                Resena reseñaCamposDeCima2_4 = new Resena(null,
                                "Vino sencillo pero bien ejecutado. Ideal para una comida ligera o una tarde de verano.",
                                new Date(),
                                4.3f, true, vinoCamposDeCima2);
                Resena reseñaCamposDeCima2_5 = new Resena(null,
                                "No me convenció completamente. Aunque es fresco, le falta algo de complejidad en el sabor.",
                                new Date(), 4.0f, false, vinoCamposDeCima2);

                // Persistir 
                Resena reseñaCanelonesRegion1_1 = new Resena(null,
                                "Un vino con una excelente combinación de taninos suaves y un toque afrutado. Perfecto para carnes rojas a la parrilla.",
                                new Date(), 4.8f, true, vinoCanelonesRegion1);
                Resena reseñaCanelonesRegion1_2 = new Resena(null,
                                "Muy equilibrado, con notas de frutos rojos y un final seco. Ideal para maridar con pasta y salsas a base de tomate.",
                                new Date(), 4.6f, true, vinoCanelonesRegion1);
                Resena reseñaCanelonesRegion1_3 = new Resena(null,
                                "Buen cuerpo, aunque le falta algo de complejidad en el paladar. Aún así, es agradable y fácil de beber.",
                                new Date(), 4.2f, true, vinoCanelonesRegion1);
                Resena reseñaCanelonesRegion1_4 = new Resena(null,
                                "Vino sencillo, pero muy bien hecho. Es un vino joven que se disfruta en una ocasión informal.",
                                new Date(), 4.3f, true, vinoCanelonesRegion1);
                Resena reseñaCanelonesRegion1_5 = new Resena(null,
                                "No es mi favorito. La acidez es un poco pronunciada y el sabor se siente algo plano.",
                                new Date(), 3.9f, false, vinoCanelonesRegion1);


                Resena reseñaCanelonesRegion2_1 = new Resena(null,
                                "Excelente vino, con una combinación de frutas rojas y un toque de roble. Ideal para acompañar un buen filete.",
                                new Date(), 4.7f, true, vinoCanelonesRegion2);
                Resena reseñaCanelonesRegion2_2 = new Resena(null,
                                "El vino tiene un cuerpo robusto y bien equilibrado. Acompañado con quesos fuertes, es una experiencia deliciosa.",
                                new Date(), 4.6f, true, vinoCanelonesRegion2);
                Resena reseñaCanelonesRegion2_3 = new Resena(null,
                                "Buen vino, aunque esperaba algo más de profundidad. Ideal para una cena tranquila, pero no sorprende.",
                                new Date(), 4.3f, true, vinoCanelonesRegion2);
                Resena reseñaCanelonesRegion2_4 = new Resena(null,
                                "Un vino agradable, con una textura suave y un final que invita a seguir bebiendo. Me gustó mucho.",
                                new Date(), 4.5f, true, vinoCanelonesRegion2);
                Resena reseñaCanelonesRegion2_5 = new Resena(null,
                                "No es un mal vino, pero no me convenció del todo. Algo de complejidad en los sabores sería genial.",
                                new Date(), 3.8f, false, vinoCanelonesRegion2);


                Resena reseñaMontevideoRegion1_1 = new Resena(null,
                                "Un vino refrescante, con un perfil frutal que recuerda a las fresas. Perfecto para acompañar platos ligeros.",
                                new Date(), 4.4f, true, vinoMontevideoRegion1);
                Resena reseñaMontevideoRegion1_2 = new Resena(null,
                                "Tiene un buen equilibrio entre acidez y dulzura, aunque el final podría ser más largo.",
                                new Date(), 4.2f, true, vinoMontevideoRegion1);
                Resena reseñaMontevideoRegion1_3 = new Resena(null,
                                "Vino ligero, fácil de beber, pero carece de la complejidad que esperaba. Ideal para una tarde de verano.",
                                new Date(), 4.0f, true, vinoMontevideoRegion1);
                Resena reseñaMontevideoRegion1_4 = new Resena(null,
                                "Agradable, pero con un toque un tanto plano. Faltó un poco de personalidad en el sabor.",
                                new Date(), 3.9f, true, vinoMontevideoRegion1);
                Resena reseñaMontevideoRegion1_5 = new Resena(null,
                                "Me gustó, pero esperaba un poco más de intensidad en los sabores. Aún así, es un vino adecuado.",
                                new Date(), 4.1f, true, vinoMontevideoRegion1);


                Resena reseñaMontevideoRegion2_1 = new Resena(null,
                                "Excelente vino de la región, con un sabor intenso y afrutado. Ideal para maridar con carnes al horno.",
                                new Date(), 4.8f, true, vinoMontevideoRegion2);
                Resena reseñaMontevideoRegion2_2 = new Resena(null,
                                "Vino con mucha personalidad. Sus notas especiadas lo hacen ideal para acompañar platos fuertes.",
                                new Date(), 4.7f, true, vinoMontevideoRegion2);
                Resena reseñaMontevideoRegion2_3 = new Resena(null,
                                "Bien equilibrado, con un final largo y suave. Es una excelente opción para acompañar quesos maduros.",
                                new Date(), 4.5f, true, vinoMontevideoRegion2);
                Resena reseñaMontevideoRegion2_4 = new Resena(null,
                                "El vino es bueno, pero le falta algo de complejidad. Es agradable, pero no memorable.",
                                new Date(), 4.2f, true, vinoMontevideoRegion2);
                Resena reseñaMontevideoRegion2_5 = new Resena(null,
                                "No es de mis favoritos. La acidez es algo alta y el sabor es poco definido.",
                                new Date(), 3.8f, false, vinoMontevideoRegion2);


                Resena reseñaIcaRegion1_1 = new Resena(null,
                                "Vino con mucho carácter, ideal para acompañar comidas fuertes como asados o platos con especias.",
                                new Date(), 4.7f, true, vinoIcaRegion1);
                Resena reseñaIcaRegion1_2 = new Resena(null,
                                "Tienen una mezcla interesante de sabores que hacen que cada sorbo sea diferente. Agradable, pero no sobresale.",
                                new Date(), 4.4f, true, vinoIcaRegion1);
                Resena reseñaIcaRegion1_3 = new Resena(null,
                                "El vino tiene un buen cuerpo, pero la acidez podría estar más equilibrada. No es malo, pero no es espectacular.",
                                new Date(), 4.1f, true, vinoIcaRegion1);
                Resena reseñaIcaRegion1_4 = new Resena(null,
                                "Buen vino para disfrutar con amigos. Tiene un toque afrutado que lo hace fresco y fácil de beber.",
                                new Date(), 4.3f, true, vinoIcaRegion1);
                Resena reseñaIcaRegion1_5 = new Resena(null,
                                "No es de mis preferidos. Le falta algo de profundidad en los sabores y tiene un toque demasiado ácido.",
                                new Date(), 3.8f, false, vinoIcaRegion1);


                Resena reseñaIcaRegion2_1 = new Resena(null,
                                "Un vino de excelente cuerpo, con una acidez perfectamente equilibrada. Ideal para acompañar carnes especiadas.",
                                new Date(), 4.8f, true, vinoIcaRegion2);
                Resena reseñaIcaRegion2_2 = new Resena(null,
                                "Muy bien equilibrado, con notas de frutos rojos y un toque de especias. Me gusta su final largo y suave.",
                                new Date(), 4.7f, true, vinoIcaRegion2);
                Resena reseñaIcaRegion2_3 = new Resena(null,
                                "Buen vino, con una textura suave y sabores bien definidos. No es excepcional, pero tiene un buen balance.",
                                new Date(), 4.5f, true, vinoIcaRegion2);
                Resena reseñaIcaRegion2_4 = new Resena(null,
                                "Agradable, pero le falta un poco de complejidad. Es fresco y fácil de beber, pero no memorable.",
                                new Date(), 4.2f, true, vinoIcaRegion2);
                Resena reseñaIcaRegion2_5 = new Resena(null,
                                "Un vino bastante básico. No destaca por su sabor, pero es decente para una ocasión casual.",
                                new Date(), 3.9f, false, vinoIcaRegion2);


                Resena reseñaCuscoRegion1_1 = new Resena(null,
                                "Este vino tiene una excelente estructura, con un final largo y afrutado. Ideal para acompañar platos de cordero.",
                                new Date(), 4.9f, true, vinoCuscoRegion1);
                Resena reseñaCuscoRegion1_2 = new Resena(null,
                                "Un vino robusto y con mucha personalidad. Sus notas a frutos negros lo hacen perfecto para carnes a la parrilla.",
                                new Date(), 4.8f, true, vinoCuscoRegion1);
                Resena reseñaCuscoRegion1_3 = new Resena(null,
                                "Bien equilibrado, pero no tan destacado como esperaba. Es agradable, aunque le falta algo de complejidad.",
                                new Date(), 4.4f, true, vinoCuscoRegion1);
                Resena reseñaCuscoRegion1_4 = new Resena(null,
                                "Agradable pero un poco plano en el final. Buen vino, aunque no tiene la intensidad que busco.",
                                new Date(), 4.2f, true, vinoCuscoRegion1);
                Resena reseñaCuscoRegion1_5 = new Resena(null,
                                "Es un vino decente, pero no me convenció por completo. Le falta un poco de cuerpo y profundidad.",
                                new Date(), 3.9f, false, vinoCuscoRegion1);


                Resena reseñaCuscoRegion2_1 = new Resena(null,
                                "Vino con mucho carácter, perfecto para acompañar platos de pasta con salsas intensas.",
                                new Date(), 4.6f, true, vinoCuscoRegion2);
                Resena reseñaCuscoRegion2_2 = new Resena(null,
                                "Este vino tiene un perfil afrutado muy agradable, con un toque de especias que lo hace interesante.",
                                new Date(), 4.5f, true, vinoCuscoRegion2);
                Resena reseñaCuscoRegion2_3 = new Resena(null,
                                "Un vino suave, con un toque dulce y un final corto. Ideal para maridar con quesos frescos.",
                                new Date(), 4.3f, true, vinoCuscoRegion2);
                Resena reseñaCuscoRegion2_4 = new Resena(null,
                                "Buen vino, pero no tan memorable. Tiene un toque de frescura, pero me gustaría un poco más de cuerpo.",
                                new Date(), 4.1f, true, vinoCuscoRegion2);
                Resena reseñaCuscoRegion2_5 = new Resena(null,
                                "Es un vino simple, pero bien logrado. No destaca, pero es agradable para una ocasión relajada.",
                                new Date(), 3.8f, false, vinoCuscoRegion2);


                Resena reseñaValleCalchaqui1_1 = new Resena(null,
                                "Este vino tiene una excelente complejidad de sabores, con una acidez bien balanceada. Ideal para carnes a la parrilla.",
                                new Date(), 4.8f, true, vinoValleCalchaqui1);
                Resena reseñaValleCalchaqui1_2 = new Resena(null,
                                "Buen vino, con toques de frutos rojos y un final persistente. Acompañó muy bien una cena de carne de res.",
                                new Date(), 4.7f, true, vinoValleCalchaqui1);
                Resena reseñaValleCalchaqui1_3 = new Resena(null,
                                "Muy bien equilibrado, aunque me gustaría un poco más de cuerpo. Aún así, es una excelente opción.",
                                new Date(), 4.5f, true, vinoValleCalchaqui1);
                Resena reseñaValleCalchaqui1_4 = new Resena(null,
                                "Un vino agradable, con un toque afrutado que lo hace refrescante. Perfecto para una comida ligera.",
                                new Date(), 4.2f, true, vinoValleCalchaqui1);
                Resena reseñaValleCalchaqui1_5 = new Resena(null,
                                "El vino es bueno, pero me dejó con ganas de más complejidad. Aún así, es bastante decente.",
                                new Date(), 4.0f, false, vinoValleCalchaqui1);


                Resena reseñaValleCalchaqui2_1 = new Resena(null,
                                "Un vino redondo, con sabores a frutos secos y un toque especiado que lo hace muy interesante.",
                                new Date(), 4.7f, true, vinoValleCalchaqui2);
                Resena reseñaValleCalchaqui2_2 = new Resena(null,
                                "Me sorprendió positivamente. Tiene una acidez bien equilibrada y un final suave, ideal para maridar con pescados.",
                                new Date(), 4.6f, true, vinoValleCalchaqui2);
                Resena reseñaValleCalchaqui2_3 = new Resena(null,
                                "Buen vino, con notas a frutas maduras. Aunque el final es algo corto, sigue siendo una buena elección.",
                                new Date(), 4.3f, true, vinoValleCalchaqui2);
                Resena reseñaValleCalchaqui2_4 = new Resena(null,
                                "Un vino suave y fresco, pero le falta un poco de estructura en el cuerpo. Agradable pero no sobresaliente.",
                                new Date(), 4.1f, true, vinoValleCalchaqui2);
                Resena reseñaValleCalchaqui2_5 = new Resena(null,
                                "Es un vino que cumple su función, pero no tiene la complejidad ni la personalidad que busco en un vino.",
                                new Date(), 3.9f, false, vinoValleCalchaqui2);


                Resena reseñaCafayate1_1 = new Resena(null,
                                "Un vino de gran cuerpo, con sabores intensos de frutos rojos y un final largo. Perfecto para acompañar carnes asadas.",
                                new Date(), 4.9f, true, vinoCafayate1);
                Resena reseñaCafayate1_2 = new Resena(null,
                                "Este vino tiene una excelente estructura y balance. Ideal para maridar con platos de cordero o carnes fuertes.",
                                new Date(), 4.8f, true, vinoCafayate1);
                Resena reseñaCafayate1_3 = new Resena(null,
                                "Un vino redondo y bien equilibrado, con notas de frutos negros y un toque de especias. Muy bueno.",
                                new Date(), 4.6f, true, vinoCafayate1);
                Resena reseñaCafayate1_4 = new Resena(null,
                                "Agradable, aunque me gustaría un poco más de complejidad en el sabor. Es un vino decente para una comida informal.",
                                new Date(), 4.3f, true, vinoCafayate1);
                Resena reseñaCafayate1_5 = new Resena(null,
                                "Es un vino con buen sabor, pero le falta algo de profundidad y complejidad. No está mal, pero esperaba más.",
                                new Date(), 4.0f, false, vinoCafayate1);


                Resena reseñaCafayate2_1 = new Resena(null,
                                "Un vino con gran intensidad de sabor, con notas de frutos rojos y especias. Ideal para acompañar carnes a la parrilla.",
                                new Date(), 4.8f, true, vinoCafayate2);
                Resena reseñaCafayate2_2 = new Resena(null,
                                "Excelente vino, bien estructurado, con un final largo y agradable. Perfecto para una comida con amigos.",
                                new Date(), 4.7f, true, vinoCafayate2);
                Resena reseñaCafayate2_3 = new Resena(null,
                                "Buen vino, pero le falta algo de complejidad en el sabor. Es suave y fácil de beber, pero no tan memorable.",
                                new Date(), 4.4f, true, vinoCafayate2);
                Resena reseñaCafayate2_4 = new Resena(null,
                                "Es un vino decente, aunque no destaca entre otros. Es muy fácil de beber, pero me falta un poco de intensidad.",
                                new Date(), 4.2f, true, vinoCafayate2);
                Resena reseñaCafayate2_5 = new Resena(null,
                                "No es de mis favoritos. Es bastante simple y le falta profundidad. Agradable, pero no excepcional.",
                                new Date(), 3.9f, false, vinoCafayate2);


                Resena reseñaQuebradaDeHumahuaca1_1 = new Resena(null,
                                "Un vino con un sabor potente y afrutado, con taninos bien marcados. Perfecto para acompañar carne de res.",
                                new Date(), 4.9f, true, vinoQuebradaDeHumahuaca1);
                Resena reseñaQuebradaDeHumahuaca1_2 = new Resena(null,
                                "Este vino tiene un sabor profundo y elegante, con un toque de especias. Ideal para acompañar platos de caza.",
                                new Date(), 4.8f, true, vinoQuebradaDeHumahuaca1);
                Resena reseñaQuebradaDeHumahuaca1_3 = new Resena(null,
                                "Un vino con mucho carácter, bien estructurado y con un final largo. Me gusta cómo se complementa con los platos de carnes asadas.",
                                new Date(), 4.6f, true, vinoQuebradaDeHumahuaca1);
                Resena reseñaQuebradaDeHumahuaca1_4 = new Resena(null,
                                "Es un vino robusto, aunque el sabor es un poco menos complejo de lo que esperaba. Aún así, es bastante bueno.",
                                new Date(), 4.4f, true, vinoQuebradaDeHumahuaca1);
                Resena reseñaQuebradaDeHumahuaca1_5 = new Resena(null,
                                "Buen vino, aunque no tiene la complejidad que busco. Es agradable, pero le falta algo de profundidad.",
                                new Date(), 4.1f, false, vinoQuebradaDeHumahuaca1);


                Resena reseñaQuebradaDeHumahuaca2_1 = new Resena(null,
                                "Un vino intenso, con sabores a frutos maduros y un toque especiado que lo hace muy interesante.",
                                new Date(), 4.7f, true, vinoQuebradaDeHumahuaca2);
                Resena reseñaQuebradaDeHumahuaca2_2 = new Resena(null,
                                "Excelente vino, con una acidez bien equilibrada y un final largo. Ideal para acompañar platos de carnes rojas.",
                                new Date(), 4.6f, true, vinoQuebradaDeHumahuaca2);
                Resena reseñaQuebradaDeHumahuaca2_3 = new Resena(null,
                                "Un vino con una buena estructura, aunque me gustaría un poco más de frescura. Aun así, es una opción sólida.",
                                new Date(), 4.4f, true, vinoQuebradaDeHumahuaca2);
                Resena reseñaQuebradaDeHumahuaca2_4 = new Resena(null,
                                "Buen vino, con un toque afrutado, pero le falta algo de complejidad en el final. Es decente, pero no sobresale.",
                                new Date(), 4.2f, true, vinoQuebradaDeHumahuaca2);
                Resena reseñaQuebradaDeHumahuaca2_5 = new Resena(null,
                                "Es un vino aceptable, pero no tiene la intensidad que busco. Agradable, pero no me convenció por completo.",
                                new Date(), 3.9f, false, vinoQuebradaDeHumahuaca2);

                resenaRepository.save(reseñaBioBioRegion1_1);
                resenaRepository.save(reseñaBioBioRegion1_2);
                resenaRepository.save(reseñaBioBioRegion1_3);
                resenaRepository.save(reseñaBioBioRegion1_4);
                resenaRepository.save(reseñaBioBioRegion1_5);
                resenaRepository.save(reseñaBioBioRegion2_1);
                resenaRepository.save(reseñaBioBioRegion2_2);
                resenaRepository.save(reseñaBioBioRegion2_3);
                resenaRepository.save(reseñaBioBioRegion2_4);
                resenaRepository.save(reseñaBioBioRegion2_5);
                resenaRepository.save(reseñaSanPedro1_1);
                resenaRepository.save(reseñaSanPedro1_2);
                resenaRepository.save(reseñaSanPedro1_3);
                resenaRepository.save(reseñaSanPedro1_4);
                resenaRepository.save(reseñaSanPedro1_5);
                resenaRepository.save(reseñaSanPedro2_1);
                resenaRepository.save(reseñaSanPedro2_2);
                resenaRepository.save(reseñaSanPedro2_3);
                resenaRepository.save(reseñaSanPedro2_4);
                resenaRepository.save(reseñaSanPedro2_5);
                resenaRepository.save(reseñaArtigas1_2);
                resenaRepository.save(reseñaArtigas1_3);
                resenaRepository.save(reseñaArtigas1_4);
                resenaRepository.save(reseñaArtigas1_5);
                resenaRepository.save(reseñaArtigas2_1);
                resenaRepository.save(reseñaArtigas2_2);
                resenaRepository.save(reseñaArtigas2_3);
                resenaRepository.save(reseñaArtigas2_4);
                resenaRepository.save(reseñaArtigas2_5);
                resenaRepository.save(reseñaCerroLargo1_1);
                resenaRepository.save(reseñaCerroLargo1_2);
                resenaRepository.save(reseñaCerroLargo1_3);
                resenaRepository.save(reseñaCerroLargo1_4);
                resenaRepository.save(reseñaCerroLargo1_5);
                resenaRepository.save(reseñaCerroLargo2_1);
                resenaRepository.save(reseñaCerroLargo2_2);
                resenaRepository.save(reseñaCerroLargo2_3);
                resenaRepository.save(reseñaCerroLargo2_4);
                resenaRepository.save(reseñaCerroLargo2_5);
                resenaRepository.save(reseñaRivera1_1);
                resenaRepository.save(reseñaRivera1_2);
                resenaRepository.save(reseñaRivera1_3);
                resenaRepository.save(reseñaRivera1_4);
                resenaRepository.save(reseñaRivera1_5);
                resenaRepository.save(reseñaChincha1_1);
                resenaRepository.save(reseñaChincha1_2);
                resenaRepository.save(reseñaChincha1_3);
                resenaRepository.save(reseñaChincha1_4);
                resenaRepository.save(reseñaChincha1_5);
                resenaRepository.save(reseñaChincha2_1);
                resenaRepository.save(reseñaChincha2_2);
                resenaRepository.save(reseñaChincha2_3);
                resenaRepository.save(reseñaChincha2_4);
                resenaRepository.save(reseñaChincha2_5);
                resenaRepository.save(reseñaNazca1_1);
                resenaRepository.save(reseñaNazca1_2);
                resenaRepository.save(reseñaNazca1_3);
                resenaRepository.save(reseñaNazca1_4);
                resenaRepository.save(reseñaNazca1_5);
                resenaRepository.save(reseñaNazca2_1);
                resenaRepository.save(reseñaNazca2_2);
                resenaRepository.save(reseñaNazca2_3);
                resenaRepository.save(reseñaNazca2_4);
                resenaRepository.save(reseñaNazca2_5);
                resenaRepository.save(reseñaLimaValley1_1);
                resenaRepository.save(reseñaLimaValley1_2);
                resenaRepository.save(reseñaLimaValley1_3);
                resenaRepository.save(reseñaLimaValley1_4);
                resenaRepository.save(reseñaLimaValley1_5);
                resenaRepository.save(reseñaLimaValley2_1);
                resenaRepository.save(reseñaLimaValley2_2);
                resenaRepository.save(reseñaLimaValley2_3);
                resenaRepository.save(reseñaLimaValley2_4);
                resenaRepository.save(reseñaLimaValley2_5);
                resenaRepository.save(reseñaTulumVineyards1_1);
                resenaRepository.save(reseñaTulumVineyards1_2);
                resenaRepository.save(reseñaTulumVineyards1_3);
                resenaRepository.save(reseñaTulumVineyards1_4);
                resenaRepository.save(reseñaTulumVineyards1_5);
                resenaRepository.save(reseñaTulumVineyards2_1);
                resenaRepository.save(reseñaTulumVineyards2_2);
                resenaRepository.save(reseñaTulumVineyards2_3);
                resenaRepository.save(reseñaTulumVineyards2_4);
                resenaRepository.save(reseñaTulumVineyards2_5);
                resenaRepository.save(reseñaSanJuanVino1_1);
                resenaRepository.save(reseñaSanJuanVino1_2);
                resenaRepository.save(reseñaSanJuanVino1_3);
                resenaRepository.save(reseñaSanJuanVino1_4);
                resenaRepository.save(reseñaSanJuanVino1_5);
                resenaRepository.save(reseñaSanJuanVino2_1);
                resenaRepository.save(reseñaSanJuanVino2_2);
                resenaRepository.save(reseñaSanJuanVino2_3);
                resenaRepository.save(reseñaSanJuanVino2_4);
                resenaRepository.save(reseñaSanJuanVino2_5);
                resenaRepository.save(reseñaZondaVineyards1_1);
                resenaRepository.save(reseñaZondaVineyards1_2);
                resenaRepository.save(reseñaZondaVineyards1_3);
                resenaRepository.save(reseñaZondaVineyards1_4);
                resenaRepository.save(reseñaZondaVineyards1_5);
                resenaRepository.save(reseñaZondaVineyards2_1);
                resenaRepository.save(reseñaZondaVineyards2_2);
                resenaRepository.save(reseñaZondaVineyards2_3);
                resenaRepository.save(reseñaZondaVineyards2_4);
                resenaRepository.save(reseñaZondaVineyards2_5);
                resenaRepository.save(reseñaVinoElegante1_1);
                resenaRepository.save(reseñaVinoElegante1_2);
                resenaRepository.save(reseñaVinoElegante1_3);
                resenaRepository.save(reseñaVinoElegante1_4);
                resenaRepository.save(reseñaVinoElegante1_5);
                resenaRepository.save(reseñaVinoElegante2_1);
                resenaRepository.save(reseñaVinoElegante2_2);
                resenaRepository.save(reseñaVinoElegante2_3);
                resenaRepository.save(reseñaVinoElegante2_4);
                resenaRepository.save(reseñaVinoElegante2_5);
                resenaRepository.save(reseñaPedernalWines1_1);
                resenaRepository.save(reseñaPedernalWines1_2);
                resenaRepository.save(reseñaPedernalWines1_3);
                resenaRepository.save(reseñaPedernalWines1_4);
                resenaRepository.save(reseñaPedernalWines1_5);
                resenaRepository.save(reseñaPedernalWines2_1);
                resenaRepository.save(reseñaPedernalWines2_2);
                resenaRepository.save(reseñaPedernalWines2_3);
                resenaRepository.save(reseñaPedernalWines2_4);
                resenaRepository.save(reseñaPedernalWines2_5);
                resenaRepository.save(reseñaGranPedernal1_1);
                resenaRepository.save(reseñaGranPedernal1_2);
                resenaRepository.save(reseñaGranPedernal1_3);
                resenaRepository.save(reseñaGranPedernal1_4);
                resenaRepository.save(reseñaGranPedernal1_5);
                resenaRepository.save(reseñaGranPedernal2_1);
                resenaRepository.save(reseñaGranPedernal2_2);
                resenaRepository.save(reseñaGranPedernal2_3);
                resenaRepository.save(reseñaGranPedernal2_4);
                resenaRepository.save(reseñaGranPedernal2_5);
                resenaRepository.save(reseñaCalingasta1_1);
                resenaRepository.save(reseñaCalingasta1_2);
                resenaRepository.save(reseñaCalingasta1_3);
                resenaRepository.save(reseñaCalingasta1_4);
                resenaRepository.save(reseñaCalingasta1_5);
                resenaRepository.save(reseñaCalingasta2_1);
                resenaRepository.save(reseñaCalingasta2_2);
                resenaRepository.save(reseñaCalingasta2_3);
                resenaRepository.save(reseñaCalingasta2_4);
                resenaRepository.save(reseñaCalingasta2_5);
                resenaRepository.save(reseñaVallesDeCalingasta1_1);
                resenaRepository.save(reseñaVallesDeCalingasta1_2);
                resenaRepository.save(reseñaVallesDeCalingasta1_3);
                resenaRepository.save(reseñaVallesDeCalingasta1_4);
                resenaRepository.save(reseñaVallesDeCalingasta1_5);
                resenaRepository.save(reseñaVallesDeCalingasta2_1);
                resenaRepository.save(reseñaVallesDeCalingasta2_2);
                resenaRepository.save(reseñaVallesDeCalingasta2_3);
                resenaRepository.save(reseñaVallesDeCalingasta2_4);
                resenaRepository.save(reseñaVallesDeCalingasta2_5);
                resenaRepository.save(reseñaCopiapo1_1);
                resenaRepository.save(reseñaCopiapo1_2);
                resenaRepository.save(reseñaCopiapo1_3);
                resenaRepository.save(reseñaCopiapo1_4);
                resenaRepository.save(reseñaCopiapo1_5);
                resenaRepository.save(reseñaCopiapo2_1);
                resenaRepository.save(reseñaCopiapo2_2);
                resenaRepository.save(reseñaCopiapo2_3);
                resenaRepository.save(reseñaCopiapo2_4);
                resenaRepository.save(reseñaCopiapo2_5);
                resenaRepository.save(reseñaHuasco1_1);
                resenaRepository.save(reseñaHuasco1_2);
                resenaRepository.save(reseñaHuasco1_3);
                resenaRepository.save(reseñaHuasco1_4);
                resenaRepository.save(reseñaHuasco1_5);
                resenaRepository.save(reseñaHuasco2_1);
                resenaRepository.save(reseñaHuasco2_2);
                resenaRepository.save(reseñaHuasco2_3);
                resenaRepository.save(reseñaHuasco2_4);
                resenaRepository.save(reseñaHuasco2_5);
                resenaRepository.save(reseñaItata1_1);
                resenaRepository.save(reseñaItata1_2);
                resenaRepository.save(reseñaItata1_3);
                resenaRepository.save(reseñaItata1_4);
                resenaRepository.save(reseñaItata1_5);
                resenaRepository.save(reseñaItata2_1);
                resenaRepository.save(reseñaItata2_2);
                resenaRepository.save(reseñaItata2_3);
                resenaRepository.save(reseñaItata2_4);
                resenaRepository.save(reseñaItata2_5);
                resenaRepository.save(reseñaMaule1_1);
                resenaRepository.save(reseñaMaule1_2);
                resenaRepository.save(reseñaMaule1_3);
                resenaRepository.save(reseñaMaule1_4);
                resenaRepository.save(reseñaMaule1_5);
                resenaRepository.save(reseñaMaule2_1);
                resenaRepository.save(reseñaMaule2_2);
                resenaRepository.save(reseñaMaule2_3);
                resenaRepository.save(reseñaMaule2_4);
                resenaRepository.save(reseñaMaule2_5);
                resenaRepository.save(reseñaCasablanca1_1);
                resenaRepository.save(reseñaCasablanca1_2);
                resenaRepository.save(reseñaCasablanca1_3);
                resenaRepository.save(reseñaCasablanca1_4);
                resenaRepository.save(reseñaCasablanca1_5);
                resenaRepository.save(reseñaCasablanca2_1);
                resenaRepository.save(reseñaCasablanca2_2);
                resenaRepository.save(reseñaCasablanca2_3);
                resenaRepository.save(reseñaCasablanca2_4);
                resenaRepository.save(reseñaCasablanca2_5);
                resenaRepository.save(reseñaSanAntonio1_1);
                resenaRepository.save(reseñaSanAntonio1_2);
                resenaRepository.save(reseñaSanAntonio1_3);
                resenaRepository.save(reseñaSanAntonio1_4);
                resenaRepository.save(reseñaSanAntonio1_5);
                resenaRepository.save(reseñaSanAntonio2_1);
                resenaRepository.save(reseñaSanAntonio2_2);
                resenaRepository.save(reseñaSanAntonio2_3);
                resenaRepository.save(reseñaSanAntonio2_4);
                resenaRepository.save(reseñaSanAntonio2_5);
                resenaRepository.save(reseñaValeDosVinhedos1_1);
                resenaRepository.save(reseñaValeDosVinhedos1_2);
                resenaRepository.save(reseñaValeDosVinhedos1_3);
                resenaRepository.save(reseñaValeDosVinhedos1_4);
                resenaRepository.save(reseñaValeDosVinhedos1_5);
                resenaRepository.save(reseñaValeDosVinhedos2_1);
                resenaRepository.save(reseñaValeDosVinhedos2_2);
                resenaRepository.save(reseñaValeDosVinhedos2_3);
                resenaRepository.save(reseñaValeDosVinhedos2_4);
                resenaRepository.save(reseñaValeDosVinhedos2_5);
                resenaRepository.save(reseñaSerraGaucha1_1);
                resenaRepository.save(reseñaSerraGaucha1_2);
                resenaRepository.save(reseñaSerraGaucha1_3);
                resenaRepository.save(reseñaSerraGaucha1_4);
                resenaRepository.save(reseñaSerraGaucha1_5);
                resenaRepository.save(reseñaSerraGaucha2_1);
                resenaRepository.save(reseñaSerraGaucha2_2);
                resenaRepository.save(reseñaSerraGaucha2_3);
                resenaRepository.save(reseñaSerraGaucha2_4);
                resenaRepository.save(reseñaSerraGaucha2_5);
                resenaRepository.save(reseñaCamposDeCima1_1);
                resenaRepository.save(reseñaCamposDeCima1_2);
                resenaRepository.save(reseñaCamposDeCima1_3);
                resenaRepository.save(reseñaCamposDeCima1_4);
                resenaRepository.save(reseñaCamposDeCima1_5);
                resenaRepository.save(reseñaCamposDeCima2_1);
                resenaRepository.save(reseñaCamposDeCima2_2);
                resenaRepository.save(reseñaCamposDeCima2_3);
                resenaRepository.save(reseñaCamposDeCima2_4);
                resenaRepository.save(reseñaCamposDeCima2_5);
                resenaRepository.save(reseñaCanelonesRegion1_1);
                resenaRepository.save(reseñaCanelonesRegion1_2);
                resenaRepository.save(reseñaCanelonesRegion1_3);
                resenaRepository.save(reseñaCanelonesRegion1_4);
                resenaRepository.save(reseñaCanelonesRegion1_5);
                resenaRepository.save(reseñaCanelonesRegion2_1);
                resenaRepository.save(reseñaCanelonesRegion2_2);
                resenaRepository.save(reseñaCanelonesRegion2_3);
                resenaRepository.save(reseñaCanelonesRegion2_4);
                resenaRepository.save(reseñaCanelonesRegion2_5);
                resenaRepository.save(reseñaMontevideoRegion1_1);
                resenaRepository.save(reseñaMontevideoRegion1_2);
                resenaRepository.save(reseñaMontevideoRegion1_3);
                resenaRepository.save(reseñaMontevideoRegion1_4);
                resenaRepository.save(reseñaMontevideoRegion1_5);
                resenaRepository.save(reseñaMontevideoRegion2_1);
                resenaRepository.save(reseñaMontevideoRegion2_2);
                resenaRepository.save(reseñaMontevideoRegion2_3);
                resenaRepository.save(reseñaMontevideoRegion2_4);
                resenaRepository.save(reseñaMontevideoRegion2_5);
                resenaRepository.save(reseñaIcaRegion1_1);
                resenaRepository.save(reseñaIcaRegion1_2);
                resenaRepository.save(reseñaIcaRegion1_3);
                resenaRepository.save(reseñaIcaRegion1_4);
                resenaRepository.save(reseñaIcaRegion1_5);
                resenaRepository.save(reseñaIcaRegion2_1);
                resenaRepository.save(reseñaIcaRegion2_2);
                resenaRepository.save(reseñaIcaRegion2_3);
                resenaRepository.save(reseñaIcaRegion2_4);
                resenaRepository.save(reseñaIcaRegion2_5);
                resenaRepository.save(reseñaCuscoRegion1_1);
                resenaRepository.save(reseñaCuscoRegion1_2);
                resenaRepository.save(reseñaCuscoRegion1_3);
                resenaRepository.save(reseñaCuscoRegion1_4);
                resenaRepository.save(reseñaCuscoRegion1_5);
                resenaRepository.save(reseñaCuscoRegion2_1);
                resenaRepository.save(reseñaCuscoRegion2_2);
                resenaRepository.save(reseñaCuscoRegion2_3);
                resenaRepository.save(reseñaCuscoRegion2_4);
                resenaRepository.save(reseñaCuscoRegion2_5);
                resenaRepository.save(reseñaValleCalchaqui1_1);
                resenaRepository.save(reseñaValleCalchaqui1_2);
                resenaRepository.save(reseñaValleCalchaqui1_3);
                resenaRepository.save(reseñaValleCalchaqui1_4);
                resenaRepository.save(reseñaValleCalchaqui1_5);
                resenaRepository.save(reseñaValleCalchaqui2_1);
                resenaRepository.save(reseñaValleCalchaqui2_2);
                resenaRepository.save(reseñaValleCalchaqui2_3);
                resenaRepository.save(reseñaValleCalchaqui2_4);
                resenaRepository.save(reseñaValleCalchaqui2_5);
                resenaRepository.save(reseñaCafayate1_1);
                resenaRepository.save(reseñaCafayate1_2);
                resenaRepository.save(reseñaCafayate1_3);
                resenaRepository.save(reseñaCafayate1_4);
                resenaRepository.save(reseñaCafayate1_5);
                resenaRepository.save(reseñaCafayate2_1);
                resenaRepository.save(reseñaCafayate2_2);
                resenaRepository.save(reseñaCafayate2_3);
                resenaRepository.save(reseñaCafayate2_4);
                resenaRepository.save(reseñaCafayate2_5);
                resenaRepository.save(reseñaQuebradaDeHumahuaca1_1);
                resenaRepository.save(reseñaQuebradaDeHumahuaca1_2);
                resenaRepository.save(reseñaQuebradaDeHumahuaca1_3);
                resenaRepository.save(reseñaQuebradaDeHumahuaca1_4);
                resenaRepository.save(reseñaQuebradaDeHumahuaca1_5);
                resenaRepository.save(reseñaQuebradaDeHumahuaca2_1);
                resenaRepository.save(reseñaQuebradaDeHumahuaca2_2);
                resenaRepository.save(reseñaQuebradaDeHumahuaca2_3);
                resenaRepository.save(reseñaQuebradaDeHumahuaca2_4);
                resenaRepository.save(reseñaQuebradaDeHumahuaca2_5);


                // Asignar reseñas a Vino BioBioRegion1
                vinoBioBioRegion1.setResenas(
                                Arrays.asList(reseñaBioBioRegion1_1, reseñaBioBioRegion1_2, reseñaBioBioRegion1_3,
                                                reseñaBioBioRegion1_4, reseñaBioBioRegion1_5));

                // Asignar reseñas a Vino BioBioRegion2
                vinoBioBioRegion2.setResenas(
                                Arrays.asList(reseñaBioBioRegion2_1, reseñaBioBioRegion2_2, reseñaBioBioRegion2_3,
                                                reseñaBioBioRegion2_4, reseñaBioBioRegion2_5));
                // Asignar reseñas a Vino SanPedro1
                vinoSanPedro1.setResenas(Arrays.asList(reseñaSanPedro1_1, reseñaSanPedro1_2, reseñaSanPedro1_3,
                                reseñaSanPedro1_4, reseñaSanPedro1_5));


                // Asignar reseñas a Vino SanPedro2
                vinoSanPedro2.setResenas(Arrays.asList(reseñaSanPedro2_1, reseñaSanPedro2_2, reseñaSanPedro2_3,
                                reseñaSanPedro2_4, reseñaSanPedro2_5));

               


                // Asignar reseñas a Vino Artigas2
                vinoArtigas2.setResenas(
                                Arrays.asList(reseñaArtigas2_1, reseñaArtigas2_2, reseñaArtigas2_3, reseñaArtigas2_4,
                                                reseñaArtigas2_5));

               

                // Asignar reseñas a Vino CerroLargo1
                vinoCerroLargo1.setResenas(Arrays.asList(reseñaCerroLargo1_1, reseñaCerroLargo1_2, reseñaCerroLargo1_3,
                                reseñaCerroLargo1_4, reseñaCerroLargo1_5));


                // Asignar reseñas a Vino CerroLargo2
                vinoCerroLargo2.setResenas(Arrays.asList(reseñaCerroLargo2_1, reseñaCerroLargo2_2, reseñaCerroLargo2_3,
                                reseñaCerroLargo2_4, reseñaCerroLargo2_5));

               

                // Asignar reseñas a Vino Rivera1
                vinoRivera1.setResenas(Arrays.asList(reseñaRivera1_1, reseñaRivera1_2, reseñaRivera1_3, reseñaRivera1_4,
                                reseñaRivera1_5));


                // Asignar reseñas a Vino Chincha1
                vinoChincha1.setResenas(
                                Arrays.asList(reseñaChincha1_1, reseñaChincha1_2, reseñaChincha1_3, reseñaChincha1_4,
                                                reseñaChincha1_5));


                // Asignar reseñas a Vino Chincha2
                vinoChincha2.setResenas(
                                Arrays.asList(reseñaChincha2_1, reseñaChincha2_2, reseñaChincha2_3, reseñaChincha2_4,
                                                reseñaChincha2_5));


                // Asignar reseñas a Vino Nazca1
                vinoNazca1.setResenas(Arrays.asList(reseñaNazca1_1, reseñaNazca1_2, reseñaNazca1_3, reseñaNazca1_4,
                                reseñaNazca1_5));

               

                // Asignar reseñas a Vino Nazca2
                vinoNazca2.setResenas(Arrays.asList(reseñaNazca2_1, reseñaNazca2_2, reseñaNazca2_3, reseñaNazca2_4,
                                reseñaNazca2_5));


                // Asignar reseñas a Vino LimaValley1
                vinoLimaValley1.setResenas(Arrays.asList(reseñaLimaValley1_1, reseñaLimaValley1_2, reseñaLimaValley1_3,
                                reseñaLimaValley1_4, reseñaLimaValley1_5));

               

                // Asignar reseñas a Vino LimaValley2
                vinoLimaValley2.setResenas(Arrays.asList(reseñaLimaValley2_1, reseñaLimaValley2_2, reseñaLimaValley2_3,
                                reseñaLimaValley2_4, reseñaLimaValley2_5));


                // Asignar reseñas a Vino TulumVineyards1
                vinoTulumVineyards1.setResenas(Arrays.asList(reseñaTulumVineyards1_1, reseñaTulumVineyards1_2,
                                reseñaTulumVineyards1_3, reseñaTulumVineyards1_4, reseñaTulumVineyards1_5));

               

                // Asignar reseñas a Vino TulumVineyards2
                vinoTulumVineyards2.setResenas(Arrays.asList(reseñaTulumVineyards2_1, reseñaTulumVineyards2_2,
                                reseñaTulumVineyards2_3, reseñaTulumVineyards2_4, reseñaTulumVineyards2_5));


                // Asignar reseñas a Vino SanJuanVino1
                vinoSanJuanVino1.setResenas(
                                Arrays.asList(reseñaSanJuanVino1_1, reseñaSanJuanVino1_2, reseñaSanJuanVino1_3,
                                                reseñaSanJuanVino1_4, reseñaSanJuanVino1_5));


                // Asignar reseñas a Vino SanJuanVino2
                vinoSanJuanVino2.setResenas(
                                Arrays.asList(reseñaSanJuanVino2_1, reseñaSanJuanVino2_2, reseñaSanJuanVino2_3,
                                                reseñaSanJuanVino2_4, reseñaSanJuanVino2_5));


                // Asignar reseñas a Vino ZondaVineyards1
                vinoZondaVineyards1.setResenas(Arrays.asList(reseñaZondaVineyards1_1, reseñaZondaVineyards1_2,
                                reseñaZondaVineyards1_3, reseñaZondaVineyards1_4, reseñaZondaVineyards1_5));

               

                // Asignar reseñas a Vino ZondaVineyards2
                vinoZondaVineyards2.setResenas(Arrays.asList(reseñaZondaVineyards2_1, reseñaZondaVineyards2_2,
                                reseñaZondaVineyards2_3, reseñaZondaVineyards2_4, reseñaZondaVineyards2_5));

               

                // Asignar reseñas a Vino VinoElegante1
                vinoVinoElegante1.setResenas(
                                Arrays.asList(reseñaVinoElegante1_1, reseñaVinoElegante1_2, reseñaVinoElegante1_3,
                                                reseñaVinoElegante1_4, reseñaVinoElegante1_5));

               

                // Asignar reseñas a Vino VinoElegante2
                vinoVinoElegante2.setResenas(
                                Arrays.asList(reseñaVinoElegante2_1, reseñaVinoElegante2_2, reseñaVinoElegante2_3,
                                                reseñaVinoElegante2_4, reseñaVinoElegante2_5));

               

                // Asignar reseñas a Vino PedernalWines1
                vinoPedernalWines1.setResenas(Arrays.asList(reseñaPedernalWines1_1, reseñaPedernalWines1_2,
                                reseñaPedernalWines1_3, reseñaPedernalWines1_4, reseñaPedernalWines1_5));

                // 7
               

                // Asignar reseñas a Vino PedernalWines2
                vinoPedernalWines2.setResenas(Arrays.asList(reseñaPedernalWines2_1, reseñaPedernalWines2_2,
                                reseñaPedernalWines2_3, reseñaPedernalWines2_4, reseñaPedernalWines2_5));

               

                // Asignar reseñas a Vino GranPedernal1
                vinoGranPedernal1.setResenas(
                                Arrays.asList(reseñaGranPedernal1_1, reseñaGranPedernal1_2, reseñaGranPedernal1_3,
                                                reseñaGranPedernal1_4, reseñaGranPedernal1_5));

               

                // Asignar reseñas a Vino GranPedernal2
                vinoGranPedernal2.setResenas(
                                Arrays.asList(reseñaGranPedernal2_1, reseñaGranPedernal2_2, reseñaGranPedernal2_3,
                                                reseñaGranPedernal2_4, reseñaGranPedernal2_5));

               

                // Asignar reseñas a Vino Calingasta1
                vinoCalingasta1.setResenas(Arrays.asList(reseñaCalingasta1_1, reseñaCalingasta1_2, reseñaCalingasta1_3,
                                reseñaCalingasta1_4, reseñaCalingasta1_5));

               

                // Asignar reseñas a Vino Calingasta2
                vinoCalingasta2.setResenas(Arrays.asList(reseñaCalingasta2_1, reseñaCalingasta2_2, reseñaCalingasta2_3,
                                reseñaCalingasta2_4, reseñaCalingasta2_5));

                // 7
               

                // Asignar reseñas a Vino VallesDeCalingasta1
                vinoVallesDeCalingasta1
                                .setResenas(Arrays.asList(reseñaVallesDeCalingasta1_1, reseñaVallesDeCalingasta1_2,
                                                reseñaVallesDeCalingasta1_3, reseñaVallesDeCalingasta1_4,
                                                reseñaVallesDeCalingasta1_5));

               

                // Asignar reseñas a Vino VallesDeCalingasta2
                vinoVallesDeCalingasta2
                                .setResenas(Arrays.asList(reseñaVallesDeCalingasta2_1, reseñaVallesDeCalingasta2_2,
                                                reseñaVallesDeCalingasta2_3, reseñaVallesDeCalingasta2_4,
                                                reseñaVallesDeCalingasta2_5));

               

                // Asignar reseñas a Vino Copiapo1
                vinoCopiapo1.setResenas(
                                Arrays.asList(reseñaCopiapo1_1, reseñaCopiapo1_2, reseñaCopiapo1_3, reseñaCopiapo1_4,
                                                reseñaCopiapo1_5));


                // Asignar reseñas a Vino Copiapo2
                vinoCopiapo2.setResenas(
                                Arrays.asList(reseñaCopiapo2_1, reseñaCopiapo2_2, reseñaCopiapo2_3, reseñaCopiapo2_4,
                                                reseñaCopiapo2_5));


                // Asignar reseñas a Vino Huasco1
                vinoHuasco1.setResenas(Arrays.asList(reseñaHuasco1_1, reseñaHuasco1_2, reseñaHuasco1_3, reseñaHuasco1_4,
                                reseñaHuasco1_5));

               

                // Asignar reseñas a Vino Huasco2
                vinoHuasco2.setResenas(Arrays.asList(reseñaHuasco2_1, reseñaHuasco2_2, reseñaHuasco2_3, reseñaHuasco2_4,
                                reseñaHuasco2_5));

                // 8

                // Asignar reseñas a Vino Itata1
                vinoItata1.setResenas(Arrays.asList(reseñaItata1_1, reseñaItata1_2, reseñaItata1_3, reseñaItata1_4,
                                reseñaItata1_5));


                // Asignar reseñas a Vino Itata2
                vinoItata2.setResenas(Arrays.asList(reseñaItata2_1, reseñaItata2_2, reseñaItata2_3, reseñaItata2_4,
                                reseñaItata2_5));

               

                // Asignar reseñas a Vino Maule1
                vinoMaule1.setResenas(Arrays.asList(reseñaMaule1_1, reseñaMaule1_2, reseñaMaule1_3, reseñaMaule1_4,
                                reseñaMaule1_5));


                // Asignar reseñas a Vino Maule2
                vinoMaule2.setResenas(Arrays.asList(reseñaMaule2_1, reseñaMaule2_2, reseñaMaule2_3, reseñaMaule2_4,
                                reseñaMaule2_5));

                // 9
               

                // Asignar reseñas a Vino Casablanca1
                vinoCasablanca1.setResenas(Arrays.asList(reseñaCasablanca1_1, reseñaCasablanca1_2, reseñaCasablanca1_3,
                                reseñaCasablanca1_4, reseñaCasablanca1_5));

               

                // Asignar reseñas a Vino Casablanca2
                vinoCasablanca2.setResenas(Arrays.asList(reseñaCasablanca2_1, reseñaCasablanca2_2, reseñaCasablanca2_3,
                                reseñaCasablanca2_4, reseñaCasablanca2_5));

               

                // Asignar reseñas a Vino SanAntonio1
                vinoSanAntonio1.setResenas(Arrays.asList(reseñaSanAntonio1_1, reseñaSanAntonio1_2, reseñaSanAntonio1_3,
                                reseñaSanAntonio1_4, reseñaSanAntonio1_5));

               

                // Asignar reseñas a Vino SanAntonio2
                vinoSanAntonio2.setResenas(Arrays.asList(reseñaSanAntonio2_1, reseñaSanAntonio2_2, reseñaSanAntonio2_3,
                                reseñaSanAntonio2_4, reseñaSanAntonio2_5));

               

                // Asignar reseñas a Vino ValeDosVinhedos1
                vinoValeDosVinhedos1.setResenas(Arrays.asList(reseñaValeDosVinhedos1_1, reseñaValeDosVinhedos1_2,
                                reseñaValeDosVinhedos1_3, reseñaValeDosVinhedos1_4, reseñaValeDosVinhedos1_5));

                // 10

                // Asignar reseñas a Vino ValeDosVinhedos2
                vinoValeDosVinhedos2.setResenas(Arrays.asList(reseñaValeDosVinhedos2_1, reseñaValeDosVinhedos2_2,
                                reseñaValeDosVinhedos2_3, reseñaValeDosVinhedos2_4, reseñaValeDosVinhedos2_5));


                // Asignar reseñas a Vino SerraGaucha1
                vinoSerraGaucha1.setResenas(
                                Arrays.asList(reseñaSerraGaucha1_1, reseñaSerraGaucha1_2, reseñaSerraGaucha1_3,
                                                reseñaSerraGaucha1_4, reseñaSerraGaucha1_5));

               

                // Asignar reseñas a Vino SerraGaucha2
                vinoSerraGaucha2.setResenas(
                                Arrays.asList(reseñaSerraGaucha2_1, reseñaSerraGaucha2_2, reseñaSerraGaucha2_3,
                                                reseñaSerraGaucha2_4, reseñaSerraGaucha2_5));


                // Asignar reseñas a Vino CamposDeCima1
                vinoCamposDeCima1.setResenas(
                                Arrays.asList(reseñaCamposDeCima1_1, reseñaCamposDeCima1_2, reseñaCamposDeCima1_3,
                                                reseñaCamposDeCima1_4, reseñaCamposDeCima1_5));


                // Asignar reseñas a Vino CamposDeCima2
                vinoCamposDeCima2.setResenas(
                                Arrays.asList(reseñaCamposDeCima2_1, reseñaCamposDeCima2_2, reseñaCamposDeCima2_3,
                                                reseñaCamposDeCima2_4, reseñaCamposDeCima2_5));


                // Asignar reseñas a Vino CanelonesRegion1
                vinoCanelonesRegion1.setResenas(Arrays.asList(reseñaCanelonesRegion1_1, reseñaCanelonesRegion1_2,
                                reseñaCanelonesRegion1_3,
                                reseñaCanelonesRegion1_4, reseñaCanelonesRegion1_5));


                // Asignar reseñas a Vino CanelonesRegion2
                vinoCanelonesRegion2.setResenas(Arrays.asList(reseñaCanelonesRegion2_1, reseñaCanelonesRegion2_2,
                                reseñaCanelonesRegion2_3, reseñaCanelonesRegion2_4, reseñaCanelonesRegion2_5));


                // Asignar reseñas a Vino MontevideoRegion1
                vinoMontevideoRegion1.setResenas(Arrays.asList(reseñaMontevideoRegion1_1, reseñaMontevideoRegion1_2,
                                reseñaMontevideoRegion1_3, reseñaMontevideoRegion1_4, reseñaMontevideoRegion1_5));


                // Asignar reseñas a Vino MontevideoRegion2
                vinoMontevideoRegion2.setResenas(Arrays.asList(reseñaMontevideoRegion2_1, reseñaMontevideoRegion2_2,
                                reseñaMontevideoRegion2_3, reseñaMontevideoRegion2_4, reseñaMontevideoRegion2_5));


                // Asignar reseñas a Vino IcaRegion1
                vinoIcaRegion1.setResenas(Arrays.asList(reseñaIcaRegion1_1, reseñaIcaRegion1_2, reseñaIcaRegion1_3,
                                reseñaIcaRegion1_4, reseñaIcaRegion1_5));


                // Asignar reseñas a Vino IcaRegion2
                vinoIcaRegion2.setResenas(Arrays.asList(reseñaIcaRegion2_1, reseñaIcaRegion2_2, reseñaIcaRegion2_3,
                                reseñaIcaRegion2_4, reseñaIcaRegion2_5));


                // Asignar reseñas a Vino CuscoRegion1
                vinoCuscoRegion1.setResenas(Arrays.asList(reseñaCuscoRegion1_1, reseñaCuscoRegion1_2,
                                reseñaCuscoRegion1_3, reseñaCuscoRegion1_4, reseñaCuscoRegion1_5));


                // Asignar reseñas a Vino CuscoRegion2
                vinoCuscoRegion2.setResenas(Arrays.asList(reseñaCuscoRegion2_1, reseñaCuscoRegion2_2,
                                reseñaCuscoRegion2_3, reseñaCuscoRegion2_4, reseñaCuscoRegion2_5));


                // Asignar reseñas a Vino ValleCalchaqui1
                vinoValleCalchaqui1.setResenas(Arrays.asList(reseñaValleCalchaqui1_1, reseñaValleCalchaqui1_2,
                                reseñaValleCalchaqui1_3, reseñaValleCalchaqui1_4, reseñaValleCalchaqui1_5));

                // Asignar reseñas a Vino ValleCalchaqui2
                vinoValleCalchaqui2.setResenas(Arrays.asList(reseñaValleCalchaqui2_1, reseñaValleCalchaqui2_2,
                                reseñaValleCalchaqui2_3, reseñaValleCalchaqui2_4, reseñaValleCalchaqui2_5));

                // Asignar reseñas a Vino Cafayate1
                vinoCafayate1.setResenas(Arrays.asList(reseñaCafayate1_1, reseñaCafayate1_2, reseñaCafayate1_3,
                                reseñaCafayate1_4, reseñaCafayate1_5));


                // Asignar reseñas a Vino Cafayate2
                vinoCafayate2.setResenas(Arrays.asList(reseñaCafayate2_1, reseñaCafayate2_2, reseñaCafayate2_3,
                                reseñaCafayate2_4, reseñaCafayate2_5));


                // Asignar reseñas a Vino QuebradaDeHumahuaca1
                vinoQuebradaDeHumahuaca1.setResenas(Arrays.asList(reseñaQuebradaDeHumahuaca1_1,
                                reseñaQuebradaDeHumahuaca1_2, reseñaQuebradaDeHumahuaca1_3,
                                reseñaQuebradaDeHumahuaca1_4, reseñaQuebradaDeHumahuaca1_5));


                // Asignar reseñas a Vino QuebradaDeHumahuaca2
                vinoQuebradaDeHumahuaca2.setResenas(Arrays.asList(reseñaQuebradaDeHumahuaca2_1,
                                reseñaQuebradaDeHumahuaca2_2, reseñaQuebradaDeHumahuaca2_3,
                                reseñaQuebradaDeHumahuaca2_4, reseñaQuebradaDeHumahuaca2_5));
                
                
        
                vinoRepository.save(vinoBioBioRegion1);
                vinoRepository.save(vinoBioBioRegion2);
                vinoRepository.save(vinoSanPedro1);
                vinoRepository.save(vinoSanPedro2);
                vinoRepository.save(vinoArtigas2);
                vinoRepository.save(vinoCerroLargo1);
                vinoRepository.save(vinoCerroLargo2);
                vinoRepository.save(vinoRivera1);
                vinoRepository.save(vinoChincha1);
                vinoRepository.save(vinoChincha2);
                vinoRepository.save(vinoNazca1);
                vinoRepository.save(vinoNazca2);
                vinoRepository.save(vinoLimaValley1);
                vinoRepository.save(vinoLimaValley2);
                vinoRepository.save(vinoTulumVineyards1);
                vinoRepository.save(vinoTulumVineyards2);
                vinoRepository.save(vinoSanJuanVino1);
                vinoRepository.save(vinoSanJuanVino2);
                vinoRepository.save(vinoZondaVineyards1);
                vinoRepository.save(vinoZondaVineyards2);
                vinoRepository.save(vinoVinoElegante1);
                vinoRepository.save(vinoVinoElegante2);
                vinoRepository.save(vinoPedernalWines1);
                vinoRepository.save(vinoPedernalWines2);
                vinoRepository.save(vinoGranPedernal1);
                vinoRepository.save(vinoGranPedernal2);
                vinoRepository.save(vinoCalingasta1);
                vinoRepository.save(vinoCalingasta2);
                vinoRepository.save(vinoVallesDeCalingasta1);
                vinoRepository.save(vinoVallesDeCalingasta2);
                vinoRepository.save(vinoCopiapo1);
                vinoRepository.save(vinoCopiapo2);
                vinoRepository.save(vinoHuasco1);
                vinoRepository.save(vinoHuasco2);
                vinoRepository.save(vinoItata1);
                vinoRepository.save(vinoItata2);
                vinoRepository.save(vinoMaule1);
                vinoRepository.save(vinoMaule2);
                vinoRepository.save(vinoCasablanca1);
                vinoRepository.save(vinoCasablanca2);
                vinoRepository.save(vinoSanAntonio1);
                vinoRepository.save(vinoSanAntonio2);
                vinoRepository.save(vinoValeDosVinhedos1);
                vinoRepository.save(vinoValeDosVinhedos2);
                vinoRepository.save(vinoSerraGaucha1);
                vinoRepository.save(vinoSerraGaucha2);
                vinoRepository.save(vinoCamposDeCima1);
                vinoRepository.save(vinoCamposDeCima2);
                vinoRepository.save(vinoCanelonesRegion1);
                vinoRepository.save(vinoCanelonesRegion2);
                vinoRepository.save(vinoMontevideoRegion1);
                vinoRepository.save(vinoMontevideoRegion2);
                vinoRepository.save(vinoIcaRegion1);
                vinoRepository.save(vinoIcaRegion2);
                vinoRepository.save(vinoCuscoRegion1);
                vinoRepository.save(vinoCuscoRegion2);
                vinoRepository.save(vinoValleCalchaqui1);
                vinoRepository.save(vinoValleCalchaqui2);
                vinoRepository.save(vinoCafayate1);
                vinoRepository.save(vinoCafayate2);
                vinoRepository.save(vinoQuebradaDeHumahuaca1);
                vinoRepository.save(vinoQuebradaDeHumahuaca2);
                vinoRepository.save(vinoBioBioRegion1);
                vinoRepository.save(vinoBioBioRegion2);
                vinoRepository.save(vinoSanPedro1);
                vinoRepository.save(vinoSanPedro2);
                vinoRepository.save(vinoArtigas2);
                vinoRepository.save(vinoCerroLargo1);
                vinoRepository.save(vinoCerroLargo2);
                vinoRepository.save(vinoRivera1);
                vinoRepository.save(vinoChincha1);
                vinoRepository.save(vinoChincha2);
                vinoRepository.save(vinoNazca1);
                vinoRepository.save(vinoNazca2);
                vinoRepository.save(vinoLimaValley1);
                vinoRepository.save(vinoLimaValley2);
                vinoRepository.save(vinoTulumVineyards1);
                vinoRepository.save(vinoTulumVineyards2);
                vinoRepository.save(vinoSanJuanVino1);
                vinoRepository.save(vinoSanJuanVino2);
                vinoRepository.save(vinoZondaVineyards1);
                vinoRepository.save(vinoZondaVineyards2);
                vinoRepository.save(vinoVinoElegante1);
                vinoRepository.save(vinoVinoElegante2);
                vinoRepository.save(vinoPedernalWines1);
                vinoRepository.save(vinoPedernalWines2);
                vinoRepository.save(vinoGranPedernal1);
                vinoRepository.save(vinoGranPedernal2);
                vinoRepository.save(vinoCalingasta1);
                vinoRepository.save(vinoCalingasta2);
                vinoRepository.save(vinoVallesDeCalingasta1);
                vinoRepository.save(vinoVallesDeCalingasta2);
                vinoRepository.save(vinoCopiapo1);
                vinoRepository.save(vinoCopiapo2);
                vinoRepository.save(vinoHuasco1);
                vinoRepository.save(vinoHuasco2);
                vinoRepository.save(vinoItata1);
                vinoRepository.save(vinoItata2);
                vinoRepository.save(vinoMaule1);
                vinoRepository.save(vinoMaule2);
                vinoRepository.save(vinoCasablanca1);
                vinoRepository.save(vinoCasablanca2);
                vinoRepository.save(vinoSanAntonio1);
                vinoRepository.save(vinoSanAntonio2);
                vinoRepository.save(vinoValeDosVinhedos1);
                vinoRepository.save(vinoValeDosVinhedos2);
                vinoRepository.save(vinoSerraGaucha1);
                vinoRepository.save(vinoSerraGaucha2);
                vinoRepository.save(vinoCamposDeCima1);
                vinoRepository.save(vinoCamposDeCima2);
                vinoRepository.save(vinoCanelonesRegion1);
                vinoRepository.save(vinoCanelonesRegion2);
                vinoRepository.save(vinoMontevideoRegion1);
                vinoRepository.save(vinoMontevideoRegion2);
                vinoRepository.save(vinoIcaRegion1);
                vinoRepository.save(vinoIcaRegion2);
                vinoRepository.save(vinoCuscoRegion1);
                vinoRepository.save(vinoCuscoRegion2);
                vinoRepository.save(vinoValleCalchaqui1);
                vinoRepository.save(vinoValleCalchaqui2);
                vinoRepository.save(vinoCafayate1);
                vinoRepository.save(vinoCafayate2);
                vinoRepository.save(vinoQuebradaDeHumahuaca1);
                vinoRepository.save(vinoQuebradaDeHumahuaca2);

                System.out.println("Seed data created successfully.");
        }
}
