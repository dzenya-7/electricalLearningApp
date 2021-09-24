package net.vrgsoft.rollinglayoutmanager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CurrentActivity extends AppCompatActivity {

    int wrap = LinearLayout.LayoutParams.WRAP_CONTENT;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);
        linearLayout = findViewById(R.id.linear_layout);
            Intent intent = getIntent();
            getSupportActionBar().setTitle(intent.getStringExtra("title"));
            int string_res = intent.getIntExtra("strings",0);
            int int_res = intent.getIntExtra("ints",0);
            String[] ints = getResources().getStringArray(int_res);
            String[] strings = getResources().getStringArray(string_res);
            LinearLayout.LayoutParams layoutParams;
            int[] before = getResources().getIntArray(intent.getIntExtra("before",0));
            int j=0;
                    try{
                        for(int i=0;i<strings.length;i++){
                            if(found(before,i)){
                                if(j<before.length){
                                    ImageView imageView = new ImageView(this);
                                    Drawable drawable = getDrawable(getResources().getIdentifier(ints[j], "drawable", getPackageName()));
                                    imageView.setImageDrawable(drawable);
                                    imageView.setPadding(0, 0, 0, 0);
                                    layoutParams = new LinearLayout.LayoutParams(600, 400);
                                    layoutParams.topMargin = 0;
                                    layoutParams.bottomMargin = 0;
                                    layoutParams.gravity = Gravity.CENTER;
                                    linearLayout.addView(imageView, layoutParams);
                                    j++;
                                }

                            }
                            TextView textView = new TextView(this);
                            textView.setText(strings[i]);
                            textView.setPadding(50,10,50,10);
                            textView.setTextColor(Color.BLACK);
                            layoutParams = new LinearLayout.LayoutParams(wrap,wrap);
                            layoutParams.gravity = Gravity.CENTER;
                            Log.println(Log.ERROR,"Message",Integer.toString(i));
                            linearLayout.addView(textView,layoutParams);
                        }
                    }
                    catch (Exception e){

                    }
    }

    public boolean found(int[] array, int x){
        int a= Arrays.binarySearch(array,x);
        if(a==-1){
            return false;
        }
        else{
            return true;
        }
    }


}