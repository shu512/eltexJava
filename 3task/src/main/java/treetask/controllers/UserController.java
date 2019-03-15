package treetask.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import treetask.classes.FizUser;

import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/get_users_from_bd")
    public List<FizUser> getUsers() {
        return FizUser.getUsersFromDB("eltex4taskFizUser", "shu512", "1", "users");
    }
}
