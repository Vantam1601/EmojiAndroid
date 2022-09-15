package com.emojicompat;
import android.content.Context;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.emoji.widget.EmojiAppCompatTextView;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

/**
 * Concrete class for {@link RNEmojiCompatTextViewManager} which represents view managers of anchor
 * {@code <Text>} nodes.
 */

@ReactModule(name = RNEmojiCompatTextViewManager.REACT_CLASS)
public class RNEmojiCompatTextViewManager
          extends SimpleViewManager<EmojiAppCompatTextView> implements AndroidEmojiManagerInterface<EmojiAppCompatTextView> {
  @VisibleForTesting public static final String REACT_CLASS = "RNEmojiCompatText";

  static class ReactEmojiShadowNode extends LayoutShadowNode implements YogaMeasureFunction {

    private int mWidth;
    private int mHeight;
    private boolean mMeasured;

    private ReactEmojiShadowNode() {
      initMeasureFunction();
    }

    private void initMeasureFunction() {
      setMeasureFunction(this);
    }

    @Override
    public long measure(
            YogaNode node,
            float width,
            YogaMeasureMode widthMode,
            float height,
            YogaMeasureMode heightMode) {
      if (!mMeasured) {
        // Create a switch with the default config and measure it; since we don't (currently)
        // support setting custom switch text, this is fine, as all switches will measure the same
        // on a specific device/theme/locale combination.
        EmojiAppCompatTextView reactSwitch = new EmojiAppCompatTextView(getThemedContext());
        final int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        reactSwitch.measure(spec, spec);
        mWidth = reactSwitch.getMeasuredWidth();
        mHeight = reactSwitch.getMeasuredHeight();
        mMeasured = true;
      }

      return YogaMeasureOutput.make(mWidth, mHeight);
    }
  }

  private final ViewManagerDelegate<EmojiAppCompatTextView> mDelegate;

  public RNEmojiCompatTextViewManager() {
    mDelegate = new AndroidEmojiManagerDelegate<>(this);
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public void setNativeValue(EmojiAppCompatTextView view, boolean value) {

  }

  @Override
  public LayoutShadowNode createShadowNodeInstance() {
    return new ReactEmojiShadowNode();
  }

  @Override
  public Class getShadowNodeClass() {
    return ReactEmojiShadowNode.class;
  }

  @Override
  protected EmojiAppCompatTextView createViewInstance(ThemedReactContext context) {
    EmojiAppCompatTextView view = new EmojiAppCompatTextView(context);
    return view;
  }

  @Override
  protected ViewManagerDelegate<EmojiAppCompatTextView> getDelegate() {
    return mDelegate;
  }

  @Override
  public long measure(
          Context context,
          ReadableMap localData,
          ReadableMap props,
          ReadableMap state,
          float width,
          YogaMeasureMode widthMode,
          float height,
          YogaMeasureMode heightMode,
          @Nullable float[] attachmentsPositions) {
    EmojiAppCompatTextView view = new EmojiAppCompatTextView(context);
    int measureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
    view.measure(measureSpec, measureSpec);
    return YogaMeasureOutput.make(
            PixelUtil.toDIPFromPixel(view.getMeasuredWidth()),
            PixelUtil.toDIPFromPixel(view.getMeasuredHeight()));
  }

  @ReactProp(name = "text")
  public void setText(EmojiAppCompatTextView view, String text) {
    view.setText(text);
  }

  @ReactProp(name = ViewProps.FONT_SIZE, defaultFloat = Float.NaN)
  public void setFontSize(EmojiAppCompatTextView view, float fontSize) {
    view.setTextSize(fontSize);
  }

  private static void setValueInternal(EmojiAppCompatTextView view, boolean value) {
    // we set the checked change listener to null and then restore it so that we don't fire an
    // onChange event to JS when JS itself is updating the value of the switch

  }
}
