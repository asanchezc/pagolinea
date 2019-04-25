package pe.farmaciasperuanas.reporte.dao;

import java.util.List;

import pe.farmaciasperuanas.reporte.pojo.ReporteVentaMatriz;

public interface IReporteVentaDao {
    void sp_locales_ventas_matriz(String locales);

    List<ReporteVentaMatriz> fn_reporte_ventas_matriz(String date);
}
