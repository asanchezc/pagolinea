package pe.farmaciasperuanas.reporte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.farmaciasperuanas.reporte.dao.IReporteVentaDao;
import pe.farmaciasperuanas.reporte.pojo.ReporteVentaMatriz;
import pe.farmaciasperuanas.reporte.service.IReporteVentaService;

import java.util.List;

@Service
public class ReporteVentaServiceImpl implements IReporteVentaService {
    @Autowired
    IReporteVentaDao reporteVentaDao;

    @Override
    public List<ReporteVentaMatriz> reporteVentasMatriz(String fecha, String locales) {
        reporteVentaDao.sp_locales_ventas_matriz(locales);
        return reporteVentaDao.fn_reporte_ventas_matriz(fecha);

    }
}
