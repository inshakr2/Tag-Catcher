package chany.tagcatcher.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.Reader;

public class UploadController {

    @PostMapping("/upload-CSV")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("err", "Retry Choosing CSV File");
            model.addAttribute("status", false);
        } else {




        }

        return "";
    }
}
