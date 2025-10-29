package dev.guedes.prayforoneanother.views;

import dev.guedes.prayforoneanother.views.components.frames.Frame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * Main application window for the program.
 * <p>
 * The window is divided into two panels:
 * <ul>
 *   <li>The panel on the left – manages the list of participants</li>
 *   <li>The panel on the right – performs and displays prayer assignments</li>
 * </ul>
 * </p>
 *
 * @author João Guedes
 */
public class MainView extends Frame implements View {
    public MainView() {
        super(700, 500);

        JPanel leftPanel = null;
        JPanel rightPanel = null;

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(300);

        add(splitPane);
    }

    @Override
    public void display() { setVisible(true); }
}
