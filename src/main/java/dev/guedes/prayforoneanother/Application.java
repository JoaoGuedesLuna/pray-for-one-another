package dev.guedes.prayforoneanother;

import dev.guedes.prayforoneanother.utils.swing.LookAndFeelManager;
import dev.guedes.prayforoneanother.utils.swing.LookAndFeelType;
import java.util.logging.Logger;

/**
 * Core application runner class that handles the main execution logic.
 * This class is designed to be statically accessed and cannot be instantiated.
 *
 * @author João Guedes
 */
public class Application {
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    private Application() {}

    public static void run(String[] args) {
        configureLookAndFeel();
    }

    private static void configureLookAndFeel() {
        try {
            LookAndFeelManager.setLookAndFeel(LookAndFeelType.WINDOWS);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
