package com.koushikdutta.superuser.util;

import android.content.Context;
import android.util.Log;

public class SuHelper {
    
    public static void checkSu(Context context) throws Exception {
        Process p = Runtime.getRuntime().exec("su -v");
        String result = Settings.readToEnd(p.getInputStream());
        Log.i("Superuser", "Result: " + result);
        if (0 != p.waitFor())
            throw new Exception("non zero result");
        if (result == null)
            throw new Exception("no data");
        if (!result.contains(context.getPackageName()))
            throw new Exception("unknown su");
        // TODO: upgrades herp derp
    }

}