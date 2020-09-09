package com.gamalasker.commons;

import android.content.Context;
import android.util.Log;

public class MethodCollection {

    public static boolean isAppHacked(String PACKAGE_NAME, Context mContext, String googlePackageName, String amazonPackageName) {

        String installer = mContext.getPackageManager().getInstallerPackageName(PACKAGE_NAME);

        if (mContext.getPackageName().startsWith("com.gamalasker")) {
            return false;
        } else if (installer == null) {
            return true; // BOOM!
        } else if (installer.compareTo(googlePackageName) != 0 && installer.compareTo(amazonPackageName) != 0) {
            return true; // BOOM!
        } else if (mContext.getPackageName().compareTo(PACKAGE_NAME) != 0) {
            return true; // BOOM!
        }

        return false;
    }

}
