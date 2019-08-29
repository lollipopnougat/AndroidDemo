package com.lnp.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1 = null;
    private Button btn2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn1.setText(numberGame.GetFirst());
        btn1.setOnClickListener(clickListener1);
        btn2 = findViewById(R.id.btn2);
        btn2.setText(numberGame.GetSecond());
        //btn2.setOnClickListener(clickListener2);
    }

    private int scores = 0;
    private NumberGame numberGame = new NumberGame();

    private void Process(int x) {
        if (numberGame.WhichIsBigger() == x) {
            Toast.makeText(getApplicationContext(), R.string.win, Toast.LENGTH_SHORT).show();
            scores++;
        } else if (scores == 0) {
            Toast.makeText(getApplicationContext(), R.string.no_more_scores, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.lose, Toast.LENGTH_SHORT).show();
            scores--;
        }
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(getString(R.string.scores) + scores);
        numberGame.Next();
        btn1 = findViewById(R.id.btn1);
        btn1.setText(numberGame.GetFirst());
         btn2 = findViewById(R.id.btn2);
        btn2.setText(numberGame.GetSecond());
    }

    private View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Process(1);
        }
    };
    /*private View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Process(2);
        }
    };*/

    //在xml中已经绑定了点击事件函数
    public void Btn2Click(View v) {
        Process(2);
    }

}

class NumberGame {
    private int FirstNumber;
    private int SecondNumber;

    public NumberGame() {
        Next();
    }

    public void Next() {
        FirstNumber = (int) (Math.random() * 100);
        do {
            SecondNumber = (int) (Math.random() * 100);
        } while (SecondNumber == FirstNumber);
    }

    public String GetFirst() {
        return Integer.toString(FirstNumber);
    }

    public String GetSecond() {
        return Integer.toString(SecondNumber);
    }

    public int WhichIsBigger() {
        if (FirstNumber > SecondNumber) return 1;
        else return 2;
    }
}
