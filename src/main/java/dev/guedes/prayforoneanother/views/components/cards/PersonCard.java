package dev.guedes.prayforoneanother.views.components.cards;

import dev.guedes.prayforoneanother.views.factories.UIComponentFactory;
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
    private final JPanel containerPanel;
    private final List<String> peopleList;
    private final JLabel nameLabel;

    public PersonCard(JPanel containerPanel, List<String> peopleList, String name) {
        super(new BorderLayout(5, 5));

        this.containerPanel = containerPanel;
        this.peopleList = peopleList;

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true)
        ));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        setPreferredSize(new Dimension(200, 45));

        this.nameLabel = createNameLabel(name);
        JPanel buttonsPanel = createButtonsPanel();

        add(nameLabel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.EAST);
    }

    private JLabel createNameLabel(String personName) {
        JLabel label = new JLabel(personName);
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        return label;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JButton editButton   = UIComponentFactory.createButton("Edit", e -> onEditPerson());
        JButton deleteButton = UIComponentFactory.createButton("Delete", e -> onDeletePerson());

        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);

        return buttonsPanel;
    }

    private void onEditPerson() {
        String currentName = getPersonName();
        String newName = showEditNameDialog(currentName);

        if (isValidNameChange(newName, currentName)) {
            updatePersonName(currentName, newName);
        }
    }

    private void onDeletePerson() {
        peopleList.remove(getPersonName());
        containerPanel.remove(this);
        containerPanel.revalidate();
        containerPanel.repaint();
    }

    private String showEditNameDialog(String currentName) {
        return (String) JOptionPane.showInputDialog(
                containerPanel,
                "Name:",
                "Edit",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                currentName
        );
    }

    private boolean isValidNameChange(String newName, String currentName) {
        if (newName == null) return false;
        newName = newName.trim();
        return !newName.isEmpty() && !newName.equals(currentName);
    }

    private void updatePersonName(String oldName, String newName) {
        int index = peopleList.indexOf(oldName);
        if (index >= 0) {
            peopleList.set(index, newName);
            setPersonName(newName);
        }
    }

    private String getPersonName() { return nameLabel.getText(); }
    private void setPersonName(String newName) { nameLabel.setText(newName); }
}
