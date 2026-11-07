package dev.guedes.prayforoneanother.views.components.cards;

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

import dev.guedes.prayforoneanother.views.factories.UIComponentFactory;

import static dev.guedes.prayforoneanother.views.styles.Dimensions.PERSON_CARD_HEIGHT;
import static dev.guedes.prayforoneanother.views.styles.Dimensions.PERSON_CARD_WIDTH;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PersonCard.java
 * Created on : 2026-11-05 17:00
 * Last modified: 2026-11-05 17:00
 *
 * Author : João Guedes
 * GitHub : https://github.com/JoaoGuedesLuna
 *
 * Copyright (c) 2026 João Guedes. All Rights Reserved.
 * Licensed under the MIT License.
 *
 * https://opensource.org/licenses/MIT
 */
public class PersonCard extends JPanel {
    private final JPanel containerPanel;
    private final List<String> peopleList;
    private final JLabel nameLabel;

    public PersonCard(JPanel containerPanel, List<String> peopleList, String name) {
        super(new BorderLayout(5, 5));

        this.containerPanel = containerPanel;
        this.peopleList = peopleList;

        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true)
        ));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, PERSON_CARD_HEIGHT));
        this.setPreferredSize(new Dimension(PERSON_CARD_WIDTH, PERSON_CARD_HEIGHT));

        this.nameLabel = createNameLabel(name);
        JPanel buttonsPanel = createButtonsPanel();

        this.add(nameLabel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.EAST);
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

        if (!isValidNameChange(newName, currentName)) return;

        updatePersonName(currentName, newName);
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

        if (index < 0) return;

        peopleList.set(index, newName);
        setPersonName(newName);
    }

    private String getPersonName() { return nameLabel.getText(); }
    private void setPersonName(String newName) { nameLabel.setText(newName); }
}
