package cl.previred.desafio.desafioRest.utils;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

public class DateUtils {

    /**
     *
     * @param startDate Fecha inicio
     * @param endDate Fecha termino
     * @param exceptionDate fechas que ya se encuentran en el array de entrada
     * @return LocalDate fechas que faltan en el array exceptionDate
     */
    public static List<LocalDate> getDatesBetween(
            LocalDate startDate, LocalDate endDate, List<LocalDate> exceptionDate) {

        long numeroMesesEntreFechas = numeroMesesEntreFechas(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numeroMesesEntreFechas)
                .mapToObj(i -> startDate.plusMonths(i))
                .filter(i -> !exceptionDate.contains(i))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param startDate fecha inicio
     * @param endDate fecha termino
     * @return Numero de meses entre fecha inicio fecha termino
     */
    public static Long numeroMesesEntreFechas(
            LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.MONTHS.between(startDate, endDate) + 1;
    }
}