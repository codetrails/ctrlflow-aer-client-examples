package com.ctrlflow.aer.client.examples.simple;

import java.io.IOException;

import com.ctrlflow.aer.client.dto.Incident;
import com.ctrlflow.aer.client.simple.IncidentBuilder;
import com.ctrlflow.aer.client.simple.SimpleAerClient;

public class Main {

    private static final String AER_SUBMISSION_URL = "https://demo.ctrlflow.com/community/new";

    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException("invalid");
        } catch (Exception e) {
            sendErrorReport("An error occured", e);
        }

        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> sendErrorReport("Uncaught exception", e));
        // This exception will be reported automatically by the uncaught exception handler.
        throw new IllegalArgumentException("invalid");
    }

    private static void sendErrorReport(String message, Throwable e) {
        try {
            Incident incident = IncidentBuilder.from(e)
                    // The product ID and version are required for an incident to be accepted by the server.
                    .withProductId("com.ctrlflow.aer.client.examples.simple")
                    .withProductVersion("1.0.0")
                    // Other properties of the incident (e.g., the log message) are optional;
                    // they are available through additional with* methods of the IncidentBuilder.
                    .withLogMessage(message).build();
            // Send the incident *synchronously* to the server.
            SimpleAerClient.send(incident, AER_SUBMISSION_URL);
        } catch (IOException ignored) {
        }
    }
}
