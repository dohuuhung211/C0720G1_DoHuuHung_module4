package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CalculatorService;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    @GetMapping("/calculator")
    public String add(@RequestParam int num1, @RequestParam int num2, @RequestParam String operator, Model model){
        switch (operator){
            case "add":
                model.addAttribute("operator", operator);
                model.addAttribute("result", calculatorService.addCal(num1, num2));
                break;
            case "sub":
                model.addAttribute("operator", operator);
                model.addAttribute("result", calculatorService.subCal(num1, num2));
                break;
            case "mul":
                model.addAttribute("operator", operator);
                model.addAttribute("result", calculatorService.mulCal(num1, num2));
                break;
            case "div":
                if(num2 != 0){
                    model.addAttribute("operator", operator);
                    model.addAttribute("result", calculatorService.divCal(num1, num2));
                } else {
                    model.addAttribute("result", "Khong duoc chia cho 0");
                }

                break;
        }
        return "index";
    }
}
