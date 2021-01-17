package chany.tagcatcher.controller;

import chany.tagcatcher.domain.Sentence;
import chany.tagcatcher.service.SentenceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SaveController {

    private SentenceService sentenceService;

    public SaveController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @GetMapping("save")
    public String toSavePage(Model model) {

        try {

            List<Sentence> sentences = sentenceService.findAll();

            if (sentences.isEmpty()) {
                model.addAttribute("status", false);
                model.addAttribute("INFO", "There is NO anyThing to read sentences in Table");
            } else {

                model.addAttribute("status", true);
                model.addAttribute("sentences", sentences);

            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("status", false);
            model.addAttribute("INFO", "An error occurred while select Table.");
        }


        return "save";
    }
}
