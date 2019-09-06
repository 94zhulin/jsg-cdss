package com.jsg.db.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.jsg.dao.sqlserver", sqlSessionFactoryRef = "sqlserverSqlSessionFactory")
public class SQLServerDataSourceConfig {

    @Primary
    @Bean(name = "sqlserverDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "sqlserverTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("sqlserverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);

    }

    @Primary
    @Bean(name = "sqlserverSqlSessionFactory")
    public SqlSessionFactory basicSqlSessionFactory(@Qualifier("sqlserverDataSource") DataSource basicDataSource)
            throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(basicDataSource);
        factoryBean.setTypeAliasesPackage("com.jsg.dao.sqlserver");
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapping/sqlserver/*.xml"));
        return factoryBean.getObject();
    }

    @Primary
    @Bean(name = "sqlserverSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
