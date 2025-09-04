package dev.guedes.prayforoneanother.utils.swing;

import dev.guedes.prayforoneanother.exceptions.LookAndFeelException;
import dev.guedes.prayforoneanother.exceptions.NullArgumentException;
import dev.guedes.prayforoneanother.validators.NotNullValidator;
import dev.guedes.prayforoneanother.validators.Validator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Utility class for managing Swing Look and Feel configurations.
 * Provides methods to set and manage the application's visual appearance.
 *
 * @author João Guedes
 */
public final class SwingLookAndFeelManager {
    private SwingLookAndFeelManager() {
        throw new UnsupportedOperationException("SwingLookAndFeelManager is a utility class and cannot be instantiated.");
    }

    public static void setLookAndFeel(LookAndFeelType lookAndFeelType) {
        try {
            Validator<Object> validator = NotNullValidator.getInstance();
            validator.validate(lookAndFeelType);

            applyLookAndFeel(lookAndFeelType);
        } catch (NullArgumentException | LookAndFeelException  e) {
            throw new LookAndFeelException("Error configuring Look and Feel. " + e.getMessage());
        }
    }

    private static void applyLookAndFeel(LookAndFeelType lookAndFeelType) {
        try {
            UIManager.setLookAndFeel(lookAndFeelType.getClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new LookAndFeelException("Failed to apply Look and Feel: " + lookAndFeelType.name());
        }
    }
}
