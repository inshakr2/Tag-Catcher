package chany.tagcatcher.controller;

import chany.tagcatcher.domain.Sentence;
import chany.tagcatcher.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static chany.tagcatcher.utils.ReadUtils.readCsv;
import static chany.tagcatcher.utils.ReadUtils.readTextarea;

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

            try {

                List<Sentence> uploadSentences = readCsv(file);

                for(Sentence sentence : uploadSentences) {
                    sentenceService.regist(sentence);
                }

                List<Sentence> sentences = sentenceService.findAllSortByResult();

                model.addAttribute("sentences", sentences);
                model.addAttribute("status", true);


            } catch (Exception e) {
                model.addAttribute("INFO", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
                e.printStackTrace();
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

            List<Sentence> textarea = readTextarea(text);
            for (Sentence sentence : textarea) {
                sentenceService.regist(sentence);
            }

            List<Sentence> sentences = sentenceService.findAllSortByResult();


            model.addAttribute("status", true);
            model.addAttribute("sentences", sentences);


        }
        return "upload-result";

    }
}
