package chany.tagcatcher.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class UploadController {

    @PostMapping("/upload-csv")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("INFO", "Retry Choosing CSV File");
            model.addAttribute("status", false);
        } else {

            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                CsvToBean<String> csvToBean = new CsvToBeanBuilder(reader)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                List<String> sentences = csvToBean.parse();

                //TODO -- TO DB

                model.addAttribute("sentences", sentences);
                model.addAttribute("status", true);

            } catch (IOException e) {
                model.addAttribute("INFO", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "upload-csv-status";
    }
}
