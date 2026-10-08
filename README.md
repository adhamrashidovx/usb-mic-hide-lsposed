# USB Mic Hide (LSPosed/Vector moduli)

USB DAC/garnituradagi mikrofonni Android tizimidan yashiradi. DAC faqat chiqish (ovoz) qurilmasi
sifatida ro'yxatga olinadi, mikrofon esa ichki mikrofon bo'lib qoladi.

Hook: `system_server` ichida `UsbDescriptorParser.hasInput()` va `isInputHeadset()` ni `false` qaytaradi.

## O'rnatish
1. GitHub'da repo yarating va shu papkani yuklang (Actions APK'ni o'zi yig'adi).
2. Actions -> Build APK -> Artifacts -> `UsbMicHide-apk` ni yuklab oling, ichidagi `app-debug.apk` ni o'rnating.
3. LSPosed/Vector -> Modules -> USB Mic Hide -> yoqing, scope: **System Framework**.
4. Telefonni qayta ishga tushiring.
5. DAC'ni ulang, `dumpsys media.audio_policy` da USB kirish qurilmasi ko'rinmasligi kerak.

Log: LSPosed/Vector loglarida `[UsbMicHide]` qatorlarini qidiring.
