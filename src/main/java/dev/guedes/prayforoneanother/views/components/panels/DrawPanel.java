package dev.guedes.prayforoneanother.views.components.panels;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.List;

import dev.guedes.prayforoneanother.models.PrayerPair;
import dev.guedes.prayforoneanother.services.PrayerDrawService;
import dev.guedes.prayforoneanother.views.factories.UIComponentFactory;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : DrawPanel.java
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
public class DrawPanel extends JPanel {
    private final transient PrayerDrawService prayerDrawService;
    private final DefaultListModel<String> listModel;

    public DrawPanel(PrayerDrawService prayerDrawService, List<String> peopleList) {
        this.prayerDrawService = prayerDrawService;

        this.setLayout(new BorderLayout());

        JButton drawButton = UIComponentFactory.createButton("Draw", e -> onDraw(peopleList));

        listModel = new DefaultListModel<>();
        JList<String> resultList = new JList<>(listModel);
        resultList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        resultList.setFixedCellHeight(30);

        this.add(drawButton, BorderLayout.NORTH);
        this.add(new JScrollPane(resultList), BorderLayout.CENTER);
    }

    private void onDraw(List<String> people) {
        listModel.clear();

        if (people.size() < 2) {
            listModel.addElement("Add at least two people.");
            return;
        }

        List<PrayerPair> prayerPairs = prayerDrawService.drawPrayerAssignments(people);

        for (PrayerPair pair : prayerPairs) {
            listModel.addElement(pair.prayerPerson().name() + " → " + pair.recipientPerson().name());
        }
    }
}
