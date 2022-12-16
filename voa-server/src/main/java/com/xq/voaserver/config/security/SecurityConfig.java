package com.xq.voaserver.config.security;

import com.xq.voaserver.config.security.component.JwtAuthenticationTokenFilter;
import com.xq.voaserver.config.security.component.RestAuthenticationEntryPoint;
import com.xq.voaserver.config.security.component.RestfulAccessDeniedHandler;
import com.xq.voaserver.pojo.Admin;
import com.xq.voaserver.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author xq
 * @Date 2022/12/12 11:59
 * @ClassName: SecurityConfig
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws
    Exception {

        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder())
        ;
    }
    /**
     * 配置 security 地址放行 授权地址
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //csrf 防护
        http.csrf()
                .disable()
                //session 管理进行关闭
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //设置 放行的地址
                .authorizeRequests()
                .antMatchers("/login","/logout")
                .permitAll()
                //所有的请求 必须通过认证
                .anyRequest()
                .authenticated()
                .and()
                //关闭 缓存
                .headers()
                .cacheControl();
        //添加 过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);

        //消息通知器
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
     //放行静态资源
     web.ignoring().antMatchers(
                 "/login",
                 "/logout",
                 "/css/**",
                 "/js/**",
                 "/index.html",
                 "/favicon.ico",
                 "/doc.html",
                 "/webjars/**",
                 "/swagger-resources/**",
                 "/v2/api-docs/**",
                 "/captcha");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            Admin admin = adminService.getAdminByUserName(username);
            if (null != admin) {
                return admin;
            }
            return null;
        };
    }
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }
}

