package com.rekrutacja.tomasz;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.rekrutacja.tomasz.cli.CliCommands;

import picocli.CommandLine;

public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int exitCode = new CommandLine(new CliCommands()).execute(args);
        System.exit(exitCode);
    }
}
