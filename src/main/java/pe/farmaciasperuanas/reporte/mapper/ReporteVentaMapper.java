package pe.farmaciasperuanas.reporte.mapper;

import org.springframework.jdbc.core.RowMapper;

import pe.farmaciasperuanas.reporte.pojo.ReporteVentaMatriz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReporteVentaMapper implements RowMapper<ReporteVentaMatriz> {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public ReporteVentaMatriz mapRow(ResultSet resultSet, int i) throws SQLException {
        ReporteVentaMatriz reporteVentaMatriz = new ReporteVentaMatriz();

        String date = format.format(new Date(resultSet.getDate("FECHA").getTime()));

        reporteVentaMatriz.setLocalId(resultSet.getString("COLOCAL"));
        reporteVentaMatriz.setLocalName(resultSet.getString("DELOCAL").trim());
        //reporteVentaMatriz.setOrderId(resultSet.getString("PEDIDO"));
        reporteVentaMatriz.setOrderId(resultSet.getString("DELIVERY"));
        reporteVentaMatriz.setStatus(resultSet.getString("ESTADO"));
        reporteVentaMatriz.setDateDelivery(date);
        reporteVentaMatriz.setAmount(resultSet.getDouble("MONTO"));
        return reporteVentaMatriz;
    }
}
