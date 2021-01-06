package chany.tagcatcher.controller;

import chany.tagcatcher.domain.Sentence;
import chany.tagcatcher.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UpdateDeleteController {

    private SentenceService sentenceService;

    @Autowired
    public UpdateDeleteController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }


    @GetMapping("/update")
    public String updateSentence(@RequestParam("id") Long id,
                                 @RequestParam("sentence") String sentence,
                                 Model model) {
        return "redirect:/refresh";
    }

    @GetMapping("/delete")
    public String deleteSentence(@RequestParam("id") Long id, Model model) {

        try {
            sentenceService.deleteOne(id);
            List<Sentence> sentences = sentenceService.findAll();

            model.addAttribute("status", true);
            model.addAttribute("sentences", sentences);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("INFO", "an Error occur in delete sentence");
            model.addAttribute("status", false);
        }

        return "upload-result";
    }

}
