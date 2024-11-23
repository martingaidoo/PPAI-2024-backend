package com.bonvino.components;

import com.bonvino.model.*;
import com.bonvino.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private RegionVitivinicolaRepository regionVitivinicolaRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired
    private VinoRepository vinoRepository;

    @Autowired
    private VarietalRepository varietalRepository;

    @Autowired
    private ResenaRepository resenaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear instancias de las entidades principales

        // Crear Paises y Provincias
        Pais argentina = new Pais(null, "Argentina", new ArrayList<>());
        Pais chile = new Pais(null, "Chile", new ArrayList<>());

        Provincia mendoza = new Provincia(null, "Mendoza", argentina, new ArrayList<>());
        Provincia sanJuan = new Provincia(null, "San Juan", argentina, new ArrayList<>());
        Provincia maipo = new Provincia(null, "Maipo", chile, new ArrayList<>());

        argentina.setProvincias(List.of(mendoza, sanJuan));
        chile.setProvincias(List.of(maipo));

        // Persistir países y provincias
        paisRepository.save(argentina);
        paisRepository.save(chile);
        provinciaRepository.save(mendoza);
        provinciaRepository.save(sanJuan);
        provinciaRepository.save(maipo);

        // Crear Regiones Vitivinícolas
        RegionVitivinicola lujanDeCuyo = new RegionVitivinicola(null, "Luján de Cuyo", "Famosa por sus Malbec", mendoza);
        RegionVitivinicola ucoValley = new RegionVitivinicola(null, "Valle de Uco", "Excelentes Alturas", mendoza);
        RegionVitivinicola aconcagua = new RegionVitivinicola(null, "Aconcagua", "Excelentes Cabernets", maipo);

        mendoza.setRegionesVitivinicolas(List.of(lujanDeCuyo, ucoValley));
        maipo.setRegionesVitivinicolas(List.of(aconcagua));

        // Persistir regiones vitivinícolas
        regionVitivinicolaRepository.save(lujanDeCuyo);
        regionVitivinicolaRepository.save(ucoValley);
        regionVitivinicolaRepository.save(aconcagua);

        // Crear Bodegas
        Bodega catena = new Bodega(null, "Catena Zapata", "Una de las mejores bodegas de Mendoza", "Historia rica", "Anual", "lat:-32.8908, lon:-68.8378", lujanDeCuyo);
        Bodega conchaYToro = new Bodega(null, "Concha y Toro", "Famosa bodega chilena", "Tradición e innovación", "Anual", "lat:-33.6020, lon:-70.5759", aconcagua);

        // Persistir bodegas
        bodegaRepository.save(catena);
        bodegaRepository.save(conchaYToro);

        // Crear Vinos y Varietales
        Vino malbec = new Vino(null, new Date(), "Malbec Reserva", "Excelente", 1200.50f, new Varietal[0], new Resena[0], catena);
        Vino cabernet = new Vino(null, new Date(), "Cabernet Sauvignon", "Muy bueno", 1500.75f, new Varietal[0], new Resena[0], conchaYToro);

        // Persistir vinos
        vinoRepository.save(malbec);
        vinoRepository.save(cabernet);

        Varietal malbecVarietal = new Varietal(null, "Malbec", 100.0f, malbec);
        Varietal cabernetVarietal = new Varietal(null, "Cabernet Sauvignon", 100.0f, cabernet);

        // Persistir varietales
        varietalRepository.save(malbecVarietal);
        varietalRepository.save(cabernetVarietal);

        malbec.setVarietal(new Varietal[]{malbecVarietal});
        cabernet.setVarietal(new Varietal[]{cabernetVarietal});
        vinoRepository.save(malbec);
        vinoRepository.save(cabernet);

        // Crear Reseñas
        Resena reseñaMalbec = new Resena(null, "Gran Malbec", new Date(), 4.5f, true, malbec);
        Resena reseñaCabernet = new Resena(null, "Cabernet robusto", new Date(), 4.0f, false, cabernet);

        // Persistir reseñas
        resenaRepository.save(reseñaMalbec);
        resenaRepository.save(reseñaCabernet);

        malbec.setResena(new Resena[]{reseñaMalbec});
        cabernet.setResena(new Resena[]{reseñaCabernet});
        vinoRepository.save(malbec);
        vinoRepository.save(cabernet);

        System.out.println("Seed data created successfully.");
    }
}

