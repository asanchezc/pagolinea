package pe.farmaciasperuanas.reporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableSpringDataWebSupport
public class DemoApplication {

	

	
	//@Autowired
	//private PagoEnLineaRepository pagoEnLineaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
/*	@PostConstruct
	public void init() {
		
		PagoEnLinea pago1 = new PagoEnLinea();
		pago1.setLocalId("E31");
		pago1.setLocalName("CD SURQUILLO");
		pago1.setOrderId("3");
		pago1.setDateDelivery("2019-04-17");
		pago1.setStatus("CANCELADO");
		pago1.setAmount(20.50);
		
		pagoEnLineaRepository.save(pago1);
		
		PagoEnLinea pago2 = new PagoEnLinea();
		pago2.setLocalId("901");
		pago2.setLocalName("TRUJILLO 19");
		pago2.setOrderId("4");
		pago2.setDateDelivery("2019-04-17");
		pago2.setStatus("ENTREGADO");
		pago2.setAmount(430.50);
				
		pagoEnLineaRepository.save(pago2);
	}*/
}
