package com.bgt.singleselectionrecycleview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bgt.singleselectionrecycleview.R;
import com.bgt.singleselectionrecycleview.utils.SizeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhavesh on 19-08-2017.
 */

public class CustomView extends RelativeLayout {

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.iv_selected_image)
    ImageView ivSelectedImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    private String title;
    private int unselectImageId;
    private int selectImageId;
    private Drawable unselectImageDrawable;
    private Drawable selectImageDrawable;

    public CustomView(@NonNull Context context) {
        this(context, null);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.custom_view, this);
        ButterKnife.bind(this);
        setPadding(SizeUtils.convertDpToPixel(context, 5), 0, SizeUtils.convertDpToPixel(context, 5), 0);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
        unselectImageId = a.getResourceId(R.styleable.CustomView_view_unselect_icon, R.drawable.ic_action_camera);
        selectImageId = a.getResourceId(R.styleable.CustomView_view_select_icon,R.drawable.ic_action_select_camera);
        title = a.getString(R.styleable.CustomView_view_title);
        a.recycle();

        ivImage.setImageResource(unselectImageId);
        ivSelectedImage.setImageResource(selectImageId);
        tvTitle.setText(title != null ? title : "Camera");
    }


    public void setViewSelected(boolean isSelected){
        ivImage.setVisibility(isSelected?GONE:VISIBLE);
        ivSelectedImage.setVisibility(isSelected?VISIBLE:GONE);
        frameLayout.setSelected(isSelected);
    }

    public void setTitleText(String title){
        this.title = title;
        tvTitle.setText(title);
    }
    public void setUnselectImage(Drawable unselectImageDrawable){
        this.unselectImageDrawable = unselectImageDrawable;
        ivImage.setImageDrawable(unselectImageDrawable);
    }
    public void setSelectImage(Drawable selectImageDrawable){
        this.selectImageDrawable = selectImageDrawable;
        ivSelectedImage.setImageDrawable(selectImageDrawable);
    }
}
