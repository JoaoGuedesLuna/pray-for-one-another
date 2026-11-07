package dev.guedes.prayforoneanother.views;

import com.google.inject.Inject;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import java.util.ArrayList;
import java.util.List;

import dev.guedes.prayforoneanother.services.PrayerDrawService;
import dev.guedes.prayforoneanother.views.components.frames.Frame;
import dev.guedes.prayforoneanother.views.components.panels.DrawPanel;
import dev.guedes.prayforoneanother.views.components.panels.PeoplePanel;

import static dev.guedes.prayforoneanother.views.styles.Dimensions.MAIN_VIEW_HEIGHT;
import static dev.guedes.prayforoneanother.views.styles.Dimensions.MAIN_VIEW_WIDTH;
import static dev.guedes.prayforoneanother.views.styles.Metadata.APP_TITLE;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : MainView.java
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
public class MainView extends Frame implements View {
    @Inject
    public MainView(PrayerDrawService prayerDrawService) {
        super(APP_TITLE, MAIN_VIEW_WIDTH, MAIN_VIEW_HEIGHT, WindowConstants.EXIT_ON_CLOSE);

        List<String> peopleList = new ArrayList<>();

        JPanel leftPanel = new PeoplePanel(peopleList);
        JPanel rightPanel = new DrawPanel(prayerDrawService, peopleList);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation((int) (MAIN_VIEW_WIDTH / 2.5));

        this.add(splitPane);
    }

    @Override
    public void display() { setVisible(true); }
}
