package dev.guedes.prayforoneanother;

import javax.swing.SwingUtilities;
import java.util.logging.Logger;

import dev.guedes.prayforoneanother.utils.swing.LookAndFeelManager;
import dev.guedes.prayforoneanother.utils.swing.LookAndFeelType;
import dev.guedes.prayforoneanother.views.View;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : Application.java
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
public class Application {
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    private Application() {}

    public static void run(String[] args) {
        configureLookAndFeel();
        displayMainView();
    }

    private static void configureLookAndFeel() {
        try {
            LookAndFeelManager.setLookAndFeel(LookAndFeelType.WINDOWS);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    private static void displayMainView() {
        SwingUtilities.invokeLater(() -> ApplicationInjector.getInstance(View.class).display());
    }
}
