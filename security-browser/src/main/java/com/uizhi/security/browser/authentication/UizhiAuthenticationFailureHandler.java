package com.uizhi.security.browser.authentication;

import com.alibaba.fastjson.JSON;
import com.uizhi.security.core.properties.BrowserProperties;
import com.uizhi.security.core.properties.LoginType;
import com.uizhi.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(value = "uizhiAuthenticationFailureHandler")
public class UizhiAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private SecurityProperties securityProperties;
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {
        logger.info("登陆失败");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(JSON.toJSONString(e));
        }else{
            super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
        }


    }
}
