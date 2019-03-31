package treetask.classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LegalUserTest {
    @Test
    public void test_create_new_LegalUser_through_name() {
        LegalUser legalUser = new LegalUser("Maksim", "2440505", "Eltex");
        assertEquals("Eltex", legalUser.getNameCompany());
    }
}
