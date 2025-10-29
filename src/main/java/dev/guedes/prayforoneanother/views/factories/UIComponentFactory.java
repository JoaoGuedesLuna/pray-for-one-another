package dev.guedes.prayforoneanother.views.factories;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

/**
 * Utility class for creating and styling Swing components.
 *
 * @author João Guedes
 */
public final class UIComponentFactory {
    private UIComponentFactory() {
        throw new UnsupportedOperationException("UIComponentFactory is a utility class and cannot be instantiated.");
    }

    public static JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }

    public static JTextField createTextField(String text, ActionListener action) {
        JTextField textField = new JTextField(text);
        textField.addActionListener(action);
        return textField;
    }
}
