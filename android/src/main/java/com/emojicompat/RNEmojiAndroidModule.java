
package com.emojicompat;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNEmojiAndroidModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNEmojiAndroidModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNEmojiAndroid";
  }
}