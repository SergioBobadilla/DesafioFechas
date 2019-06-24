package cl.previred.desafio.desafioRest.services.impl;

import cl.previred.desafio.desafioRest.dto.PeriodoDto;
import cl.previred.desafio.desafioRest.utils.DateUtils;
import cl.previred.desafio.desafioRest.dto.FechasAusentesDto;
import cl.previred.desafio.desafioRest.services.FechasService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import java.util.List;
import java.time.LocalDate;
import java.util.Collections;

@Service
public class FechasServiceImpl implements FechasService {

    @Autowired
    private Environment env;

    /**
     * obtenerFechasAusentes() devuelve un objeto que contiene una lista de las fechas que están ausentes (Representa la lógica principal del desafío)
     * @return FechasAusentesDto
     */
    @Override
    public FechasAusentesDto obtenerFechasAusentes(){
        PeriodoDto periodos = obtenerPeriodo();
        List<LocalDate> listaFechas = DateUtils.getDatesBetween(periodos.getFechaCreacion(), periodos.getFechaFin(), periodos.getFechas());
        FechasAusentesDto fechasAusentes = new FechasAusentesDto();
        fechasAusentes.setFechaInicio(periodos.getFechaCreacion());
        fechasAusentes.setFechaFin(periodos.getFechaFin());
        fechasAusentes.setFechas(periodos.getFechas());
        fechasAusentes.setFechasAusentes(listaFechas);
        fechasAusentes.setId(periodos.getId());

        return fechasAusentes;

    }

    /**
     * obtenerPeriodo() Recupera la fecha de inicio, fecha fin y la lista de fechas llamando al servicio Generador De Datos
     * @return PeriodoDto
     */
    public PeriodoDto obtenerPeriodo(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>("body", headers);
        String endpoint = env.getProperty("api.generador.datos");
        ResponseEntity<PeriodoDto> response = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity, PeriodoDto.class);
        return response.getBody();
    }


}
