package com.uizhi.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-22
 * Time: 18:48
 */
@Component
public class MyUserDetailService implements UserDetailsService{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名:" + username);
        // 根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否被冻结
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是:"+password);
//        return new User(username, password,
//                true, true, true, true,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//        public User(String username, String password, boolean enabled,
//        boolean accountNonExpired, boolean credentialsNonExpired,
//        boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)

        //return new User(username,"123456",AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return new User(username,password,
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
