package com.jayway.travelway8.backend;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BackendApplication extends Application<BackendConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BackendApplication().run(args);
    }

    @Override
    public String getName() {
        return "Backend";
    }

    @Override
    public void initialize(final Bootstrap<BackendConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final BackendConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
