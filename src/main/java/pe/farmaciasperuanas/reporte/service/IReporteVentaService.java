package pe.farmaciasperuanas.reporte.service;

import java.util.List;

import pe.farmaciasperuanas.reporte.pojo.ReporteVentaMatriz;

public interface IReporteVentaService {

    List<ReporteVentaMatriz> reporteVentasMatriz(String fecha, String locales);
}
