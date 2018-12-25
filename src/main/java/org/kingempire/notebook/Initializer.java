package org.kingempire.notebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anurag Singh
 */
@Component
class Initializer implements CommandLineRunner {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
        LOG.debug("Not Implemented");
    }
}
