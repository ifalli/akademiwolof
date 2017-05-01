package org.akaademiwolof;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Ibrahima Fall
 *
 */

//@Configuration
//@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
//@EnableJpaRepositories(basePackages = {"org.akademiwolof"})
@EnableTransactionManagement
public class PersistenceContext {

	/*@Bean
    NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }*/
}
