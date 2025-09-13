package dev.guedes.prayforoneanother.components.panels;

import dev.guedes.prayforoneanother.components.cards.PersonCard;
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
    private final List<String> people;
    private JTextField nameField;
    private JPanel cardsPanel;

    public PeoplePanel(List<String> people) {
        this.people = people;

        setLayout(new BorderLayout());

        JPanel personNameInputPanel = createPersonNameInputPanel();
        JScrollPane peopleNameScrollPane = createPeopleNameScrollPane();

        add(personNameInputPanel, BorderLayout.NORTH);
        add(peopleNameScrollPane, BorderLayout.CENTER);
    }

    private JPanel createPersonNameInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        nameField = new JTextField();
        nameField.addActionListener(e -> onAddPerson());

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> onAddPerson());

        inputPanel.add(nameField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        return inputPanel;
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
        String name = nameField.getText().trim();
        if (!name.isEmpty()) {
            nameField.setText("");
            people.add(name);
            cardsPanel.add(new PersonCard(name, people, cardsPanel));
            cardsPanel.revalidate();
            cardsPanel.repaint();
        }
    }
}
