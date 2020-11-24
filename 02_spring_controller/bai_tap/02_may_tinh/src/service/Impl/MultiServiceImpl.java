package service.Impl;

import org.springframework.stereotype.Service;
import service.CalculatorService;
@Service
public class MultiServiceImpl implements CalculatorService {
    @Override
    public int calculated(int num1, int num2) {
        return num1 * num2;
    }
}
