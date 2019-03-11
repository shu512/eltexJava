package treetask;

import treetask.classes.FizUser;
import treetask.classes.LegalUser;


public class ThreeTask {
    public static void main(String[] args) {
        FizUser stas = new FizUser("test", "test", "test");
        stas.readFromBD("eltex4taskFizUser", "shu512", "1", "users");
        stas.writeInBD("eltex4taskFizUser", "shu512", "1", "users");
    }
}
