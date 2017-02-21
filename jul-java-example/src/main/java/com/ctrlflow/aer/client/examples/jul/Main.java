package com.ctrlflow.aer.client.examples.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * The logger used to report any log messages.
     * 
     * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/logging/"><code>java.util.logging</code> manual</a>
     */
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            // No error report will be send for this message, as its log level is only INFO.
            LOG.info("Application started.");

            throw new IllegalArgumentException("invalid");
        } catch (Exception e) {
            // An error report (including a stack trace) will be send for this message, as its log level is SEVERE.
            LOG.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
