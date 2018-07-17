package com.andaily.web.context;

import com.andaily.domain.shared.Application;
import com.andaily.domain.shared.BeanProvider;
import com.andaily.infrastructure.DateUtils;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * 扩展 Spring Context 的容器初始化
 *
 * @author Shengzhao Li
 */
public class BeanContextLoaderListener extends ContextLoaderListener {


    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
        BeanProvider.initialize(applicationContext);

        initialContextParams(event.getServletContext());
    }

    /*
    * 向 ServletContext 中添加全局 系统变量
    * */
    private void initialContextParams(ServletContext servletContext) {
        servletContext.setAttribute("startupDate", DateUtils.now());
        servletContext.setAttribute("projectHome", Application.PROJECT_HOME);
        servletContext.setAttribute("currentVersion", Application.CURRENT_VERSION);
    }
}