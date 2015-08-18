package com.greenowl.tracker.config;

/**
 * Created by Ahmed on 2015-07-29.
 */
public class DevicePlatforms {

    private enum keys {
        IOS, ANDROID, BLACKBERRY, WINDOWS, UBUNTU
    }

    public static String ios() {
        return "" + keys.IOS;
    }

    public static String android() {
        return "" + keys.ANDROID;
    }

    public static String blackberry() {
        return "" + keys.BLACKBERRY;
    }

    public static String windows() {
        return "" + keys.WINDOWS;
    }
}
