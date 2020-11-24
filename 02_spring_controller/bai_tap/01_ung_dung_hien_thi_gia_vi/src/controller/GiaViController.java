package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GiaViController {
    @GetMapping("/sandwich")
    public String getGiaVi(@RequestParam(required = false) String[] check, Model model){
        if (check != null){
            model.addAttribute("giaViList", check);
        } else {
            model.addAttribute("giaViList", "List rong");
        }

        return "result";
    }
}
