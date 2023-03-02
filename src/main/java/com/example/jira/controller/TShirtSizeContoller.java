package com.example.jira.controller;

import com.example.jira.model.TShirtSize;
import com.example.jira.model.TShirtSizeName;
import com.example.jira.service.TShirtSizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequestMapping("/tshirtsize")
@RequiredArgsConstructor
public class TShirtSizeContoller {


    private final TShirtSizeService service;

    @GetMapping("/all")
    public List<TShirtSize> getTShirtSizes() {
        return service.getAllTShirtSizes();
    }

    @GetMapping("/getBySizeName")
    public TShirtSize getTShirtSizeBySizeName(@RequestParam("sizeName")TShirtSizeName sizeName) {
        return service.getTShirtSizeBySizeName(sizeName);
    }

    @PostMapping("/update/{id}")
    public TShirtSize updateValueOfTShirtSize(@PathVariable("id") Integer id, @RequestParam("newValue") double newValue) {
        return service.update(id, newValue);
    }
}
