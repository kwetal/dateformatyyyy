package nl.ocwduo.in568bax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class JavaDateFormatter implements TestableDateFormatter {
    private static final DateTimeFormatter DISPLAY_FORMAT = DateTimeFormatter.ISO_DATE;
    private static final DateTimeFormatter GOED_FORMAT = DateTimeFormatter.ofPattern("yyyy");
    private static final DateTimeFormatter FOUT_FORMAT = DateTimeFormatter.ofPattern("YYYY");
    private LocalDate datum;

    JavaDateFormatter(String startdatum) {
        this.datum = LocalDate.from(DISPLAY_FORMAT.parse(startdatum));
    }

    @Override
    public String toString() {
        return DISPLAY_FORMAT.format(datum);
    }

    @Override
    public String formatJaarGoed() {
        return GOED_FORMAT.format(datum);
    }

    @Override
    public String formatJaarFout() {
        return FOUT_FORMAT.format(datum);
    }

    @Override
    public String title() {
        return "Java8 DateTimeFormatter";
    }

    @Override
    public void increment() {
        datum = datum.plusDays(1);
    }
}
