package ru.study.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.study")
@EnableTransactionManagement
public class JPAConfig {

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/web6_db?&useTimezone=true&serverTimezone=UTC&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory  // обертка над EntityManagerFactory. К ней будет спринг обращатся когда ему нужен будет EntityManager.
    (DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {  // при создании бина в этод метод будут переданы бины с той же конфигурации.
        Properties jpaProp = new Properties();
        jpaProp.put("hibernate.hbm2ddl.auto", "update");

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setJpaProperties(jpaProp);
        entityManagerFactory.setPackagesToScan("ru.study.model");

        return entityManagerFactory;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

        return adapter;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {  // будет управлять транзакциями
        return new JpaTransactionManager(emf);
    }

}
