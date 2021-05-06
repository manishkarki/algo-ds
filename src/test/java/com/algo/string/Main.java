package com.algo.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mkarki
 */
public class Main {
    // POJO to hold info for exceptionType
    static class ExceptionInformation {
        private int errorCode;
        private Severity severity;

        public ExceptionInformation(int errorCode, Severity severity) {
            this.errorCode = errorCode;
            this.severity = severity;
        }

        @Override
        public String toString() {
            return this.severity + "|" + this.errorCode + "|";
        }

    }

    enum Severity {
        High, Medium, Low
    }

    // map to hold exceptionType -> ExceptionInformation
    static void buildExceptionInformations(Map<String, ExceptionInformation> exceptionInformations) {
        exceptionInformations.put("IOException", new ExceptionInformation(100, Severity.High));
        exceptionInformations.put("MemoryException", new ExceptionInformation(110, Severity.High));
        exceptionInformations.put("ThreadAbortException", new ExceptionInformation(200, Severity.Medium));
        exceptionInformations.put("ResponseTimeoutException", new ExceptionInformation(300, Severity.Low));
        exceptionInformations.put("ParameterException", new ExceptionInformation(301, Severity.Low));
    }

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        // I/P
        // ThreadAbortException|
        // IOException|random message
        // O/P
        // Medium|200|ThreadAbortException|
        // High|100|IOException|random message
        Map<String, ExceptionInformation> exceptionInformations = new HashMap<>();
        buildExceptionInformations(exceptionInformations);
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            String[] message = line.split("\\|");
            String exception = message[0];
            ExceptionInformation exceptionInformation = exceptionInformations.get(exception);
            String output = exceptionInformation.toString() + line;
            System.out.println(output);
        }
    }
}
