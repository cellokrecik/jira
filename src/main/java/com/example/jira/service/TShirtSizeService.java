package com.example.jira.service;

import com.example.jira.model.TShirtSize;
import com.example.jira.model.TShirtSizeName;
import com.example.jira.repository.TShirtSizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TShirtSizeService {

    private final TShirtSizeRepository repository;

    public List<TShirtSize> getAllTShirtSizes() {
        return repository.findAll();
    }

    public TShirtSize getTShirtSizeBySizeName(TShirtSizeName sizeName) {
        return repository.getTShirtSizeBySizeName(sizeName);
    }

    public TShirtSize getTShirtSizeById(Integer id) {
        return repository.findById(id).get();
    }

    public TShirtSize update(Integer id, double newValue) {
        TShirtSize tShirtSizeById = getTShirtSizeById(id);
        tShirtSizeById.setSizeValue(newValue);
        return repository.save(tShirtSizeById);
    }
}
