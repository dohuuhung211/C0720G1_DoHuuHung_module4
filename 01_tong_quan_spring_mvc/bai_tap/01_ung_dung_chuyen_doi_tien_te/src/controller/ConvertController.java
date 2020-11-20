package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ConvertService;

@Controller
public class ConvertController {
    @Autowired
    private ConvertService convertService;
    @GetMapping({"/convertMoney"})
    public String resultConvert(@RequestParam String usd, Model model){
        model.addAttribute("usd", convertService.convert(Double.parseDouble(usd)));
        return "result";
    }
}
