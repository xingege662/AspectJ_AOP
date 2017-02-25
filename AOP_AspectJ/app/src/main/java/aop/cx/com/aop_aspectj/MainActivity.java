package aop.cx.com.aop_aspectj;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @AopAnnotion(value = "hello_aop")
    public void aopClick(View view){
        SystemClock.sleep(200);
    }
}
