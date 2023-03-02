package com.example.jira.service;

import com.example.jira.model.TShirtSize;

import java.util.Map;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
public class Utils {

    public static double calculate(List<TShirtSize> allTShirtSizes, Map<String, String> fields) {
            AtomicReference<Double> weightOfIssue = new AtomicReference<>((double) 0);
            for (Map.Entry<String, String> entry : fields.entrySet()) {
                allTShirtSizes.forEach(tShirtSize -> {
                    if (tShirtSize.getSizeName().name().equals(entry.getValue())) {
                        weightOfIssue.updateAndGet(v -> new Double((double) (v + tShirtSize.getSizeValue())));
                    }
                });
            }
            return weightOfIssue.get();
    }
}
