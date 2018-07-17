package com.andaily.web.context;

import com.andaily.infrastructure.ThreadLocalHolder;
import com.andaily.web.WebUtils;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Wrap the spring <i>CharacterEncodingFilter</i>, add retrieve client ip action
 * <p/>
 * <p/>
 * 扩展 默认的 CharacterEncodingFilter, 添加对IP 地址的获取
 *
 * @author Shengzhao Li
 */
public class HBCharacterEncodingFilter extends CharacterEncodingFilter {


    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        persistIp(request);
        super.doFilterInternal(request, response, filterChain);

    }

    /*
    * 将IP地址 放置在 ThreadLocal 中
    * */
    private void persistIp(HttpServletRequest request) {
        final String clientIp = WebUtils.retrieveClientIp(request);
        ThreadLocalHolder.clientIp(clientIp);
    }


}