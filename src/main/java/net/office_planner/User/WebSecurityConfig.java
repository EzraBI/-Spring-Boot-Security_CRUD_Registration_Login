package net.office_planner.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		auth.inMemoryAuthentication()
				.withUser("user").password("{noop}password").roles("USER")
				.and()
				.withUser("admin").password("{noop}password").roles("ADMIN");
	}


	@Autowired
	AuthenticationSuccessHandler successHandler;

//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("user").password("{noop}password").roles("USER")
//				.and()
//				.withUser("admin").password("{noop}password").roles("ADMIN");
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/images/**",
						"/", "/register", "./css/").permitAll()
				.antMatchers("/organizational_officer").hasAnyRole("USER")
				.antMatchers("/admin").hasAnyRole("ADMIN")
				.antMatchers("/list_room","/ListMeetings", "/list_organization"
						).hasAnyRole("USER")

				.antMatchers("/list_room","/ListMeetings","/list_organization",
						"/users","/admin", "User/list_users",
						"/organizational_officer", "/edit_user/{id}",
						"/delete_user/{id}", "/save_user", "/organizations",
						"/boardrooms").hasAnyRole("ADMIN")

				.antMatchers("/list_room","/ListMeetings","/list_organization",
						"/users","/admin", "User/list_users",
						"/organizational_officer", "/edit_user/{id}",
						"/delete_user/{id}", "/save_user", "/organizations",
						"/boardrooms").authenticated()
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.usernameParameter("email")
//				.defaultSuccessUrl("/organizational_officer")
				.successHandler(successHandler)

				.permitAll()
			.and()
			.logout().logoutSuccessUrl("/").permitAll();
	}
}

//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http
//				.csrf().disable()
//				.authorizeRequests()
//				.antMatchers("/user").hasAnyRole("USER")
//				.antMatchers("/admin").hasAnyRole("ADMIN")
//				.and().formLogin().loginPage("/login")
//				.successHandler(successHandler)
//				.permitAll()
//				.and().logout();
//	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/css/**", "/js/**", "/images/**",
//						"/", "/register", "./css/").permitAll()
//				.antMatchers("/users", "User/list_users",
//						"/organizational_officer", "/edit_user/{id}",
//						"/delete_user/{id}", "/save_user", "/organizations",
//						"/boardrooms", "/employees").authenticated()
//				.anyRequest().permitAll()
//				.and()
//				.formLogin()
//				.usernameParameter("email")
//				.defaultSuccessUrl("/organizational_officer")
//				.permitAll()
//				.and()
//				.logout().logoutSuccessUrl("/").permitAll();
//	}
