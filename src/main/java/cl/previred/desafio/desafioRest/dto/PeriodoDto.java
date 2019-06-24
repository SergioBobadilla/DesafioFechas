package cl.previred.desafio.desafioRest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;


public class PeriodoDto {

    @JsonProperty("id")
    private Long id = null;
    
	@JsonProperty("fechaCreacion")
    private LocalDate fechaCreacion;

    @JsonProperty("fechaFin")
    private LocalDate fechaFin;

    @JsonProperty("fechas")
    @Valid
    private List<LocalDate> fechas;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaInicio) {
		this.fechaCreacion = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}
}
