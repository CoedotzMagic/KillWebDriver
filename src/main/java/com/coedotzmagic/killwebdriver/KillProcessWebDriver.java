package com.coedotzmagic.killwebdriver;

import java.io.IOException;

/*
 * write by Coedotz
 * 14-02-2025
 */

public class KillProcessWebDriver {
    private static final String FAILED_TO_KILL_PROCESS = "Failed to Kill Process WebDriver, please try again... msg: . ";

    public KillProcessWebDriver() {
       this.killWebDriverProcesses();
   }

    private void killWebDriverProcesses() {
        try {
            // Windows
            if (isWindows()) {
                String[] processNames = {
                        "chromedriver.exe",
                        "geckodriver.exe",
                        "msedgedriver.exe",
                        "IEDriverServer.exe",
                        "safaridriver.exe"
                };
                for (String process : processNames) {
                    killProcessOnWindows(process);
                }
            }
            // Linux/macOS
            else if (isUnix()) {
                String[] processNames = {
                        "chromedriver",
                        "geckodriver",
                        "msedgedriver",
                        "safaridriver",
                        "IEDriverServer"
                };
                for (String process : processNames) {
                    killProcessOnUnix(process);
                }
            }
        } catch (IOException e) {
            System.out.println(FAILED_TO_KILL_PROCESS + e.getMessage());
            System.out.println("Error: " + e.getClass().getName() + " - " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    private static boolean isUnix() {
        return System.getProperty("os.name").toLowerCase().contains("nix") ||
                System.getProperty("os.name").toLowerCase().contains("nux") ||
                System.getProperty("os.name").toLowerCase().contains("mac");
    }

    private static void killProcessOnWindows(String processName) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("taskkill", "/F", "/IM", processName);
        builder.start();
        System.out.println("Killed process: " + processName);
    }

    private static void killProcessOnUnix(String processName) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("pkill", "-f", processName);
        builder.start();
        System.out.println("Killed process: " + processName);
    }
}