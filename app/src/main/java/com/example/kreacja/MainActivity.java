package com.example.kreacja;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private String selectedShape = "Linie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();

        Button buttonLine = findViewById(R.id.linie);
        Button buttonEllipse = findViewById(R.id.Elipsy);
        Button buttonRect = findViewById(R.id.prostokaty);
        Button buttonCreate = findViewById(R.id.kreuj);
        Button buttonClear = findViewById(R.id.czysc);
        imageView.setImageBitmap(bitmap);
        
        buttonLine.setOnClickListener(v -> selectedShape = "Linie");
        buttonEllipse.setOnClickListener(v -> selectedShape = "Elipsy");
        buttonRect.setOnClickListener(v -> selectedShape = "Prostokąty");
        buttonCreate.setOnClickListener(v -> drawShape());
        buttonClear.setOnClickListener(v -> clearCanvas());
    }

    private void drawShape() {
        Random random = new Random();
        int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        paint.setColor(color);

        int startX = random.nextInt(300);
        int startY = random.nextInt(300);
        int endX = random.nextInt(300);
        int endY = random.nextInt(300);

        switch (selectedShape) {
            case "Linie":
                canvas.drawLine(startX, startY, endX, endY, paint);
                break;
            case "Elipsy":
                canvas.drawOval(startX, startY, endX, endY, paint);
                break;
            case "Prostokąty":
                canvas.drawRect(startX, startY, endX, endY, paint);
                break;
        }

        imageView.invalidate();
    }
    private void clearCanvas() {
        canvas.drawColor(Color.WHITE);
        imageView.invalidate();
    }
}
