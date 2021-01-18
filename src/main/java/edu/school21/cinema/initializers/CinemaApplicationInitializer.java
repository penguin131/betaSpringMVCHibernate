package edu.school21.cinema.initializers;

import edu.school21.cinema.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class CinemaApplicationInitializer implements WebApplicationInitializer {
    private static final String TMP_FOLDER = "/tmp";
    private static final int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
        dispatcher.setLoadOnStartup(1);
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
                MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
        dispatcher.setMultipartConfig(multipartConfigElement);
        dispatcher.addMapping("/");
    }
}
