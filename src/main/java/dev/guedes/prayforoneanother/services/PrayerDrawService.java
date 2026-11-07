package dev.guedes.prayforoneanother.services;

import java.util.List;

import dev.guedes.prayforoneanother.models.PrayerPair;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PrayerDrawService.java
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
public interface PrayerDrawService {
    List<PrayerPair> drawPrayerAssignments(List<String> names);
}
