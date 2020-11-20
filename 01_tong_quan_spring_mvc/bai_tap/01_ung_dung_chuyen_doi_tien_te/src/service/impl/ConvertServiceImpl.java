package service.impl;

import org.springframework.stereotype.Service;
import service.ConvertService;
@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public double convert(double usd) {
        return usd * 24000;
    }
}
