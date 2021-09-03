package entities;

import authentication.AuthenticationUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class Hooks {
    private static Logger LOGGER = Logger.getLogger(Hooks.class);

    @BeforeSuite
    public void setup(){
        LOGGER.info("Getting Session ID ...");
        String sessionId = AuthenticationUtils.getSessionId();
        LOGGER.info("sessionId = " + sessionId);
    }
}
