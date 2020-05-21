package org.pyrih.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring App Configuration
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.pyrih.web")
public class AppConfig {

    /**
     * Define Spring MVC View Resolver Bean
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * docker run --rm   --name pg-docker -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data  postgres
     * @return
     */

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        return driverManagerDataSource;
    }
}
