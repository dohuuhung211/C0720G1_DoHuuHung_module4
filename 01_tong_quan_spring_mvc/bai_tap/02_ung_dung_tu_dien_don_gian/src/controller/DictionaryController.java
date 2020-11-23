package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping("/trans")
    public String translateDictionary(@RequestParam String dictionary, Model model){
        model.addAttribute("dictionary", dictionaryService.translate(dictionary));
        return "result";
    }
}
