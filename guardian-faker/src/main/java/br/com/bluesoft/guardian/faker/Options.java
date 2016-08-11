package br.com.bluesoft.guardian.faker;


import java.util.Collection;
import java.util.List;

public class Options {
    private final RandomService randomService;

    public Options(RandomService randomService) {
        this.randomService = randomService;
    }

    public <T> T option(T... options) {
        return options[randomService.nextInt(options.length)];
    }

    public <T> T option(List<T> options) {
        return options.get(randomService.nextInt(options.size()));
    }
}