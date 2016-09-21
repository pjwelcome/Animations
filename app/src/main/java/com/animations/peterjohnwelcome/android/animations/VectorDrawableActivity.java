package com.animations.peterjohnwelcome.android.animations;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.animations.peterjohnwelcome.android.animations.Interfaces.VectorDrawableView;

public class VectorDrawableActivity extends AppCompatActivity implements VectorDrawableView {

    private AnimatedVectorDrawable mMenuDrawable;
    private AnimatedVectorDrawable mBackDrawable;
    private boolean mMenuFlag;

    private AnimatedVectorDrawable mAddDrawable;
    private AnimatedVectorDrawable mCheckDrawable;
    private boolean mFabFlag;

    private FloatingActionButton mFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_drawable);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        if(getSupportActionBar()!= null) {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_vector);
        }
       SetUpViews();
        FabClick();

    }

    @Override
    public void SetUpViews() {
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mMenuDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_menu_animatable);
        mBackDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_back_animatable);
        mAddDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_add_animatable);
        mCheckDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_check_animatable);
    }

    @Override
    public void FabClick() {
        mFloatingActionButton.setOnClickListener(view -> {
            if (mFabFlag) {
                mFloatingActionButton.setImageDrawable(mCheckDrawable);
                mCheckDrawable.start();
            } else {
                mFloatingActionButton.setImageDrawable(mAddDrawable);
                mAddDrawable.start();
            }
            mFabFlag = !mFabFlag;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            menuClick();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void menuClick() {
        if (mMenuFlag) {
            getSupportActionBar().setHomeAsUpIndicator(mBackDrawable);
            mBackDrawable.start();
        } else {
            getSupportActionBar().setHomeAsUpIndicator(mMenuDrawable);
            mMenuDrawable.start();
        }
        mMenuFlag = !mMenuFlag;
    }
}
