package dev.guedes.prayforoneanother.components.cards;

import dev.guedes.prayforoneanother.components.buttons.Button;
import dev.guedes.prayforoneanother.components.labels.Label;
import dev.guedes.prayforoneanother.components.panels.Panel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.function.Consumer;

/**
 * A UI component representing a person as a card with a name label and action buttons.
 * <p>
 * Each {@code PersonCard} displays the person's name and provides "Edit" and "Delete" buttons
 * with customizable behavior via {@link Consumer} callbacks.
 * </p>
 *
 * @author João Guedes
 */
public class PersonCard extends Panel {
    private final Label nameLabel;

    public PersonCard(String name, List<String> people, Panel peoplePanel) {
        super(new BorderLayout(5, 5));

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true)
        ));

        setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        setPreferredSize(new Dimension(200, 45));

        nameLabel = new Label(name);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        Panel buttonsPanel = new Panel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        Button editButton = new Button("Edit");
        editButton.addActionListener(e -> onEditPerson(this, people, peoplePanel));

        Button deleteButton = new Button("Delete");
        deleteButton.addActionListener(e -> onDeletePerson(this, people, peoplePanel));

        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);

        add(nameLabel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.EAST);
    }

    public String getName() { return nameLabel.getText(); }
    public void setName(String newName) { nameLabel.setText(newName); }

    private void onEditPerson(PersonCard card, List<String> people, Panel peoplePanel) {
        String currentName = card.getName();

        String newName = (String) JOptionPane.showInputDialog(
                peoplePanel,
                "Name:",
                "Edit",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                currentName
        );

        if (newName == null) return;

        newName = newName.trim();
        if (newName.isEmpty() || newName.equals(currentName)) return;

        int index = people.indexOf(currentName);
        if (index >= 0) {
            people.set(index, newName);
            card.setName(newName);
        }
    }

    private void onDeletePerson(PersonCard card, List<String> people, Panel peoplePanel) {
        people.remove(card.getName());
        peoplePanel.remove(card);
        peoplePanel.revalidate();
        peoplePanel.repaint();
    }
}
