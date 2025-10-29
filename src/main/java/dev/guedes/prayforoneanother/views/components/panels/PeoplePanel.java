package dev.guedes.prayforoneanother.views.components.panels;

import com.google.inject.Inject;
import dev.guedes.prayforoneanother.views.factories.UIComponentFactory;
import dev.guedes.prayforoneanother.views.components.cards.PersonCard;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.util.List;

/**
 * Panel that manages a list of people in the application.
 * <p>
 * Provides an input field and button to add new participants.
 * </p>
 *
 * @author João Guedes
 */
public class PeoplePanel extends JPanel {
    private final List<String> peopleList;
    private JTextField nameField;
    private JPanel cardsPanel;

    @Inject
    public PeoplePanel(List<String> peopleList) {
        this.peopleList = peopleList;

        setLayout(new BorderLayout());

        JPanel nameInputPanel = createNameInputPanel();
        JScrollPane peopleNameScrollPane = createPeopleNameScrollPane();

        add(nameInputPanel, BorderLayout.NORTH);
        add(peopleNameScrollPane, BorderLayout.CENTER);
    }

    private JPanel createNameInputPanel() {
        JPanel nameInputPanel = new JPanel(new BorderLayout(5, 5));
        nameInputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        this.nameField    = UIComponentFactory.createTextField(null, e -> onAddPerson());
        JButton addButton = UIComponentFactory.createButton("Add", e -> onAddPerson());

        nameInputPanel.add(nameField, BorderLayout.CENTER);
        nameInputPanel.add(addButton, BorderLayout.EAST);

        return nameInputPanel;
    }

    private JScrollPane createPeopleNameScrollPane() {
        cardsPanel = new JPanel();
        cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));

        JScrollPane peopleNameScrollPane = new JScrollPane(cardsPanel);
        peopleNameScrollPane.setBorder(BorderFactory.createEmptyBorder());
        peopleNameScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        peopleNameScrollPane.getHorizontalScrollBar().setUnitIncrement(15);

        return peopleNameScrollPane;
    }

    private void onAddPerson() {
        String name = getPersonName();
        if (!name.isEmpty()) {
            nameField.setText("");
            peopleList.add(name);
            cardsPanel.add(new PersonCard(cardsPanel, peopleList, name));
            cardsPanel.revalidate();
            cardsPanel.repaint();
        }
    }

    private String getPersonName() { return nameField.getText().trim(); }
}
