package com.wzy.log_system.filter;

import com.alibaba.fastjson.JSONObject;
import com.wzy.log_system.entity.Result;
import com.wzy.log_system.utils.JwtUtils;
import io.netty.util.internal.StringUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if (uri.equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        //验证非登录请求

        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头中token为空");
            Result error = Result.error("NOT_LOGIN");
            //利用fastjson手动转换json，返回
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        //校验JWT
        try{
            JwtUtils.parseJwt(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }
        //放行
        log.info("校验成功，放行");
        filterChain.doFilter(request, response);

    }
}
