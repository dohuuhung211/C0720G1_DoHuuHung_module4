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
    @Qualifier("addServiceImpl")
    @Autowired
    private CalculatorService calculatorServiceAdd;

    @Qualifier("subServiceImpl")
    @Autowired
    private CalculatorService calculatorServiceSub;
    @Qualifier("multiServiceImpl")
    @Autowired
    private CalculatorService calculatorServiceMul;
    @Qualifier("divisionServiceImpl")
    @Autowired
    private CalculatorService calculatorServiceDiv;
    @GetMapping("/calculator")
    public String add(@RequestParam int num1, @RequestParam int num2, @RequestParam String operator, Model model){
        switch (operator){
            case "add":
                model.addAttribute("operator", operator);
                model.addAttribute("result", calculatorServiceAdd.calculated(num1, num2));
                break;
            case "sub":
                model.addAttribute("operator", operator);
                model.addAttribute("result", calculatorServiceSub.calculated(num1, num2));
                break;
            case "mul":
                model.addAttribute("operator", operator);
                model.addAttribute("result", calculatorServiceMul.calculated(num1, num2));
                break;
            case "div":
                if(num2 != 0){
                    model.addAttribute("operator", operator);
                    model.addAttribute("result", calculatorServiceDiv.calculated(num1, num2));
                } else {
                    model.addAttribute("result", "Khong duoc chia cho 0");
                }

                break;
        }
        return "index";
    }
}
