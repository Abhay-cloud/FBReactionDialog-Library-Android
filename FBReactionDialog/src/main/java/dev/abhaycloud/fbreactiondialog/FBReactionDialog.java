package dev.abhaycloud.fbreactiondialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class FBReactionDialog  implements View.OnClickListener, View.OnTouchListener {

    private final Dialog dialog;
    private final Animation slide_up;

    private final int originalHeight, originalWidth;

    private final ImageView re1, re2, re3, re4, re5;

    public final int REACTION_LIKE = 0;
    public final int REACTION_LOVE = 1;
    public final int REACTION_HAHA = 2;
    public final int REACTION_WOW = 3;
    public final int REACTION_ANGRY = 4;

    private int currentReaction = -1;
    private OnReactionChangedListener reactionChangedListener;

    private final MediaPlayer box_up, reaction_popup;
    private boolean isSoundEnabled = true;

    @SuppressLint("ClickableViewAccessibility")
    public FBReactionDialog(Context context, View view){
        int[] location = new int[2];
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.reaction_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        view.post(() -> {
            view.getLocationOnScreen(location);
            Toast.makeText(context, location[0] + " " + location[1] , Toast.LENGTH_SHORT).show();
            dialog.getWindow().getAttributes().x = location[0] - 150;
            dialog.getWindow().getAttributes().y = location[1] - 850;
        });
        slide_up = AnimationUtils.loadAnimation(dialog.getContext(), R.anim.fall_down_up);

        re1 = dialog.findViewById(R.id.reaction1);
        re2 = dialog.findViewById(R.id.reaction2);
        re3 = dialog.findViewById(R.id.reaction3);
        re4 = dialog.findViewById(R.id.reaction4);
        re5 = dialog.findViewById(R.id.reaction5);

        re1.setOnTouchListener(this);
        re2.setOnTouchListener(this);
        re3.setOnTouchListener(this);
        re4.setOnTouchListener(this);
        re5.setOnTouchListener(this);

        Glide.with(re1).load(R.drawable.like).into(re1);
        Glide.with(re2).load(R.drawable.love).into(re2);
        Glide.with(re3).load(R.drawable.haha).into(re3);
        Glide.with(re4).load(R.drawable.angry).into(re4);
        Glide.with(re5).load(R.drawable.wow).into(re5);

        originalHeight = re1.getLayoutParams().height;
        originalWidth = re1.getLayoutParams().width;

        box_up = MediaPlayer.create(context, R.raw.dialog_up);
        reaction_popup = MediaPlayer.create(context, R.raw.reaction_choose);
    }


    public void show(){
        dialog.show();
        playSound(box_up);
        loadAnim();
    }

    public void dismiss(){
        dialog.dismiss();
    }

    private void loadAnim() {
        re1.startAnimation(slide_up);
        re2.startAnimation(slide_up);
        re3.startAnimation(slide_up);
        re4.startAnimation(slide_up);
        re5.startAnimation(slide_up);
    }

    @Override
    public void onClick(View v) {

    }

    public void setSoundEnabled(boolean isSoundEnabled){
        this.isSoundEnabled = isSoundEnabled;
    }

    public void setCurrentReaction(int reaction){
        this.currentReaction = reaction;
    }

    public int getCurrentReaction(){
        return currentReaction;
    }

    private void playSound(MediaPlayer mediaPlayer){
        if (isSoundEnabled){
            mediaPlayer.start();
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            if (v.getId() == R.id.reaction1) {
                setSize(re1);
            }
            else if (v.getId() == R.id.reaction2) {
                setSize(re2);
            }
            else if (v.getId() == R.id.reaction3) {
                setSize(re3);
            }
            else if (v.getId() == R.id.reaction4) {
                setSize(re4);
            }
            else if (v.getId() == R.id.reaction5) {
                setSize(re5);
            }
        }
        else if (event.getAction() == MotionEvent.ACTION_UP){
            if (v.getId() == R.id.reaction1) {
                changeToOriginalSize(re1);
                currentReaction = REACTION_LIKE;
            }
            else if (v.getId() == R.id.reaction2) {
                changeToOriginalSize(re2);
                currentReaction = REACTION_LOVE;
            }
            else if (v.getId() == R.id.reaction3) {
                changeToOriginalSize(re3);
                currentReaction = REACTION_HAHA;
            }
            else if (v.getId() == R.id.reaction4) {
                changeToOriginalSize(re4);
                currentReaction = REACTION_WOW;
            }
            else if (v.getId() == R.id.reaction5) {
                changeToOriginalSize(re5);
                currentReaction = REACTION_ANGRY;
            }
            playSound(reaction_popup);
            dismiss();
            reactionChangedListener.onReactionChange(currentReaction);

        }
        return true;
    }


    private void setSize(ImageView view){
        view.getLayoutParams().height = 100;
        view.getLayoutParams().width = 100;
        view.requestLayout();
    }

    private void changeToOriginalSize(ImageView view){
        view.getLayoutParams().height = originalHeight;
        view.getLayoutParams().width = originalWidth;
        view.requestLayout();
    }

    public void setOnReactionChangedListener(OnReactionChangedListener onReactionChangedListener){
        this.reactionChangedListener = onReactionChangedListener;
    }

}
