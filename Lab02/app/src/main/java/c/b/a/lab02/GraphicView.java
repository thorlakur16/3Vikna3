package c.b.a.lab02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class GraphicView extends View {
    private Paint paint;
    public GraphicView (Context context , @Nullable AttributeSet attrs) {
        super ( context ,attrs);
        paint = new Paint();
        paint . setARGB (255 , 153 /* R */ , 50 /* G */ , 204 /* B */);
        paint . setStyle ( Paint . Style . FILL_AND_STROKE );
    }
    @Override
    public void onDraw (Canvas canvas) {
        canvas.drawCircle(
                Circle.getInstance().getX(),
                Circle.getInstance().getY(),
                Circle.getInstance().getRadius(),
                paint
        );
    }
    public void update() {
        this.invalidate();
    }
}