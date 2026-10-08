package de.robv.android.xposed;

import java.lang.reflect.Member;

/** Compile-time stub. The real class is provided by LSPosed/Vector at runtime. */
public abstract class XC_MethodHook {
    public XC_MethodHook() {
    }

    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    }

    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
    }

    public static class MethodHookParam {
        public Member method;
        public Object thisObject;
        public Object[] args;

        public Object getResult() {
            return null;
        }

        public void setResult(Object result) {
        }
    }

    public class Unhook {
    }
}
