package de.cacodaemon;

import de.cacodaemon.rpiws28114j.Color;
import de.cacodaemon.rpiws28114j.StripType;
import de.cacodaemon.rpiws28114j.WS2811;
import de.cacodaemon.rpiws28114j.WS2811Channel;

/**
 * Only used for quick testing of the wrapper.
 * Is not included in generated JAR.
 */
public class Main {
    public static void clear(int count) {
        for (int j = 0; j < count; j++) {
            WS2811.setPixel(j, Color.BLACK);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int count = 4 * 19;
        System.out.println("Initializing strip...");
        WS2811.init(new WS2811Channel(/* GPIO */ 18, /* LED count */ count, StripType.WS2811_STRIP_GRB, /* invert */ false, /* brightness */ 255));

        System.out.println("Setting pixels...");
        clear(count);
        WS2811.setPixel(0, Color.RED);
        WS2811.setPixel(1, Color.GREEN);
        WS2811.setPixel(2, Color.BLUE);

        System.out.println("Calling render()");
        WS2811.render();
        Thread.sleep(2000);

        System.out.println("Clearing...");
        clear(count);
        WS2811.render();
        Thread.sleep(100);
        System.out.println("Closing...");

        WS2811.close();
        System.out.println("Exiting...");
        System.exit(0);
    }
}
