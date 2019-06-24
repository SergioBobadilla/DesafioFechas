package cl.previred.desafio.desafioRest.controllers.impl;

import cl.previred.desafio.desafioRest.controllers.ApiController;
import cl.previred.desafio.desafioRest.dto.FechasAusentesDto;
import cl.previred.desafio.desafioRest.services.FechasService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

@RestController
public class PeriodoController implements ApiController {

    Logger log = LoggerFactory.getLogger(PeriodoController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private FechasService periodosService;

    @org.springframework.beans.factory.annotation.Autowired
    public PeriodoController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @RequestMapping("/periodos")
    public ResponseEntity<FechasAusentesDto> getFechasAusentes() {

        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                	FechasAusentesDto fechasAusentes = periodosService.obtenerFechasAusentes();
                    ResponseEntity<FechasAusentesDto> respuesta = new ResponseEntity<>(fechasAusentes, HttpStatus.OK);
                    return respuesta;
                } catch (Exception e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DefaultApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}