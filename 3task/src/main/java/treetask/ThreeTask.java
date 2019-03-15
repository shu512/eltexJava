package treetask;

import treetask.classes.FizUser;
import treetask.classes.LegalUser;

import java.util.ArrayList;
import java.util.List;


public class ThreeTask {
    public static void main(String[] args) {
        List<FizUser> list;
        FizUser stas = new FizUser("test", "test", "test");
        list =  FizUser.getUsersFromDB("eltex4taskFizUser", "shu512", "1", "users");
        for (FizUser temp: list) {
            System.out.println(temp.getId() + " " + temp.getName() + "\n");
        }
    }
}
