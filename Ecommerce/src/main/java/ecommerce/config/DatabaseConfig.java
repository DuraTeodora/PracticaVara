package ecommerce.config;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DatabaseConfig extends HikariConfig {

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(this);
    }

}
