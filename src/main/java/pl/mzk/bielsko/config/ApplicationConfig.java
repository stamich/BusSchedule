package pl.mzk.bielsko.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Klasa konfiguracji Beanow Springa.
 * @author Michal Stawarski
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.mzk.bielsko")
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    /**
     * Metoda konfiguracji resolwera widokow Springa.
     * @return viewResolver
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    /**
     * Metoda konfigracji modulu obslugujacego powiadomienia w widokach.
     * @return messageSource
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    /**
     * Metoda konfigracji(przeslaniajaca) mapowania zasobow dodatkowych takich jak pliki css czy tez js.
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/theme1/css/**").addResourceLocations("/resources/theme1/css/");
        registry.addResourceHandler("/resources/theme1/js/**").addResourceLocations("/resources/theme1/js/");
    }

    /**
     * Metoda konfigracji(przeslaniajaca) walidatora.
     * @return validator
     */
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    /**
     * Metoda konfigracji frameworka Apache Tiles 3.
     * @return tilesConfigurer
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**
     * Metoda konfigurujaca(przeslaniajaca) resolwer widokow Apache Tiles 3.
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
}
