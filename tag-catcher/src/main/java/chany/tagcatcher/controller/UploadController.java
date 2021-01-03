package chany.tagcatcher.controller;

import chany.tagcatcher.domain.Sentence;
import chany.tagcatcher.service.SentenceService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {

    private SentenceService sentenceService;

    @Autowired
    public UploadController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @PostMapping("/upload-csv")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("INFO", "Retry Choosing CSV File");
            model.addAttribute("status", false);
        } else {

            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream() ,"EUC-KR"))) {

                CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Sentence.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                List<Sentence> sentences = csvToBean.parse();


                //TODO -- TO DB

                model.addAttribute("sentences", sentences);
                model.addAttribute("status", true);


            } catch (IOException e) {
                model.addAttribute("INFO", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "upload-result";
    }

    @PostMapping("/upload-text")
    public String uploadCSVFile(@RequestParam("text") String text, Model model) throws IOException {

        if (text.isBlank()) {
            model.addAttribute("status",false);
            model.addAttribute("INFO", "Enter Text And Try again");

        } else {

            List<Sentence> sentences = new ArrayList<Sentence>();
            String[] texts =  text.split("\\r\\n");




            model.addAttribute("status", true);
            model.addAttribute("sentences", sentences);


        }
        return "upload-result";

    }
}
