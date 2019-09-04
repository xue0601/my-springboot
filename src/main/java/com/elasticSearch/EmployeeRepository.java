package com.elasticSearch;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
    Employee queryEmployeeById(String id);

    Page<Employee> queryEmployeeByFirstNameContaining(String firstNameContain, Pageable pageable);

    Page<Employee> queryEmployeeByLastNameContaining(String lastNameContain, Pageable pageable);

    Page<Employee> queryEmployeeByAboutContaining(String aboutContain, Pageable pageable);
}
