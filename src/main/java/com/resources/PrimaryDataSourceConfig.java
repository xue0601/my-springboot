//package com.resources;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.util.Map;
//
///**
// * @program: my-springboot
// * @description: 第一个数据源
// * @author: Xue0601
// * @create: 2018-12-14 10:47
// **/
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactoryPrimary",
//        transactionManagerRef="transactionManagerPrimary",
//        basePackages= {"com.ylyw.slaver.service"})
//public class PrimaryDataSourceConfig {
//
//    @Autowired
//    @Qualifier("primaryDataSource")
//    private DataSource primaryDataSource;
//
//
//    @Primary
//    @Bean(name = "entityManagerPrimary")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
//    }
//
//    @Primary
//    @Bean(name = "entityManagerFactoryPrimary")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(primaryDataSource)
//                .properties(getVendorProperties(primaryDataSource))
//                //设置实体类所在位置
//                .packages("com.ylyw.master.entity")
//                .persistenceUnit("primaryPersistenceUnit")
//                .build();
//    }
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    private Map <String, Object> getVendorProperties(DataSource dataSource) {
//        return jpaProperties.getHibernateProperties((HibernateSettings) dataSource);
//    }
//
//    @Primary
//    @Bean(name = "transactionManagerPrimary")
//    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
//    }
//
//}
