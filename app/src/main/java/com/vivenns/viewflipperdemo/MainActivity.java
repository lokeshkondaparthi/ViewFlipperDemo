package com.vivenns.viewflipperdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;
/* Inspired from this tutorial http://abhiandroid.com/ui/viewflipper*/
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.buttonNext)
    Button mButtonNext;

    @BindView(R.id.simpleViewFlipper)
    ViewFlipper mViewFlipper;

    @BindView(R.id.main_iv)
    ImageView mImage;

    @BindView(R.id.tv_ll)
    LinearLayout mLLTextViews;

    @BindView(R.id.bt_ll)
    LinearLayout mLLButtons;

    @BindView(R.id.button_rb)
    RadioButton mRB1;
    @BindView(R.id.button_rb2)
    RadioButton mRB2;
    @BindView(R.id.button_rb3)
    RadioButton mRB3;



    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ViewFlipper
        mViewFlipper.setInAnimation(in);
        mViewFlipper.setOutAnimation(out);

        // set the animation type to ViewFlipper
        mViewFlipper.setInAnimation(in);
        mViewFlipper.setOutAnimation(out);
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(1500);


        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewFlipper.showPrevious();
            }
        });
        mViewFlipper.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                mRB1.setChecked(false); mRB2.setChecked(false);mRB3.setChecked(false);
                if(mViewFlipper.getCurrentView() == mImage)  checkRB(RadioButtonsName.FIRST_BUTTON);
                else if(mViewFlipper.getCurrentView() == mLLTextViews) checkRB(RadioButtonsName.SECOND_BUTTON);
                else if(mViewFlipper.getCurrentView() == mLLButtons) checkRB(RadioButtonsName.THIRD_BUTTON);
            }
        });
    }
    private void checkRB(RadioButtonsName radioButton){
        if(radioButton.equals(RadioButtonsName.FIRST_BUTTON)) mRB1.setChecked(true);
        else if(radioButton.equals(RadioButtonsName.SECOND_BUTTON)) mRB2.setChecked(true);
        else if(radioButton.equals(RadioButtonsName.THIRD_BUTTON)) mRB3.setChecked(true);
    }

    private static void showLog(String tag,String msg){
        Log.d(tag, "showLog: "+msg);
    }
    private enum RadioButtonsName{
        FIRST_BUTTON, SECOND_BUTTON, THIRD_BUTTON
    }
}


