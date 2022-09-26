package com.newworld.onelist.helpers;

import android.content.Context;

public class Conversion {
    // region DP and SP conversion
    public static float convertToDP(int p, Context context) {
        return p * context.getResources().getDisplayMetrics().density;
    }
    public static float convertToSP(int p, Context context) {
        return p * context.getResources().getDisplayMetrics().scaledDensity;
    }
    public static int convertDP(float dp, Context context) {
        return (int) (dp / context.getResources().getDisplayMetrics().density);
    }
    public static int convertSP(float sp, Context context) {
        return (int) (sp / context.getResources().getDisplayMetrics().scaledDensity);
    }
    // endregion
    // region Time Conversion

    public static String toTime(long minutes) {
        float hr = minutes / 60f;
        int rhr = (int) Math.floor(hr);
        int min = (int) Math.ceil((hr - rhr) * 60);
        return (rhr == 0 ? "" : rhr + " hr ") + (min == 0 ? "" : min + " min");
    }

    public static String toDate(long minutes) {
        float ih = minutes / 60f;
        int m = (int) ((ih - Math.floor(ih)) * 60);
        float id = ih / 24;
        int d = (int) Math.floor(id);
        int h = (int) Math.floor((id - d) * 24);
        return (d == 0 ? "" : d + " days ") + (h == 0 ? "" : h + " hr ") + (m == 0 ? "" : m + " min");
    }

    // endregion
}
