package testdemo.com.materialsearchviewtest.utilities;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class DisplayUtilities extends Utilities {

    // width, height
    // Samsung T530NU: 1280, 800
    // Droid Maxx: 720, 1280

    public static int getScreenWidth(Context context) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        return screenWidth;

    }

    public static int getScreenHeight(Context context) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        return screenHeight;
    }

    public static float getDensity(Context context) {

        // density
        //     Samsung T530NU: 0
        //     ASUS Nexus 7: 0
        //     Droid Maxx: 0

        DisplayMetrics displayMetrics = new DisplayMetrics();
        float density = displayMetrics.density;

        // densityDpi
        //     Samsung T530NU: 160
        //     ASUS Nexus 7: 320
        //     Droid Maxx: 320

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int densityDpi = (int)(metrics.density * 160f);

        return density;
    }

    private static String getDensityName(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return "xxxhdpi";
        }
        if (density >= 3.0) {
            return "xxhdpi";
        }
        if (density >= 2.0) {
            return "xhdpi";
        }
        if (density >= 1.5) {
            return "hdpi";
        }
        if (density >= 1.0) {
            return "mdpi";
        }
        return "ldpi";
    }
}
