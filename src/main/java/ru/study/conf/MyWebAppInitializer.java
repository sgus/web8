package ru.study.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return  new Class[] { JPAConfig.class, SecurityConfig.class };

    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return  new Class[] { AppConfig.class };
    }
}
