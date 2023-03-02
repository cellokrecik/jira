package com.example.jira.repository;

import com.example.jira.model.TShirtSize;
import com.example.jira.model.TShirtSizeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TShirtSizeRepository extends JpaRepository<TShirtSize, Integer> {

    List<TShirtSize> findAll();
    TShirtSize getTShirtSizeBySizeName(TShirtSizeName sizeName);
    Optional<TShirtSize> findById(Integer id);

}
