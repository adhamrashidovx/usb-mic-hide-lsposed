package de.robv.android.xposed;

import java.util.Set;

/** Compile-time stub. The real class is provided by LSPosed/Vector at runtime. */
public final class XposedBridge {
    private XposedBridge() {
    }

    public static void log(String text) {
    }

    public static void log(Throwable t) {
    }

    public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback) {
        return null;
    }
}
