package com.hawkills.source.data.mult.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author hawkills
 */
@Configuration
@MapperScan(basePackages = PrimaryDataSourceConfiguration.MAPPER_SCAN_PACKAGE, sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class PrimaryDataSourceConfiguration {

    static final String MAPPER_SCAN_PACKAGE = "com.hawkills.source.data.mult.mapper.primary";
    static final String MAPPER_SCAN_LOCATION = "classpath:mybatis/mapper/primary/*.xml";

    @Value("${primary.datasource.url}")
    private String url;

    @Value("${primary.datasource.username}")
    private String username;

    @Value("${primary.datasource.password}")
    private String password;

    @Value("${primary.datasource.driver-class-name}")
    private String driverClassName;

    @Bean(name = "primaryDataSource")
    @Primary
    public DataSource getPrimaryDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

    /**
     * primary数据源(主数据源)
     * @param dataSource 数据源
     * @return SqlSessionFactory
     * @throws Exception 异常
     */
    @Primary
    @Bean("primarySqlSessionFactory")
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(PrimaryDataSourceConfiguration.MAPPER_SCAN_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "primarySqlSessionTemplate")
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
