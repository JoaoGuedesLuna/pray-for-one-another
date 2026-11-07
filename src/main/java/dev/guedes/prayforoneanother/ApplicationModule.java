package dev.guedes.prayforoneanother;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import dev.guedes.prayforoneanother.mappers.PersonMapper;
import dev.guedes.prayforoneanother.mappers.impl.PersonMapperImpl;
import dev.guedes.prayforoneanother.services.PrayerDrawService;
import dev.guedes.prayforoneanother.services.impl.PrayerDrawServiceImpl;
import dev.guedes.prayforoneanother.validators.NotBlankValidator;
import dev.guedes.prayforoneanother.validators.NotNullValidator;
import dev.guedes.prayforoneanother.validators.PersonNameValidator;
import dev.guedes.prayforoneanother.validators.ValidatorComposite;
import dev.guedes.prayforoneanother.views.MainView;
import dev.guedes.prayforoneanother.views.View;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : ApplicationModule.java
 * Created on : 2026-11-05 17:00
 * Last modified: 2026-11-05 17:00
 *
 * Author : João Guedes
 * GitHub : https://github.com/JoaoGuedesLuna
 *
 * Copyright (c) 2026 João Guedes. All Rights Reserved.
 * Licensed under the MIT License.
 *
 * https://opensource.org/licenses/MIT
 */
public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ValidatorComposite.class);
        bind(NotNullValidator.class).in(Singleton.class);
        bind(NotBlankValidator.class).in(Singleton.class);
        bind(PersonNameValidator.class).in(Singleton.class);

        bind(PersonMapper.class).to(PersonMapperImpl.class).in(Singleton.class);

        bind(PrayerDrawService.class).to(PrayerDrawServiceImpl.class).in(Singleton.class);

        bind(View.class).to(MainView.class).in(Singleton.class);
    }
}
