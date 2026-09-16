package br.com.iniflex.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class FormatadorUtil {
    private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final NumberFormat FORMATADOR_NUMERO = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));

    private FormatadorUtil() {
    }

    public static String formatarData(LocalDate data) {
        return data.format(FORMATADOR_DATA);
    }

    public static String formatarNumero(BigDecimal valor) {
        return FORMATADOR_NUMERO.format(valor);
    }
}
