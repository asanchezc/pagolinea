package pe.farmaciasperuanas.reporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.farmaciasperuanas.reporte.pojo.ReporteVentaMatriz;
import pe.farmaciasperuanas.reporte.pojo.Request;
import pe.farmaciasperuanas.reporte.service.IReporteVentaService;

@RestController
public class ReporteController {

	@Autowired
	private IReporteVentaService reporteVentaService;

	@RequestMapping(value = "/reporte-service/venta_matriz", method = RequestMethod.POST)
	public ResponseEntity<Iterable<ReporteVentaMatriz>> listarLocales(@RequestBody Request request) {
		String locales = "";
		for(int i=0; i<request.getLocalIds().size(); i++){
			if (request.getLocalIds().size() != (i+1))
				locales = locales + request.getLocalIds().get(i)+"|";
			else
				locales = locales + request.getLocalIds().get(i);
		}
		String year = request.getDateDelivery().substring(0,4);
		String mounth = request.getDateDelivery().substring(5,7);
		String day = request.getDateDelivery().substring(8,10);
		String date = day+"/"+mounth+"/"+year;

		return ResponseEntity.ok(reporteVentaService.reporteVentasMatriz(date, locales));
	}


}
