package com.paowang.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.paowang.R;
import com.paowang.view.MaterialRippleLayout;

/**
 * Created by huangminzheng on 16/4/14.
 */
public class MaterialRippleLayoutActivity extends Activity implements View.OnClickListener,View.OnLongClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_ripple_layout);
        // xml initialization
        findViewById(R.id.ripple_layout_1).setOnClickListener(this);
        findViewById(R.id.ripple_layout_1).setOnLongClickListener(this);

        // static initialization
        View view = findViewById(R.id.ripple_layout_2);
        MaterialRippleLayout.on(view)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view.setOnLongClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Short click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.ripple_layout_1) {
            Toast.makeText(this, "Long click not consumed", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(this, "Long click and consumed", Toast.LENGTH_SHORT).show();
        return true;
    }
}
