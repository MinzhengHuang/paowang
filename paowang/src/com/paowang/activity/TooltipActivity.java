package com.paowang.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paowang.R;
import com.paowang.view.Tooltip;

@SuppressWarnings("ConstantConditions")
public class TooltipActivity extends Activity {

    private ViewGroup root;

    private int tooltipColor;
    private int tooltipSize;
    private int tooltipPadding;

    private int tipSizeSmall;
    private int tipSizeRegular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooltip);

        root = (ViewGroup) findViewById(R.id.root);

        Resources res = getResources();

        tooltipSize = res.getDimensionPixelOffset(R.dimen.tooltip_width);
        tooltipColor = ContextCompat.getColor(this, R.color.colorPrimary);
        tooltipPadding = res.getDimensionPixelOffset(R.dimen.tooltip_padding);

        tipSizeSmall = res.getDimensionPixelSize(R.dimen.tip_dimen_small);
        tipSizeRegular = res.getDimensionPixelSize(R.dimen.tip_dimen_regular);

        final View bottomButton = findViewById(R.id.button_bottom);
        if (bottomButton != null) {
            bottomButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCustomTooltip(v);
                }
            });
        }

        findViewById(R.id.bottom_auto_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.bottom_auto_adjust, Tooltip.BOTTOM, true, tooltipSize,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        findViewById(R.id.bottom_no_auto_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.bottom_no_auto_adjust, Tooltip.BOTTOM, false, tooltipSize,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        findViewById(R.id.bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.bottom, Tooltip.BOTTOM, false, tooltipSize,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        findViewById(R.id.top_auto_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.top_auto_adjust, Tooltip.TOP, true, tooltipSize,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        findViewById(R.id.top_no_auto_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.top_no_auto_adjust, Tooltip.TOP, false, tooltipSize,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        findViewById(R.id.top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.top, Tooltip.TOP, false, tooltipSize,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        findViewById(R.id.right_auto_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.right_auto_adjust, Tooltip.RIGHT, true,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        tooltipSize);
            }
        });

        findViewById(R.id.right_no_auto_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.right_no_auto_adjust, Tooltip.RIGHT, false,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        tooltipSize);
            }
        });

        findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.right, Tooltip.RIGHT, false,
                        tooltipSize, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        findViewById(R.id.left_auto_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.left_auto_adjust, Tooltip.LEFT, true,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        tooltipSize);
            }
        });

        findViewById(R.id.left_no_auto_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.left_no_auto_adjust, Tooltip.LEFT, false,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        tooltipSize);
            }
        });

        findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTooltip(v, R.string.left, Tooltip.LEFT, false,
                        tooltipSize, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        showMenuTooltip(findViewById(R.id.demo_action));
        return true;
    }

    private void showTooltip(@NonNull View anchor, @StringRes int resId,
                             @Tooltip.Position int position, boolean autoAdjust,
                             int width, int height) {
        TextView textView = (TextView) getLayoutInflater().inflate(R.layout.tooltip_textview, null);
        textView.setText(resId);
        textView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        showTooltip(anchor, textView, position, autoAdjust, tooltipColor);
    }

    private void showTooltip(@NonNull View anchor, @NonNull View content,
                             @Tooltip.Position int position, boolean autoAdjust,
                             int tipColor) {
        new Tooltip.Builder(this)
                .anchor(anchor, position)
                .autoAdjust(autoAdjust)
                .content(content)
                .withTip(new Tooltip.Tip(tipSizeRegular, tipSizeRegular, tipColor))
                .into(root)
                .debug(true)
                .show();
    }

    private void showCustomTooltip(@NonNull View anchor) {
        View content = getLayoutInflater().inflate(R.layout.item_tooltip_view_1, null);

        new Tooltip.Builder(this)
                .anchor(anchor, Tooltip.BOTTOM)
                .autoAdjust(true)
                .withPadding(tooltipPadding)
                .content(content)
                .withTip(new Tooltip.Tip(tipSizeRegular, tipSizeRegular, tooltipColor))
                .into(root)
                .debug(true)
                .show();
    }

    private void showMenuTooltip(@NonNull View anchor) {
        TextView textView = (TextView) getLayoutInflater().inflate(R.layout.tooltip_textview, null);
        textView.setText(R.string.menu_tooltip);

        new Tooltip.Builder(this)
                .anchor(anchor, Tooltip.BOTTOM)
                .autoAdjust(true)
                .content(textView)
                .withPadding(getResources().getDimensionPixelOffset(R.dimen.menu_tooltip_padding))
                .withTip(new Tooltip.Tip(tipSizeSmall, tipSizeSmall, tooltipColor))
                .into(root)
                .debug(true)
                .show();
    }
}
