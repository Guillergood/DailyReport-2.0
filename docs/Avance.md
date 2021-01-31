---
layout: default
title: Avance
nav_order: 9
---

# Avance
{: .d-inline-block }
Nuevo
{: .label .label-purple }


---
Como se ha dicho anteriormente en [Prueba del sistema](https://guillergood.github.io/DailyReport-2.0/docs/Testeo.html)

Se ha visto que en el peor de los casos el sistema tiene una velocidad media de 4ms. Y la mejor de 1ms.

Se ha deplegado el proyecto en la nube, concretamente en Azure, siguiendo este [tutorial](https://docs.microsoft.com/es-es/azure/app-service/tutorial-multi-container-app)

![](../img/azure.png)

Esta es la captura de pantalla de la configuración final, después de seguir la guía anterior.

Por último, se ha completado la última Historia de Usuario, [exportación de todos los reportes de los cuidadores a un pdf](https://github.com/Guillergood/DailyReport-2.0/issues/15).
Se añadió el siguiente test a pasar, utilizando la metodología TDD (Red, Green, Refactor).

```Java
    @Test
    public void exportPDF_shouldReturn() throws Exception{
        populateReportes();
        MvcResult result = this.mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/report/pdf")
                .contentType(MediaType.APPLICATION_PDF))
                .andDo(print())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.isTrue(content.contains("PDF"), "The request has a pdf");
    }
```

Añadiendo este nuevo código donde la ruta para exportarlos es:
```Java    
    @GetMapping(value= "/dailyreport/report/pdf")
    public void getPDFReport(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        List<Report> listReports = reportService.getAll();

        PDFExporter exporter = new PDFExporter(listReports);
        exporter.export(response);
    }
```

Y una nueva clase para exportar el pdf:

```Java    
public class PDFExporter {
    private List<Report> listUsers;

    public PDFExporter(List<Report> listUsers) {
        this.listUsers = listUsers;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Report ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Keeper", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Animal", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Report", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Report report : listUsers) {
            table.addCell(String.valueOf(report.getId()));
            table.addCell(report.getKeeperName());
            table.addCell(report.getAnimalName());
            table.addCell(report.getReport());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Reports", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
} 
```

Como resultado, la url devuelve una nueva pestaña donde se puede visualizar los reportes de los cuidadores.