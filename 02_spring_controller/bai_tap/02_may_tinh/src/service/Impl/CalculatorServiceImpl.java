package service.Impl;

import org.springframework.stereotype.Service;
import service.CalculatorService;
@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int addCal(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subCal(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int mulCal(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divCal(int num1, int num2) {
        return num1 / num2;
    }
}
