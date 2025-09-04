package dev.guedes.prayforoneanother.components.frames;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.HeadlessException;
import java.awt.Toolkit;

/**
 * A reusable frame class for the application.
 *
 * @author João Guedes
 */
public class Frame extends JFrame {
    public Frame(int width, int height) throws HeadlessException {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        setTitle("Pray for One Another");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
    }
}
