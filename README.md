# USB Mic Hide

LSPosed/Vector module that hides the microphone of a USB DAC/headset so Android keeps using the phone's built-in mic, while audio output still goes through the USB device.

USB DAC/garnituradagi mikrofonni tizimdan yashiradi: ovoz USB orqali chiqadi, mikrofon esa telefonniki bo'lib qoladi.

## Requirements
- Root + LSPosed or Vector (Zygisk)
- Android 16 (tested)

## Install
1. Download the APK from Releases and install it.
2. LSPosed/Vector > Modules > enable USB Mic Hide, scope: System Framework.
3. Reboot.

## How it works
Hooks `UsbDescriptorParser.hasInput()` and `isInputHeadset()` in system_server, so USB audio devices are registered as output-only.

## Limitations
- Tested only on POCO X8 Pro Max (HyperOS, Android 16). Other devices/versions may differ.
- Hides the mic of ALL USB audio devices while enabled.
- The APK is debug-signed.

Feedback: check LSPosed logs for `[UsbMicHide]` lines and open an issue.
