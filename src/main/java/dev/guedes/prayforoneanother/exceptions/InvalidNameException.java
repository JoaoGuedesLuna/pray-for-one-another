package dev.guedes.prayforoneanother.exceptions;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : InvalidNameException.java
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
public class InvalidNameException extends RuntimeException {
    public InvalidNameException() { super("Invalid name provided."); }
}
