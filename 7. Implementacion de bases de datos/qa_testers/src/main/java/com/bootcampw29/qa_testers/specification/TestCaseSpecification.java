package com.bootcampw29.qa_testers.specification;

import com.bootcampw29.qa_testers.model.TestCase;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Optional;

public class TestCaseSpecification {
    public static Specification<TestCase> withLastUpdateAfter(Optional<LocalDate> lastUpdate) {

        return (root, query, criteriaBuilder) ->
                lastUpdate.map(date -> criteriaBuilder.greaterThanOrEqualTo(root.get("lastUpdate"), date))
                        .orElse(null);
    }
}
