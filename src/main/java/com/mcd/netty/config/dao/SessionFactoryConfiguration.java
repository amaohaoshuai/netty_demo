package com.mcd.netty.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
* @Description: 数据库会话配置
* @Author: amao
* @CreateDate: 2019/1/15 11:04
*/
//表明这是一个配置类
@Configuration
public class SessionFactoryConfiguration {
    //读取mybatis全局配置文件
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    //读取数据库设置
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;
    //读取实体类包路径
    @Value("${entity_package}")
    private String entityPackage;
    //读取映射文件的路径
    @Value("${mapper_path}")
    private String mapperPath;

    //使用spring工厂类创建会话
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}

