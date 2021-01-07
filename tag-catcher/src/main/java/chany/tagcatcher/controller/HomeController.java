package chany.tagcatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("upload")
    public String toUpload(Model model) {
        return "upload";
    }
}
