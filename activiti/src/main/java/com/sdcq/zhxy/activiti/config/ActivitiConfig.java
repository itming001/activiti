package com.sdcq.zhxy.activiti.config;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * activiti的配置文件
 */
@Configuration
public class ActivitiConfig {
   @Resource
    DataSource dataSource;
   //创建activiti的实例对象
   @Bean
   public ProcessEngineConfiguration processEngineConfiguration() {
       ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
       //配置数据源
       configuration.setDataSource(dataSource);
       //如果表不存在就创建
       configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
       //关闭计时器
       configuration.setAsyncExecutorActivate(false);
       return configuration;
   }
   //得到程序执行引擎
    @Bean
    public ProcessEngine processEngine() {
        return processEngineConfiguration().buildProcessEngine();
    }

}

