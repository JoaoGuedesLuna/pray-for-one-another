package dev.guedes.prayforoneanother.components.panels;

import dev.guedes.prayforoneanother.services.PrayerDrawService;
import javax.swing.JPanel;
import java.util.List;

/**
 * {@code DrawPanel} represents the panel responsible for performing
 * the prayer drawing and displaying the results in a list format.
 *
 * <p>This panel contains:
 * <ul>
 *   <li>A button to trigger the draw action</li>
 *   <li>A scrollable list to display the generated prayer pairs</li>
 * </ul>
 *
 * <p>It relies on {@link PrayerDrawService} to handle the draw logic.
 *
 * @author João Guedes
 */
public class DrawPanel extends JPanel {
    public DrawPanel(List<String> people) {}
}
