package com.ctrlflow.aer.client.examples.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    /**
     * The logger used to report any log messages.
     * 
     * @see <a href="https://logging.apache.org/log4j/2.x/manual/">Log4j 2 manual</a>
     */
    private static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            // No error report will be send for this message, as its log level is only INFO.
            LOG.info("Application started.");

            throw new IllegalArgumentException("invalid");
        } catch (Exception e) {
            // An error report (including a stack trace) will be send for this message, as its log level is ERROR.
            LOG.error("An error occurred", e);
        }
    }
}
