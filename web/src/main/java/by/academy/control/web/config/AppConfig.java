package by.academy.control.web.config;

import by.academy.control.web.security.SecurityConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "by.academy.control")
@PropertySource(value = {
        "classpath:database.properties",
        "classpath:messages.properties"
})
@Import({
        HibernateConfig.class,
        WebConfig.class,
        SecurityConfiguration.class
})
public class AppConfig {
}
