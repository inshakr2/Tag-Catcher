package chany.tagcatcher.controller;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class UploadController {

    @PostMapping("/upload-csv")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("INFO", "Retry Choosing CSV File");
            model.addAttribute("status", false);
        } else {

            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {


                CsvToBean<String> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(String.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                List<String> sentences = csvToBean.parse();
                System.out.println(sentences.toString());
                //TODO -- TO DB

                model.addAttribute("sentences", sentences);
                model.addAttribute("status", true);
                model.addAttribute("how", "csv");

            } catch (IOException | CsvException e) {
                model.addAttribute("INFO", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "upload-result";
    }
}