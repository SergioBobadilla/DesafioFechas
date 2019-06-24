package cl.previred.desafio.desafioRest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

public class FechasAusentesDto {

    @JsonProperty("id")
    private Long id = null;
    
    @JsonProperty("fechas")
    @Valid
    private List<LocalDate> fechas;
    
    @JsonProperty("fechaInicio")
    private LocalDate fechaInicio;

    @JsonProperty("fechaFin")
    private LocalDate fechaFin;

    @JsonProperty("fechasAusentes")
    @Valid
    private List<LocalDate> fechasAusentes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<LocalDate> getFechasAusentes() {
		return fechasAusentes;
	}

	public void setFechasAusentes(List<LocalDate> fechasAusentes) {
		this.fechasAusentes = fechasAusentes;
	}


}
