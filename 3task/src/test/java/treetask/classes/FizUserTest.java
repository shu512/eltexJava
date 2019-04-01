package treetask.classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizUserTest {
    @Test
    public void test_create_new_FizUser_through_name() {
        FizUser fizUser = new FizUser("Maksim", "2440505", "Novosibirsk");
        assertEquals("Maksim", fizUser.getName());
    }
    @Test
    public void test_create_new_FizUser_through_phone() {
        FizUser fizUser = new FizUser("Maksim", "2440505", "Novosibirsk");
        assertEquals("2440505", fizUser.getPhone());
    }
}
