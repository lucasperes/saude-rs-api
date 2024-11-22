package br.gov.rs.saude.api.saude.api.core.config.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Classe Config para configurar o Resource Bundle
 */
@Configuration
public class ResourceBundleConfig {

	@Bean("bundleMessageSource")
    ReloadableResourceBundleMessageSource bundleMessageSource() {
		ReloadableResourceBundleMessageSource resourceBundle = new ReloadableResourceBundleMessageSource();
        resourceBundle.setBasenames("classpath:i18n/global/messages", "classpath:i18n/messages");
        resourceBundle.setDefaultEncoding("UTF-8");
        resourceBundle.setUseCodeAsDefaultMessage(true);
        return resourceBundle;
    }
	
}
