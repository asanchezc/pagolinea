package pe.farmaciasperuanas.reporte.dao.impl;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.farmaciasperuanas.reporte.dao.IReporteVentaDao;
import pe.farmaciasperuanas.reporte.mapper.ReporteVentaMapper;
import pe.farmaciasperuanas.reporte.pojo.ReporteVentaMatriz;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ReporteVentaDaoImpl implements IReporteVentaDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public void sp_locales_ventas_matriz(String locales) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_IV_RECAU_MTRIZ");
        simpleJdbcCall.withProcedureName("SP_LOCALES_VENTAS_MATRIZ")
                .declareParameters(
                        new SqlParameter("cArrayCoLocal_in", Types.VARCHAR))
                .withoutProcedureColumnMetaDataAccess();
        SqlParameterSource in = new MapSqlParameterSource().addValue( "cArrayCoLocal_in", locales);

        simpleJdbcCall.execute(in);
    }

    @Override
    public List<ReporteVentaMatriz> fn_reporte_ventas_matriz(String fecha) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_IV_RECAU_MTRIZ");
        List<ReporteVentaMatriz> lstReporteVentaMatriz = new ArrayList<ReporteVentaMatriz>();
        simpleJdbcCall.withFunctionName("FN_REPORTE_VENTAS_MATRIZ")
                .declareParameters(
                    new SqlOutParameter("Results", OracleTypes.CURSOR, new ReporteVentaMapper()),
                    new SqlParameter("cFechaIni_in", Types.VARCHAR),
                    new SqlParameter("cFechaFin_in", Types.VARCHAR))
                .withoutProcedureColumnMetaDataAccess();

        SqlParameterSource in = new MapSqlParameterSource().addValue( "cFechaIni_in", fecha).addValue("cFechaFin_in",fecha);

        lstReporteVentaMatriz = (List<ReporteVentaMatriz>) simpleJdbcCall.executeFunction(ReporteVentaMapper.class, in);
        return  lstReporteVentaMatriz;
    }
}
