package uz.usbmichide;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Hooks system_server (package "android"). Makes the USB descriptor parser report
 * "no input", so Android registers a USB DAC as an output-only device and keeps
 * using the built-in microphone. Playback through the DAC is untouched.
 */
public class Hook implements IXposedHookLoadPackage {

    private static final String TAG = "[UsbMicHide] ";
    private static final String PARSER = "com.android.server.usb.descriptors.UsbDescriptorParser";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!"android".equals(lpparam.packageName)) {
            return;
        }
        try {
            Class<?> parser = XposedHelpers.findClassIfExists(PARSER, lpparam.classLoader);
            if (parser == null) {
                XposedBridge.log(TAG + "class not found: " + PARSER);
                return;
            }

            XC_MethodHook returnFalse = new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) {
                    param.setResult(Boolean.FALSE);
                }
            };

            int count = 0;
            count += hook(parser, "hasInput", returnFalse);
            count += hook(parser, "isInputHeadset", returnFalse);
            XposedBridge.log(TAG + "hooked methods: " + count);
        } catch (Throwable t) {
            XposedBridge.log(TAG + "failed");
            XposedBridge.log(t);
        }
    }

    private static int hook(Class<?> clazz, String name, XC_MethodHook callback) {
        try {
            int n = XposedBridge.hookAllMethods(clazz, name, callback).size();
            if (n == 0) {
                XposedBridge.log(TAG + "no method named " + name);
            }
            return n;
        } catch (Throwable t) {
            XposedBridge.log(TAG + "hook failed for " + name);
            XposedBridge.log(t);
            return 0;
        }
    }
}
