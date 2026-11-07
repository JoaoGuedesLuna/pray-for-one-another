package dev.guedes.prayforoneanother.views.factories;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : UIComponentFactory.java
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
