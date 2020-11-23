package service.impl;

import org.springframework.stereotype.Service;
import service.DictionaryService;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryMapServiceImpl implements DictionaryService {

    @Override
    public String translateByMap(String dictionary) {
        Map<String, String> dictionaryMap = new HashMap<>();
        dictionaryMap.put("hello", "xin chao");
        dictionaryMap.put("one", "so mot");
        dictionaryMap.put("two", "so hai");
        dictionaryMap.put("three", "so ba");
        dictionaryMap.put("four", "so bon");
        dictionaryMap.put("thank you", "cam on ban");
        return dictionaryMap.get(dictionary);
    }
}
