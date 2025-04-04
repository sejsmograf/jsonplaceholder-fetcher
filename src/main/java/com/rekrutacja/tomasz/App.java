package com.rekrutacja.tomasz;


import com.rekrutacja.tomasz.cli.CliCommands;

import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CliCommands()).execute(args);
        System.exit(exitCode);
    }
}
