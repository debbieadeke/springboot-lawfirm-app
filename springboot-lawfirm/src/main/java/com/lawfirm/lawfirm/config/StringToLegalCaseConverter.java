package com.lawfirm.lawfirm.config;

import com.lawfirm.lawfirm.models.LegalCase;
import com.lawfirm.lawfirm.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLegalCaseConverter implements Converter<String, LegalCase> {

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public LegalCase convert(String source) {
        try {
            Long id = Long.parseLong(source);
            return caseRepository.findById(id).orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
