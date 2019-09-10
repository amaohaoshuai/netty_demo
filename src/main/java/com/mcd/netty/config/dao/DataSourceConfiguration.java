package com.mcd.netty.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
* @Description: 数据库连接配置
* @Author: amao
* @CreateDate: 2019/1/15 10:48
*/
//表明这是一个配置类
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.mcd.netty.dao")
public class DataSourceConfiguration {
    //引用yml文件驱动类型
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    //引用yml文件数据库路径
    @Value("${jdbc.url}")
    private String jdbcUrl;
    //引用yml文件用户名
    @Value("${jdbc.username}")
    private String jdbcUsername;
    //引用yml文件密码
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        //创建dataSouce
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置驱动类型
        dataSource.setDriverClass(jdbcDriver);
        //设置数据库路径
        dataSource.setJdbcUrl(jdbcUrl);
        //设置用户名
        dataSource.setUser(jdbcUsername);
        //设置密码
        dataSource.setPassword(jdbcPassword);
        // 关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
