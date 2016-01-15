package com.depop.spinner.spinnerissue.view;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;

/**
 * The standard spinner class does not allow you to determine if the spinner still has focus or not.
 * This is useful for setting the colour of linked labels on the spinner
 */
public class SelectableSpinner extends AppCompatSpinner {

    private OnSpinnerEventListener listener;
    private boolean openInitiated;

    public SelectableSpinner(final Context context) {
        super(context);
    }

    public SelectableSpinner(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectableSpinner(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setEventListener(OnSpinnerEventListener onSpinnerEventListener) {
        listener = onSpinnerEventListener;
    }

    @Override
    public boolean performClick() {
        openInitiated = true;
        if (listener != null) {
            listener.onSpinnerOpened();
        }
        return super.performClick();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (openInitiated && hasWindowFocus) {
            openInitiated = false;
            if (listener != null) {
                listener.onSpinnerClosed();
            }
        }
    }

    public interface OnSpinnerEventListener {

        void onSpinnerOpened();

        void onSpinnerClosed();
    }
}
