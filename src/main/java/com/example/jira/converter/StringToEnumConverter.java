package com.example.jira.converter;

import com.example.jira.model.TShirtSizeName;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEnumConverter implements Converter<String, TShirtSizeName> {


    @Override
    public TShirtSizeName convert(String source) {
        return TShirtSizeName.valueOf(source.toUpperCase());
    }
}
