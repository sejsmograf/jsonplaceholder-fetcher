package com.tomasz.rekrutacja.json_fetcher.exception;

import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;

public class CliExceptionResolver implements CommandExceptionResolver {

	@Override
	public CommandHandlingResult resolve(Exception ex) {
		System.err.println(ex.getMessage());
		System.exit(1);
		return null;
	}
}
