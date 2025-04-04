package com.rekrutacja.tomasz.cli;

import java.nio.file.Path;
import java.util.concurrent.Callable;

import com.rekrutacja.tomasz.service.*;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(mixinStandardHelpOptions = true)
public class CliCommands implements Callable<Integer> {

    @Command(name = "download", mixinStandardHelpOptions = true)
    public Integer download(
            @Option(names = { "-d",
                    "--directory" }, description = "Specify output directory for saved posts") Path directory) {
        JsonplaceholderApiClient client = new JsonplaceholderApiClient();
        PostService service = new JsonplaceholderPostsService(client);
        var posts = service.getPosts();
        return 0;
    }

    @Override
    public Integer call() {
        System.out.println("Specify subcmd");
        System.out.println("Call with --help");
        return 0;
    }
}
