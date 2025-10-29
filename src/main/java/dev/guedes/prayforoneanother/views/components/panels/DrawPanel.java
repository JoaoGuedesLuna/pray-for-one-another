package dev.guedes.prayforoneanother.views.components.panels;

import dev.guedes.prayforoneanother.models.PrayerPair;
import dev.guedes.prayforoneanother.services.PrayerDrawService;
import dev.guedes.prayforoneanother.views.factories.UIComponentFactory;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
    private final transient PrayerDrawService prayerDrawService;
    private final DefaultListModel<String> listModel;

    public DrawPanel(PrayerDrawService prayerDrawService, List<String> peopleList) {
        this.prayerDrawService = prayerDrawService;

        setLayout(new BorderLayout());

        JButton drawButton = UIComponentFactory.createButton("Draw", e -> onDraw(peopleList));

        listModel = new DefaultListModel<>();
        JList<String> resultList = new JList<>(listModel);
        resultList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        resultList.setFixedCellHeight(30);

        add(drawButton, BorderLayout.NORTH);
        add(new JScrollPane(resultList), BorderLayout.CENTER);
    }

    private void onDraw(List<String> people) {
        listModel.clear();

        if (people.size() < 2) {
            listModel.addElement("Add at least two people.");
            return;
        }

        List<PrayerPair> prayerPairs = prayerDrawService.drawPrayerAssignments(people);
        for (PrayerPair pair : prayerPairs) {
            listModel.addElement(pair.getPrayerPerson().getName() + " → " + pair.getRecipientPerson().getName());
        }
    }
}
