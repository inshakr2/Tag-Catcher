package chany.tagcatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaveController {

    @GetMapping("save")
    public String toSavePage(Model model) {
        return "save";
    }
}
