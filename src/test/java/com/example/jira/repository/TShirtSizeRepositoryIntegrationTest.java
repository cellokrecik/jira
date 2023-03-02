package com.example.jira.repository;

import com.example.jira.model.TShirtSizeName;
import com.example.jira.model.TShirtSize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.example.jira.model.TShirtSizeName.XL;
import static com.example.jira.model.TShirtSizeName.L;
import static com.example.jira.model.TShirtSizeName.M;
import static com.example.jira.model.TShirtSizeName.S;
import static com.example.jira.model.TShirtSizeName.XS;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TShirtSizeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TShirtSizeRepository repository;

    @Test
    public void givenListOfTShirtSizes_whenFindAll_thenReturnAllSizes() {

        TShirtSize size_XS = getTshirtSize(1, XS, 0.3);
        TShirtSize size_S = getTshirtSize(2, S, 0.6);
        TShirtSize size_M = getTshirtSize(3, M, 1);
        TShirtSize size_L = getTshirtSize(4, L, 1.5);
        TShirtSize size_XL = getTshirtSize(5, XL, 2);

        entityManager.merge(size_XS);
        entityManager.merge(size_S);
        entityManager.merge(size_M);
        entityManager.merge(size_L);
        entityManager.merge(size_XL);
        entityManager.flush();

        List<TShirtSize> result = repository.findAll();

        assertThat(result)
                .hasSize(5)
                .extracting(TShirtSize::getSizeName).containsOnly(XS, S, M, L, XL);
    }

    private TShirtSize getTshirtSize(int id, TShirtSizeName name, double value) {
        return TShirtSize.builder()
                .id(id)
                .sizeName(name)
                .sizeValue(value)
                .build();
    }
}
