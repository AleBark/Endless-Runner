package com.example.developer.parallax;

/**
 * Created by developer on 24/04/17.
 */

import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MainCharacterObject extends AnimatedImageGameObject {


    Matrix matrix = new Matrix();
    public float  angle = 0;
    public float velocity = 500;
    public boolean jump = false;
    private int pulo = 100;
    public  float heightInicial;
    public MainCharacterObject(String file, AssetManager assetManager){
        loadImages(file,assetManager,7,1);
        timeNextFrame = 700;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);


        x += Math.cos(angle) * deltaTime * velocity/100000;
        y += Math.sin(angle) * deltaTime * velocity/100000;

        if(jump) {

            if(y <= 300){
                jump = false;
            }else {
                y -= 10;
            }

        }else {
            if(y != heightInicial) {
                y += 10;
            }
        }

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        matrix.reset();
        matrix.preTranslate(x-width/2,y-height/2);
        matrix.preRotate((float)angle*180.0f/(float)Math.PI,width/2,height/2);
        canvas.drawBitmap(anim[currentFrame],matrix,paint);
    }


}



