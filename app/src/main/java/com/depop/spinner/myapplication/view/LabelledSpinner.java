package com.depop.spinner.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.depop.spinner.myapplication.R;

public class LabelledSpinner extends LinearLayout implements SelectableSpinner.OnSpinnerEventListener {

    private static final int[] TEXT_VIEW_ATTRS = {android.R.attr.text};
    private static final int[] COLOR_ATTRS = {R.attr.colorControlNormal, R.attr.colorAccent};

    private TextView labelTextView;
    private SelectableSpinner spinner;
    private String label;
    private
    @ColorInt
    int normalColor, accentColor;

    public LabelledSpinner(final Context context) {
        this(context, null);
    }

    public LabelledSpinner(final Context context, @Nullable final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelledSpinner(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        labelTextView = (TextView) findViewById(R.id.label_text_view);
        labelTextView.setText(label);
        labelTextView.setTextColor(normalColor);
        spinner = (SelectableSpinner) findViewById(R.id.spinner);
    }

    private void init(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        inflate(getContext(), R.layout.view_labelled_spinner, this);
        setOrientation(VERTICAL);
        TypedArray a = context.obtainStyledAttributes(attrs, TEXT_VIEW_ATTRS, defStyleAttr, 0);
        if (a.hasValue(0)) {
            label = a.getString(0);
        }
        a.recycle();
        a = context.getTheme().obtainStyledAttributes(COLOR_ATTRS);
        normalColor = a.getColor(0, 0);
        accentColor = a.getColor(1, 0);
        a.recycle();
    }

    public void setAdapter(final SpinnerAdapter adapter) {
        spinner.setAdapter(adapter);
        spinner.setEventListener(this);
    }

    @Override
    public void onSpinnerOpened() {
        labelTextView.setTextColor(accentColor);
    }

    @Override
    public void onSpinnerClosed() {
        labelTextView.setTextColor(normalColor);
    }

    public void setLabel(@StringRes final int labelRes) {
        labelTextView.setText(labelRes);
    }

    public void setLabel(final CharSequence label) {
        labelTextView.setText(label);
    }

    public String getValue() {
        return spinner.getSelectedItem().toString();
    }


}
