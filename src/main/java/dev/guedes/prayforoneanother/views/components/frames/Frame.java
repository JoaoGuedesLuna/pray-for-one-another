package dev.guedes.prayforoneanother.views.components.frames;

import javax.swing.JFrame;
import java.awt.HeadlessException;
import java.awt.Toolkit;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : Frame.java
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
public class Frame extends JFrame {
    public Frame(String title, int width, int height, int closeOperation) throws HeadlessException {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/icon.png")));
        this.setTitle(title);
        this.setDefaultCloseOperation(closeOperation);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
    }
}
