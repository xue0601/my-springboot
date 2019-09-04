package com.elasticSearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-12-28 09:46
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
@Document(indexName = "database",type = "employee")
public class Employee {

    @GeneratedValue
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String about;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", about='" + about + '\'' +
                '}';
    }
}
