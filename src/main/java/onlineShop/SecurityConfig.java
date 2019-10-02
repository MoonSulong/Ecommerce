package onlineShop;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				   .formLogin()
				   .loginPage("/login")
				   .and()
				   .authorizeRequests()
				   .antMatchers("/cart/**")
				   .hasAuthority("ROLE_USER")
				   .antMatchers("/get*/**")
				   .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
				   .antMatchers("/admin*/**")
				   .hasAuthority("ROLE_ADMIN")
				   .anyRequest().permitAll().and().logout()
				   .logoutUrl("/logout");

	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sulong@gmail.com").password("2222").authorities("ROLE_ADMIN");

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT emailId, password, enabled FROM users WHERE emailId=?")
				.authoritiesByUsernameQuery("SELECT emailId, authorities FROM authorities WHERE emailId=?");

	}

}
