package dev.guedes.prayforoneanother.components.panels;

import dev.guedes.prayforoneanother.components.cards.PersonCard;
import dev.guedes.prayforoneanother.components.buttons.Button;
import dev.guedes.prayforoneanother.components.textfields.TextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
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
public class PeoplePanel extends Panel {
    private final TextField nameField;
    private final Panel cardsPanel;
    private final List<String> people;

    public PeoplePanel(List<String> people) {
        this.people = people;

        setLayout(new BorderLayout());

        Panel inputPanel = new Panel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        nameField = new TextField();
        nameField.addActionListener(e -> onAddPerson());

        Button addButton = new Button("Add");
        addButton.addActionListener(e -> onAddPerson());

        inputPanel.add(nameField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        cardsPanel = new Panel();
        cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(15);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
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
