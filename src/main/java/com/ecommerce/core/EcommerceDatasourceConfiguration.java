package com.ecommerce.core;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.ecommerce.core",
        entityManagerFactoryRef = "ecommerceEntityManagerFactory",
        transactionManagerRef = "ecommerceTransactionManager")
public class EcommerceDatasourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.ecommerce")
    public DataSourceProperties ecommerceDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.ecommerce.configuration")
    public DataSource ecommerceDataSource() {
        DataSource dataSource = ecommerceDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
        return dataSource;
    }

    @Primary
    @Bean(name = "ecommerceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ecommerceEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ecommerceDataSource())
                .packages("com.ecommerce.core")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager ecommerceTransactionManager(
            final @Qualifier("ecommerceEntityManagerFactory") LocalContainerEntityManagerFactoryBean ecommerceEntityManagerFactory) {
        return new JpaTransactionManager(ecommerceEntityManagerFactory.getObject());
    }
}
