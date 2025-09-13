package dev.guedes.prayforoneanother.components.cards;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class PersonCard extends JPanel {
    private final List<String> people;
    private final JPanel peoplePanel;
    private final JLabel nameLabel;

    public PersonCard(String name, List<String> people, JPanel peoplePanel) {
        super(new BorderLayout(5, 5));

        this.people = people;
        this.peoplePanel = peoplePanel;

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true)
        ));

        setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        setPreferredSize(new Dimension(200, 45));

        nameLabel = new JLabel(name);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JPanel buttonsPanel = createButtonsPanel();

        add(nameLabel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.EAST);
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(e -> onEditPerson());

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> onDeletePerson());

        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);

        return buttonsPanel;
    }

    private void onEditPerson() {
        String currentName = getPersonName();

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
            setPersonName(newName);
        }
    }

    private void onDeletePerson() {
        people.remove(getPersonName());
        peoplePanel.remove(this);
        peoplePanel.revalidate();
        peoplePanel.repaint();
    }

    private String getPersonName() { return nameLabel.getText(); }
    private void setPersonName(String newName) { nameLabel.setText(newName); }
}
