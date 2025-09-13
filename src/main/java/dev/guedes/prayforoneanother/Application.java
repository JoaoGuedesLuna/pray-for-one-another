package dev.guedes.prayforoneanother;

import dev.guedes.prayforoneanother.utils.swing.LookAndFeelType;
import dev.guedes.prayforoneanother.utils.swing.SwingLookAndFeelManager;
import dev.guedes.prayforoneanother.views.MainView;
import dev.guedes.prayforoneanother.views.View;
import javax.swing.SwingUtilities;

/**
 * Core application runner class that handles the main execution logic.
 * This class is designed to be statically accessed and cannot be instantiated.
 *
 * @author João Guedes
 */
public class Application {
    private Application() {}

    public static void run(String[] args) {
        configureLookAndFeel();
        startMainView();
    }

    private static void configureLookAndFeel() {
        try {
            SwingLookAndFeelManager.setLookAndFeel(LookAndFeelType.WINDOWS);
        } catch (Exception e) {
            System.err.println("Warning: Failed to set Windows Look and Feel. Using default.");
        }
    }

    private static void startMainView() {
        SwingUtilities.invokeLater(() -> {
            View view = new MainView();
            view.display();
        });
    }
}
