package com.mdaneri;

import com.mdaneri.interfaces.Documentable;
import com.mdaneri.interfaces.Report;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Curriculum curriculum = new Curriculum("Datos del curriculum");
        PDFBook pdfBook = new PDFBook("Contenido del libro pdf");
        Report report = new Report("Contenido del reporte");

        List<Documentable> documentableList = new ArrayList<>();
        documentableList.add(curriculum);
        documentableList.add(pdfBook);
        documentableList.add(report);

        documentableList.forEach(System.out::println);


    }
}