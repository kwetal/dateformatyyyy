package nl.ocwduo.in568bax;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

class JodaDateFormatter implements TestableDateFormatter {
    private static final DateTimeFormatter DISPLAY_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd");
    private static final DateTimeFormatter GOED_FORMAT = DateTimeFormat.forPattern("yyyy");
    private static final DateTimeFormatter FOUT_FORMAT = DateTimeFormat.forPattern("YYYY");
    private LocalDate datum;

    JodaDateFormatter(String startdatum) {
        this.datum = LocalDate.parse(startdatum, DISPLAY_FORMAT);
    }

    @Override
    public String toString() {
        return DISPLAY_FORMAT.print(datum);
    }

    @Override
    public String title() {
        return "Joda DateTimeFormat";
    }

    @Override
    public String formatJaarGoed() {
        return GOED_FORMAT.print(datum);
    }

    @Override
    public String formatJaarFout() {
        return FOUT_FORMAT.print(datum);
    }

    @Override
    public void increment() {
        datum = datum.plusDays(1);
    }
}
