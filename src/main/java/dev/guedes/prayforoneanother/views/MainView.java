package dev.guedes.prayforoneanother.views;

import dev.guedes.prayforoneanother.ApplicationInjector;
import dev.guedes.prayforoneanother.services.PrayerDrawService;
import dev.guedes.prayforoneanother.views.components.frames.Frame;
import dev.guedes.prayforoneanother.views.components.panels.DrawPanel;
import dev.guedes.prayforoneanother.views.components.panels.PeoplePanel;
import javax.swing.JPanel;
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
public class MainView extends Frame implements View {
    public MainView() {
        super(700, 500);

        PrayerDrawService prayerDrawService = ApplicationInjector.getInstance(PrayerDrawService.class);
        List<String> peopleList = new ArrayList<>();

        JPanel leftPanel = new PeoplePanel(peopleList);
        JPanel rightPanel = new DrawPanel(prayerDrawService, peopleList);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(300);

        add(splitPane);
    }

    @Override
    public void display() { setVisible(true); }
}
