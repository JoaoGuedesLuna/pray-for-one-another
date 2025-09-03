package dev.guedes.prayforoneanother.utils.swing;

/**
 * Enumeration representing the available Swing Look and Feel themes.
 * Provides the class names for each supported Look and Feel implementation.
 *
 * @author João Guedes
 */
public enum LookAndFeelType {
    /**
     * The cross-platform Metal Look and Feel (also known as Java Look and Feel)
     */
    METAL("javax.swing.plaf.metal.MetalLookAndFeel"),

    /**
     * The Nimbus Look and Feel, a modern skinnable look and feel
     */
    NIMBUS("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"),

    /**
     * The Windows Look and Feel, mimics the native Windows appearance
     */
    WINDOWS("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"),

    /**
     * The classic Windows Look and Feel (Windows 95/98/2000 style)
     */
    WINDOWS_CLASSIC("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"),

    /**
     * The Motif Look and Feel, based on the OSF/Motif style
     */
    MOTIF("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

    private final String className;

    LookAndFeelType(String className) { this.className = className; }

    public String getClassName() { return className; }
}
