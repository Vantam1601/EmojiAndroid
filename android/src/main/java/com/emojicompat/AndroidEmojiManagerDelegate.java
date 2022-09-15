package com.emojicompat;


import android.view.View;
        import androidx.annotation.Nullable;
        import com.facebook.react.uimanager.BaseViewManagerDelegate;
        import com.facebook.react.uimanager.BaseViewManagerInterface;

public class AndroidEmojiManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidEmojiManagerDelegate(U viewManager) {
        super(viewManager);
    }

    @Override
    public void setProperty(T view, String propName, @Nullable Object value) {
        super.setProperty(view, propName, value);
    }
}
