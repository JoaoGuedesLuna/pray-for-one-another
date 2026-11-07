package dev.guedes.prayforoneanother.utils.swing;

import org.junit.jupiter.api.Test;
import javax.swing.UIManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import dev.guedes.prayforoneanother.exceptions.LookAndFeelException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : LookAndFeelManagerTest.java
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
class LookAndFeelManagerTest {
    @Test
    void constructor_ShouldThrowUnsupportedOperationException() {
        Constructor<?>[] constructors = LookAndFeelManager.class.getDeclaredConstructors();
        constructors[0].setAccessible(true);

        InvocationTargetException ex = assertThrows(InvocationTargetException.class, constructors[0]::newInstance);
        assertInstanceOf(UnsupportedOperationException.class, ex.getCause());
    }

    @Test
    void setLookAndFeel_ShouldThrowLookAndFeelException_WhenLookAndFeelTypeIsNull() {
        assertThrows(
                LookAndFeelException.class,
                () -> LookAndFeelManager.setLookAndFeel(null),
                "Error configuring Look and Feel. "
        );
    }

    @Test
    void setLookAndFeel_ShouldThrowLookAndFeelException_WhenLookAndFeelClassNotFound() {
        String className = "non.existent.LookAndFeel";
        LookAndFeelType invalidType = mock(LookAndFeelType.class);

        when(invalidType.getClassName()).thenReturn(className);

        assertThrows(
                LookAndFeelException.class,
                () -> LookAndFeelManager.setLookAndFeel(invalidType),
                "Error configuring Look and Feel. Failed to apply Look and Feel: " + className
        );
    }

    @Test
    void setLookAndFeel_ShouldNotThrow_WhenValidLookAndFeel() {
        assertDoesNotThrow(() -> LookAndFeelManager.setLookAndFeel(LookAndFeelType.METAL));
        assertEquals(LookAndFeelType.METAL.getClassName(), UIManager.getLookAndFeel().getClass().getName());
    }
}
