package com.gamalasker.commons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

public class MethodCollection {

    public static boolean isAppHa556Fg65d(String PACKAGE_NAME, Context mContext, String googlePackageName, String amazonPackageName, String signature) throws PackageManager.NameNotFoundException {

        String installer = mContext.getPackageManager().getInstallerPackageName(PACKAGE_NAME);

        @SuppressLint("PackageManagerGetSignatures")
        Signature[] signatures = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), PackageManager.GET_SIGNATURES).signatures;

        if (mContext.getPackageName().startsWith("com.gamalasker")) {
            return false;
        } else if (installer != null && installer.startsWith(googlePackageName) && installer.startsWith(amazonPackageName)) {
            return false;
        } else if (installer == null) {
            return true; // BOOM!
        } else if (installer.compareTo(googlePackageName) != 0 && installer.compareTo(amazonPackageName) != 0) {
            return true; // BOOM!
        } else if (mContext.getPackageName().compareTo(PACKAGE_NAME) != 0) {
            return true; // BOOM!
        } else if (!signatures[0].toCharsString().equals(signature)){
            return true; // BOOM!
        }

        return false;
    }


}
