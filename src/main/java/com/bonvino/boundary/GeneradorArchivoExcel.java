package com.bonvino.boundary;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class GeneradorArchivoExcel {

    public byte[] generarArchivo(String[][] datos) throws IOException {
        // Crear el archivo Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Ranking de Vinos");

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        String[] headers = {
                "Nombre",
                "Calificación Sommelier",
                "Calificación General",
                "Precio ARS",
                "Bodega",
                "Varietal",
                "Región",
                "País" };
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Llenar datos
        int rowNum = 1;
        for (String[] datosVino : datos) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < datosVino.length; i++) {
                row.createCell(i).setCellValue(datosVino[i]);
            }
        }

        // Escribir el archivo a un ByteArrayOutputStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out.toByteArray();
    }
}