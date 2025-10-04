package dev.guedes.prayforoneanother;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import dev.guedes.prayforoneanother.validators.NotBlankValidator;
import dev.guedes.prayforoneanother.validators.NotNullValidator;
import dev.guedes.prayforoneanother.validators.ValidatorComposite;

/**
 * Guice configuration module for the application.
 * This module defines the bindings between interfaces and their concrete
 * implementations, enabling dependency injection across the application.
 *
 * @author João Guedes
 */
public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ValidatorComposite.class);
        bind(NotNullValidator.class).in(Singleton.class);
        bind(NotBlankValidator.class).in(Singleton.class);
    }
}
