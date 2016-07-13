package com.ctrlflow.aer.client.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;

public class Main {

    /**
     * The logger used to report any log messages.
     * 
     * @see <a href="http://www.slf4j.org/manual.html">Simple Logging Facade for Java (SLF4J) manual</a>
     */
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            // No error report will be send for this message, as its log level is only INFO.
            LOG.info("Application started.");

            throw new NullPointerException();
        } catch (Exception e) {
            // An error report (including a stack trace) will be send for this message, as its log level is ERROR.
            LOG.error("An error occurred", e);
        } finally {
            // Send any outstanding error reports at shutdown.
            flushSendQueue();
        }
    }

    /**
     * Flushes the logger's send queue.
     * 
     * This must be triggered explicitly as error reports are configured to be send asynchronously.
     * 
     * @see <a href="http://logback.qos.ch/manual/configuration.html#stopContext">Stopping logback-classic</a>
     */
    private static void flushSendQueue() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.stop();
    }
}
