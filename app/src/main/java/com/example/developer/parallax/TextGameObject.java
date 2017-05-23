package com.example.developer.parallax;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;

/**
 * Created by developer on 15/05/17.
 */

public class TextGameObject extends GameObject {
    public int color, size = 50;
    String text = "";
    float metros = 0;
    public boolean jogando = true;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setTextSize(size);
        canvas.drawText(text, x, y, paint);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        metros++;

        if(jogando){
            text = metros/100 + " metros";
        }

    }
}
