package com.example.nishant.connect3;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int turn;
int cells=9;
int board[][]=new int[3][3];
public boolean check(int x,int y)
{
    if(board[0][y]==turn&&board[1][y]==turn&&board[2][y]==turn)
        return true;
    if(board[x][0]==turn&&board[x][1]==turn&&board[x][2]==turn)
        return true;
    if(x+y==2)
    {
        if(board[0][2]==turn&&board[1][1]==turn&&board[2][0]==turn)
            return true;
    }
    if(y-x==0)
    {
        if(board[0][0]==turn&&board[1][1]==turn&&board[2][2]==turn)
            return true;
    }
    return false;

}
public void playAgain(View v)
{
    Button b=(Button) findViewById(R.id.button2);
    b.setVisibility(View.INVISIBLE);
    b.setClickable(false);
    TextView t1=findViewById(R.id.t1);
    t1.setVisibility(View.INVISIBLE);
    turn =0;
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
            board[i][j]=-1;
    }
    cells=9;
    GridLayout g=findViewById(R.id.g1);
   // Log.i("error",Integer.toString(g.getChildCount()));
    for(int i=0;i<g.getChildCount();i++)
    {
        ((ImageView) g.getChildAt(i)).setImageResource(0);
    }

}

    public void drop(View v)
    {
        ImageView i=(ImageView) v;
if(((ImageView) v).getDrawable()!=null && cells>0)
    Toast.makeText(MainActivity.this, "Invalid cell", Toast.LENGTH_SHORT).show();
else if(cells>0){
    if (turn == 0)
        ((ImageView) v).setImageResource(R.drawable.redc);
    else
        ((ImageView) v).setImageResource(R.drawable.yelc);
    v.setTranslationY(-1500f);
    v.setAlpha(0f);
    v.animate().alpha(1f).translationYBy(1500f).setDuration(300);
 String tag=v.getTag().toString();
 String x="" + tag.charAt(0);
    int x1=Integer.parseInt(x);
    String y="" + tag.charAt(1);
    int y1=Integer.parseInt(y);
  //  Toast.makeText(Main, "", Toast.LENGTH_SHORT).show();
/*    int y=Integer.parseInt(tag.substring(1,1));*/
  //  Toast.makeText(MainActivity.this, Integer.toString(x1) + Integer.toString(y1), Toast.LENGTH_SHORT).show();
    cells--;
    board[x1][y1]=turn;

    if(check(x1,y1))
    {
        TextView t1=findViewById(R.id.t1);
        t1.setVisibility(View.VISIBLE);
        t1.setText("PLAYER " + Integer.toString(turn+1) + " WON");
       // Toast.makeText(MainActivity.this, "PLAYER " + Integer.toString(turn) + " WON", Toast.LENGTH_SHORT).show();
        Button b= (Button) findViewById(R.id.button2);
        cells=0;
        b.setClickable(true);
        b.setVisibility(View.VISIBLE);


    }
    else
    {
        if(cells==0)
        {
            TextView t1=findViewById(R.id.t1);
            t1.setVisibility(View.VISIBLE);
            t1.setText("IT'S A DRAW");
            //Toast.makeText(MainActivity.this, "DRAW", Toast.LENGTH_SHORT).show();
            Button b= (Button) findViewById(R.id.button2);
            b.setClickable(true);
            b.setVisibility(View.VISIBLE);
        }

    }
    turn = 1 - turn;
}


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        turn =0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                board[i][j]=-1;
        }
    }
}
