package com.teddy.springconfig;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
@Configuration //表明是一个spring的配置文件
@ComponentScan(basePackages = "com.teddy.springconfig") //配置扫描包
@PropertySource(value = "classpath:dao-db.properties",ignoreResourceNotFound = true)//数据库配置文件，忽略数据库配置文件没有找到。

public class SpringConfig {
    //配置一个普通的bean
    @Bean
    public UserDao getUserDao(){
        return new UserDao();
    }

    //配置数据库连接池
    @Value("${jdbc.driver}")
    private String jdbcDriverClassName;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("jdbc.username")
    private String jdbcUsername;
    @Value("jdbc.password")
    private String jdbcPassword;

    //配置一个数据源,返回值默认就是这个bean，默认方法名就是这个bean的id。
    @Bean(destroyMethod = "close")
    public BoneCPDataSource boneCPDataSource(){
        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        boneCPDataSource.setDriverClass(jdbcDriverClassName);
        boneCPDataSource.setJdbcUrl(jdbcUrl);
        boneCPDataSource.setUsername(jdbcUsername);
        boneCPDataSource.setPassword(jdbcPassword);

        //检查数据库连接池中空闲连接间隔时间
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        //设置数据库中使用连接的最大存活时间
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        //每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        //每个分区最小的连接数
        boneCPDataSource.setMinConnectionsPerPartition(5);

        return boneCPDataSource;
    }
}
