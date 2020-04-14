package spring;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
	import org.springframework.core.io.ClassPathResource;


	/**
	 * Spring Configuration class representing hooks for Property sources using application.yml.
	 */
	@Configuration
	public class AppConfig {

	    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	    @Bean
	    public static YamlPropertiesFactoryBean propertyFactoryBean() {
	        logger.debug("Creating Bean YamlPropertiesFactoryBean");
	        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
	        yaml.setResources(new ClassPathResource("application.yml"));
	        String activeProfile =  System.getProperty("spring.profiles.active");
	        yaml.setDocumentMatchers(activeProfile != null ? new SpringProfileDocumentMatcher(activeProfile): new SpringProfileDocumentMatcher());
	        logger.info("*********** activeProfile : "+activeProfile);
	        return yaml;
	    }

	    @Bean
	    public static PropertySourcesPlaceholderConfigurer properties() {
	        logger.debug("Creating Bean PropertySourcesPlaceholderConfigurer");
	        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
	        YamlPropertiesFactoryBean yaml = propertyFactoryBean();
	        //YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
	        //yaml.setResources(new ClassPathResource("application.yml"));
	        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
	        return propertySourcesPlaceholderConfigurer;
	    }
	}

