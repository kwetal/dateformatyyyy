package nl.ocwduo.in568bax;

public class DateFormatDemo implements Runnable {

    @Override
    public void run() {
        String startdatum = "1800-01-01";
        String stopjaar = "2200";
        testJava(new JavaDateFormatter(startdatum), stopjaar);
        testJava(new JodaDateFormatter(startdatum), stopjaar);
    }

    private void testJava(TestableDateFormatter dateFormatter, String stopjaar) {
        int countTotaal = 0;
        int countFout = 0;
        String goed;
        do {
            countTotaal++;
            goed = dateFormatter.formatJaarGoed();
            String fout = dateFormatter.formatJaarFout();
            if (!goed.equals(fout)) {
                System.out.println(dateFormatter + " -> YYYY geeft " + fout);
                countFout++;
            }
            dateFormatter.increment();
        } while (!goed.equals(stopjaar));
        System.out.printf("%s: %d datums getest, %d waren afwijkend%n", dateFormatter.title(), countTotaal, countFout);
    }

    public static void main(String[] args) {
        new DateFormatDemo().run();
    }
}
