package studio.eight.textwithimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by xuanhong on 1/10/18. HappyCoding!
 */

public class TextWithImage extends LinearLayout {
    private String mCustomText = "TextView";
    private int mCustomTextColor = Color.BLACK;
    private int mCustomTextSize = 15;
    private Drawable mCustomImage;
    private float mCustomTextPaddingStart = 0;
    private ImageView imageView;
    private TextView textView;
    private int mImageWidth = 24;
    private int mImageHeight = 24;
    private int mTintColor = -1;

    public TextWithImage(Context context) {
        this(context, null);
    }

    public TextWithImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextWithImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.layout_text_with_image, this);

        imageView = findViewById(R.id.simple_image_view);
        textView = findViewById(R.id.simple_text_view);

        setOrientation(LinearLayout.HORIZONTAL);

        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.TextWithImage, defStyle, 0);

        mCustomText = a.getString(
                R.styleable.TextWithImage_twi_text);
        mCustomText = mCustomText == null ? "TextView" : mCustomText;

        mCustomTextColor = a.getColor(
                R.styleable.TextWithImage_twi_text_color,
                mCustomTextColor);
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        mCustomTextSize = a.getInteger(R.styleable.TextWithImage_twi_text_size_sp, mCustomTextSize);
        mCustomTextPaddingStart = a.getDimension(
                R.styleable.TextWithImage_twi_text_padding_start,
                mCustomTextPaddingStart);

        mImageWidth = a.getDimensionPixelSize(R.styleable.TextWithImage_twi_image_width, mImageWidth);
        mImageHeight = a.getDimensionPixelSize(R.styleable.TextWithImage_twi_image_height, mImageHeight);
        mTintColor = a.getColor(R.styleable.TextWithImage_twi_image_tint, mTintColor);

        if (a.hasValue(R.styleable.TextWithImage_twi_image)) {
            final int imageId = a.getResourceId(R.styleable.TextWithImage_twi_image, -1);
            if (imageId != -1) {
                mCustomImage = AppCompatResources.getDrawable(getContext(), imageId);
                if (mCustomImage != null) {
                    mCustomImage.setCallback(this);
                }
            }
        }

        a.recycle();

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
        if (mCustomImage != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();

            layoutParams.width = mImageWidth;
            layoutParams.height = mImageHeight;

            if (mTintColor != -1) imageView.setColorFilter(mTintColor);

            imageView.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(mCustomImage);
        } else {
            imageView.setImageDrawable(null);
            imageView.setVisibility(View.GONE);
        }

        textView.setTextColor(mCustomTextColor);
        textView.setTextSize(mCustomTextSize);
        textView.setText(mCustomText);

        MarginLayoutParams layoutParams = (MarginLayoutParams) textView.getLayoutParams();
        layoutParams.setMarginStart((int) mCustomTextPaddingStart);
        textView.setLayoutParams(layoutParams);

    }

    public void setText(@StringRes int resId) {
        textView.setText(resId);
    }

    public void setText(CharSequence text) {
        textView.setText(text);
    }

    public void setImage(@DrawableRes int resId) {
        imageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

}
