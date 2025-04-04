package com.rekrutacja.tomasz.cli;

import java.nio.file.Path;
import java.util.concurrent.Callable;

import com.rekrutacja.tomasz.service.*;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ScopeType;

@Command(mixinStandardHelpOptions = true, subcommands = DownloadCommand.class)
public class CliCommands implements Callable<Integer> {

    @Option(names = "--verbose", scope = ScopeType.INHERIT)
    private void verbose(boolean[] verbose) {
        System.out.println("\nVERBOSE\n");
    }

    @Override
    public Integer call() {
        System.out.println("Specify subcmd");
        System.out.println("Call with --help");
        return 0;
    }
}

@Command(name = "download", mixinStandardHelpOptions = true)
class DownloadCommand implements Callable<Integer> {

    @Option(names = { "-d", "--directory" }, description = "Specify output directory for saved posts")
    private Path directory;

    @Override
    public Integer call() throws Exception {
        JsonplaceholderApiClient client = new JsonplaceholderApiClient();
        PostService service = new JsonplaceholderPostsService(client);
        var posts = service.getPosts();
        return 0;
    }

}
