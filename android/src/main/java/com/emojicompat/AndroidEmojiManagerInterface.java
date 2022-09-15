package com.emojicompat;

import android.view.View;

public interface AndroidEmojiManagerInterface<T extends View> {
    void setNativeValue(T view, boolean value);
}
