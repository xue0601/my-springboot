package com.elasticSearch;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-12-28 10:00
 **/
@Slf4j
@RestController
@RequestMapping("/es")
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/find/{id}")
    public Employee findById(@PathVariable("id") String employeeId) {
        Employee employee = employeeRepository.queryEmployeeById(employeeId);

        return employee;
    }

    @PostMapping("/add")
    public void saveEmployee(
            @RequestParam("id") String employeeId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") Integer age,
            @RequestParam("about") String about
    ) {
        Employee employee = new Employee(employeeId, firstName, lastName, age, about);
        Employee save = employeeRepository.save(employee);
        log.info("[新增职员] id:{}", employee.getId());

    }

    //deleteMapping 不能用 怎么回事 wori 开着全局vpn 全部不能用 害的整了半天
    @GetMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") String employeeId) {
        employeeRepository.deleteById(employeeId);

        log.info("[删除职员] id:{}", employeeId);

    }

    @GetMapping("/find_firstname/{firstNameContain}")
    public Page<Employee> findByContainFirstName(@PathVariable("firstNameContain") String firstNameContain) {
        Pageable pageable = new PageRequest(0, 5);
        Page<Employee> employeePage = employeeRepository.queryEmployeeByFirstNameContaining(firstNameContain, pageable);

        return employeePage;
    }

    @GetMapping("/find_lastname/{lastNameContain}")
    public Page<Employee> findByContainLastName(@PathVariable("lastNameContain") String lastNameContain) {
        Pageable pageable = new PageRequest(0, 5);
        Page<Employee> employeePage = employeeRepository.queryEmployeeByLastNameContaining(lastNameContain, pageable);

        return employeePage;
    }

    @GetMapping("/find_about/{aboutContain}")
    public Page<Employee> findByContainAbout(@PathVariable("aboutContain") String aboutContain) {
        Pageable pageable = new PageRequest(0, 5);
        Page<Employee> employeePage = employeeRepository.queryEmployeeByAboutContaining(aboutContain, pageable);

        return employeePage;
    }

    @GetMapping("/find_all/{aboutContain}")
    public Page<Employee> findByContainAll(@PathVariable("aboutContain") String aboutContain) {
        Pageable pageable = new PageRequest(0, 5);
        Page<Employee> employeePage = employeeRepository.search(matchQuery("firstName", aboutContain), pageable);
        for (Employee employee : employeePage) {
            System.out.println(employee);
        }
        return employeePage;
    }

    @GetMapping("/templay")
    public List<Employee> test(){
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("firstName","名")).build();
        List<Employee> employees = elasticsearchTemplate.queryForList(searchQuery, Employee.class);
        return employees;
//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery("中名")).build();
//        List<Employee> articles = elasticsearchTemplate.queryForList(searchQuery, Employee.class);
//        for (Employee article : articles) {
//            System.out.println(article.toString());
//        }
//        return articles;
    }


    /**
     * 全局检索查询
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<Employee> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Employee> searchResult = employeeRepository.search(builder);
        Iterator<Employee> iterator = searchResult.iterator();
        List<Employee> list = new ArrayList<Employee>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

}

