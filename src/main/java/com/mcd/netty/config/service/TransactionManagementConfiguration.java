package com.mcd.netty.config.service;//package com.mcd.netty.config.service;


import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.jdbc.datasource.DataSourceTransactionManager;
        import org.springframework.transaction.PlatformTransactionManager;
        import org.springframework.transaction.annotation.EnableTransactionManagement;
        import org.springframework.transaction.annotation.TransactionManagementConfigurer;

        import javax.sql.DataSource;

/**
 * @Description: 事务配置类
 * @Author: amao
 * @CreateDate: 2018/10/18 16:43
 */
@Configuration
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer {

    @Autowired
    private DataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
