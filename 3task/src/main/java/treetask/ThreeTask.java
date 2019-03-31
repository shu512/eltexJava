package treetask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import treetask.classes.FizUser;
import treetask.classes.LegalUser;

import java.util.List;

public class ThreeTask {

    public static final Logger log = LoggerFactory.getLogger(ThreeTask.class);

    public static void main(String[] args) {
        List<FizUser> list;
        FizUser stas = new FizUser("test", "test", "test");
        list =  FizUser.getUsersFromDB("eltex4taskFizUser", "shu512", "1", "users");
        for (FizUser temp: list) {
            System.out.println(temp.getId() + " " + temp.getName() + "\n");
        }
    }
}
