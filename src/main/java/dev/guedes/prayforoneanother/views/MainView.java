package dev.guedes.prayforoneanother.views;

import dev.guedes.prayforoneanother.components.frames.Frame;
import dev.guedes.prayforoneanother.components.panels.DrawPanel;
import dev.guedes.prayforoneanother.components.panels.Panel;
import dev.guedes.prayforoneanother.components.panels.PeoplePanel;
import javax.swing.JSplitPane;
import java.util.ArrayList;
import java.util.List;

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
public class MainView extends Frame {
    public MainView() {
        super(700, 500);

        List<String> people = new ArrayList<>();

        Panel leftPanel = new PeoplePanel(people);
        Panel rightPanel = new DrawPanel(people);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(300);

        add(splitPane);
    }
}
