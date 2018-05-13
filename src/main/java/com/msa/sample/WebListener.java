package com.msa.sample;

import com.msa.sample.registry.ServiceRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * The type Web listener.
 *
 * @class:WebListener
 * @description:描述
 * @author:sxp
 * @date:2018/4/22 16 :20
 */
@Slf4j
@Component
public class WebListener implements ServletContextListener {
    /**
     * The Env.
     */
    @Autowired
    private Environment env;

    /**
     * The Service registry.
     */
    @Autowired
    private ServiceRegistry serviceRegistry;

    /**
     * The Port.
     */
    @Value("${server.port:8080}")
    private int port;

    /**
     * 服务注册
     * Context initialized.
     *
     * @param servletContextEvent the servlet context event
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext = WebApplicationContextUtils
                .getRequiredWebApplicationContext(servletContextEvent.getServletContext());
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> infoMap = mapping.getHandlerMethods();
        try {
            final String ip = InetAddress.getLocalHost().getHostAddress();
            infoMap.forEach((requestMappingInfo, handlerMethod) -> {
                String serviceName = requestMappingInfo.getName();
                // 注册服务
                if (!StringUtils.isEmpty(serviceName)) {
                    serviceRegistry.registry(serviceName, String.format("%s:%d", ip, port));
                }
            });
        } catch (UnknownHostException e) {
            log.error("get local host failure", e);
        }
    }

    /**
     * Context destroyed.
     *
     * @param servletContextEvent the servlet context event
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
