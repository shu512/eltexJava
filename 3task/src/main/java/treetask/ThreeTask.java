package treetask;

import treetask.classes.FizUser;
import treetask.classes.LegalUser;

public class ThreeTask {
    public static void main(String[] args) {
        LegalUser stas = new LegalUser("Stas", "8923", "Nsk");
        stas.writeInCSV("stas.csv", ";");
        LegalUser test = new LegalUser("stas.csv", ";");
        test.writeInCSV("test.csv", ";");
    }
}
