package com.informixdb.informixdb.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;

public class DriverManagerDataSource {
    @Autowired
    private static Environment env;

    @Bean(name ="Informix")
    @Primary
    public static DataSource InformixDataSource()
    {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("cdata.jdbc.informix.InformixDriver");
        dataSourceBuilder.url("jdbc:informix:Server=10.0.1.2;Port=50000;User=admin;Password=admin;Database=test;");
        return dataSourceBuilder.build();
    }

    //@Override
    public void setEnvironment( final Environment environment) {
        env=environment;
    }
}
