package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;

@Controller
public class DictionaryController {
    @Qualifier("dictionaryMapServiceImpl")

    @Autowired
    private DictionaryService dictionaryService;
//    @GetMapping("/trans")
//    public String translateDictionary(@RequestParam String dictionary, Model model){
//        model.addAttribute("dictionary", dictionaryService.translate(dictionary));
//        return "result";
//    }
    @GetMapping("/map")
    public String translateByMap(@RequestParam String dictionary, Model model){
        model.addAttribute("dictionary", dictionaryService.translateByMap(dictionary));
        return "result";
    }

}
