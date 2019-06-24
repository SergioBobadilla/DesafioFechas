package cl.previred.desafio.desafioRest;

import cl.previred.desafio.desafioRest.services.impl.FechasServiceImpl;
import cl.previred.desafio.desafioRest.utils.DateUtils;
import cl.previred.desafio.desafioRest.dto.FechasAusentesDto;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PreviredDesafioRestApplicationTests {

	@Autowired
	private FechasServiceImpl periodosService;

	@Test
	public void contextLoads() {
	}
	@Test
	public void retornaFechasRecibidosConAusentes(){
		FechasAusentesDto periodosAusentes = periodosService.obtenerFechasAusentes();
		Long totalFechas = DateUtils.numeroMesesEntreFechas(periodosAusentes.getFechaInicio(), periodosAusentes.getFechaFin());
		Number totalFechasServicio = (periodosAusentes.getFechas().size() + periodosAusentes.getFechasAusentes().size());
		Assert.assertEquals(totalFechas.longValue(),  totalFechasServicio.longValue());
	}

}