package treetask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTML {
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
}
