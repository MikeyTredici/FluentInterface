package org.example.utilities;

public class WebUtilities {

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
