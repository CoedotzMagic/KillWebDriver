package com.coedotzmagic.killwebdriver;

public class Main {

    /**
     * <b>KillAllWebDriverProcess()</b>
     * Used to stop the webdriver process that is still running in task manager (windows) / activity monitor (macos/unix)
     *
     * <br><br>
     *
     * @since 1.0
     */
    public static void KillAllWebDriverProcess() {
        new KillProcessWebDriver();
    }
}
