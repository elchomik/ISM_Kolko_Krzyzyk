package pollub.ism.ism_kolko_krzyzyk_lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,restart,rules,allGames;
    TextView drawText,winX,winO;

    String buttonName;
    final String button1Name="button1",button2Name="button2",button3Name="button3",button4Name="button4",
    button5Name="button5",button6Name="button6",button7Name="button7",button8Name="button8";


    private static int KOD=12345;
    final String cross="X",circle="O";
    String emptyString="";

    private static final String BUTTON1_KEY="button1Value",BUTTON2_KEY="button2Value",BUTTON3_KEY="button3Value",
    BUTTON4_KEY="button4Value",BUTTON5_KEY="button5Value",BUTTON6_KEY="button6Value",BUTTON7_KEY="button7Value",
    BUTTON8_KEY="button8Value",BUTTON9_KEY="button9Value";
    private static final String DRAW_KEY="drawGames",WIN_X="XwinGames",WIN_O="OwinGames";

    private static final String B1_TAP="button1Tap", COUNTER_KEY="counterValue",B2_TAP="button2Tap",B3_Tap="button3Tap",
    B4_TAP="button4Tap",B5_TAP="button5Tap",B6_TAP="button6Tap",B7_TAP="button7Tap",B8_TAP="button8Tap",
    B9_TAP="button9Tap",ENABLE_FIELD="fieldValue";

    int counter=0; //zmienna pozwalająca na naprzemienne wyświetlanie kółka i krzyżyka
    int button1Tap=0,buttonTap2=0,button3Tap=0,button4Tap=0,button5Tap=0,button6Tap=0,button7Tap=0,button8Tap=0,button9Tap=0; //zmienne zliczające wciśnięcie przycisku
    int enableField=9; //zmienna sprawdzająca ile mamy wolnych pól
    int XwinCounter=0; //zmienna pozwalająca na zliczanie ile gier wygrał X
    int OwinCounter=0;//zmienna pozwalająca na zliczanie ile gier wygrał O
    int drawCounter=0; //zmienna pozwalająca na zliczanie ile było remisów w grze
    int gameCounter=0; //zmienna pozwalająca na zliaczanie rozegranych gier

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        restart=findViewById(R.id.restart);
        drawText=findViewById(R.id.draw);
        winX=findViewById(R.id.winX);
        winO=findViewById(R.id.winO);
        rules=findViewById(R.id.zasady);

        restart.setOnClickListener(v -> {

            button1.setText(emptyString);
            button2.setText(emptyString);
            button3.setText(emptyString);
            button4.setText(emptyString);
            button5.setText(emptyString);
            button6.setText(emptyString);
            button7.setText(emptyString);
            button8.setText(emptyString);
            button9.setText(emptyString);

            counter = 0;
            enableField = 9;
            button1Tap = 0;
            buttonTap2 = 0;
            button3Tap = 0;
            button4Tap = 0;
            button5Tap = 0;
            button6Tap = 0;
            button7Tap = 0;
            button8Tap = 0;
            button9Tap = 0;

            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            button5.setEnabled(true);
            button6.setEnabled(true);
            button7.setEnabled(true);
            button8.setEnabled(true);
            button9.setEnabled(true);
            gameCounter++;
        });

        rules.setOnClickListener(v->
        {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            String url="https://pl.wikipedia.org/wiki/K%C3%B3%C5%82ko_i_krzy%C5%BCyk";
            intent.setData(Uri.parse(url));
            try {
                startActivity(intent);
            }catch (ActivityNotFoundException e){
                Toast.makeText(this,"Brak przeglądarki",Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(BUTTON1_KEY, String.valueOf(button1.getText()));
        outState.putString(BUTTON2_KEY,String.valueOf(button2.getText()));
        outState.putString(BUTTON3_KEY,String.valueOf(button3.getText()));
        outState.putString(BUTTON4_KEY,String.valueOf(button4.getText()));
        outState.putString(BUTTON5_KEY, String.valueOf(button5.getText()));
        outState.putString(BUTTON6_KEY,String.valueOf(button6.getText()));
        outState.putString(BUTTON7_KEY,String.valueOf(button7.getText()));
        outState.putString(BUTTON8_KEY,String.valueOf(button8.getText()));
        outState.putString(BUTTON9_KEY,String.valueOf(button9.getText()));
        outState.putInt(COUNTER_KEY,counter);
        outState.putInt(B1_TAP,button1Tap);
        outState.putInt(B2_TAP,buttonTap2);
        outState.putInt(B3_Tap,button3Tap);
        outState.putInt(B4_TAP,button4Tap);
        outState.putInt(B5_TAP,button5Tap);
        outState.putInt(B6_TAP,button6Tap);
        outState.putInt(B7_TAP,button7Tap);
        outState.putInt(B8_TAP,button8Tap);
        outState.putInt(B9_TAP,button9Tap);
        outState.putInt(ENABLE_FIELD,enableField);
        outState.putInt(DRAW_KEY,drawCounter);
        outState.putInt(WIN_X,XwinCounter);
        outState.putInt(WIN_O,OwinCounter);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        button1.setText(savedInstanceState.getString(BUTTON1_KEY));
        button2.setText(savedInstanceState.getString(BUTTON2_KEY));
        button3.setText(savedInstanceState.getString(BUTTON3_KEY));
        button4.setText(savedInstanceState.getString(BUTTON4_KEY));
        button5.setText(savedInstanceState.getString(BUTTON5_KEY));
        button6.setText(savedInstanceState.getString(BUTTON6_KEY));
        button7.setText(savedInstanceState.getString(BUTTON7_KEY));
        button8.setText(savedInstanceState.getString(BUTTON8_KEY));
        button9.setText(savedInstanceState.getString(BUTTON9_KEY));
        counter=savedInstanceState.getInt(COUNTER_KEY);
        button1Tap=savedInstanceState.getInt(B1_TAP);
        buttonTap2=savedInstanceState.getInt(B2_TAP);
        button3Tap=savedInstanceState.getInt(B3_Tap);
        button4Tap=savedInstanceState.getInt(B4_TAP);
        button5Tap=savedInstanceState.getInt(B5_TAP);
        button6Tap=savedInstanceState.getInt(B6_TAP);
        button7Tap=savedInstanceState.getInt(B7_TAP);
        button8Tap=savedInstanceState.getInt(B8_TAP);
        button9Tap=savedInstanceState.getInt(B9_TAP);
        enableField=savedInstanceState.getInt(ENABLE_FIELD);
        drawCounter=savedInstanceState.getInt(DRAW_KEY);
        XwinCounter=savedInstanceState.getInt(WIN_X);
        OwinCounter=savedInstanceState.getInt(WIN_O);
        drawText.setText(String.valueOf(drawCounter));
        winX.setText(String.valueOf(XwinCounter));
        winO.setText(String.valueOf(OwinCounter));
    }

    public void buttonClicked(View view){
        buttonName=view.getResources().getResourceEntryName(view.getId());
        // porównanie "button1".equals(buttonName) zwróci false jeśli buttonName jest nullem
        //jeśli używać buttonName.equals("button1") i buttonName jest nullem dostaniemy NullPointerException

        if(button1Name.equals(buttonName)) CircleOrXButton1();
        else if(button2Name.equals(buttonName)) CircleOrXButton2();
        else if(button3Name.equals(buttonName)) CircleOrXButton3();
        else if(button4Name.equals(buttonName)) CircleOrXButton4();
        else if(button5Name.equals(buttonName)) CircleOrXButton5();
        else if(button6Name.equals(buttonName)) CircleOrXButton6();
        else if(button7Name.equals(buttonName)) CircleOrXButton7();
        else if(button8Name.equals(buttonName)) CircleOrXButton8();
        else CircleOrXButton9();
    }

    void CircleOrXButton1(){
        if(button1Tap==0){
            showCircleOrXButton1();
            enableField--;
        }
        button1Tap++;
        EndGame();
    }
    void CircleOrXButton2(){
        if(buttonTap2==0) {
            showCircleOrXButton2();
            enableField--;
        }
        buttonTap2++;
        EndGame();
        }

    void CircleOrXButton3() {
        if (button3Tap == 0) {
            showCircleOrXButton3();
            enableField--;
        }
        button3Tap++;
        EndGame();
    }
    void CircleOrXButton4() {
        if (button4Tap == 0) {
            showCircleOrXButton4();
            enableField--;
        }
        button4Tap++;
        EndGame();
    }

    void CircleOrXButton5() {
        if (button5Tap == 0) {
            showCircleOrXButton5();
            enableField--;
        }
        button5Tap++;
        EndGame();
    }

    void CircleOrXButton6() {
        if (button6Tap == 0) {
            showCircleOrXButton6();
            enableField--;
        }
        button6Tap++;
        EndGame();
    }

    void CircleOrXButton7() {
        if (button7Tap == 0) {
            showCircleOrXButton7();
            enableField--;
        }
        button7Tap++;
        EndGame();
    }

    void CircleOrXButton8() {
        if (button8Tap == 0) {
            showCircleOrXButton8();
            enableField--;
        }
        button8Tap++;
        EndGame();
    }

    void CircleOrXButton9() {
        if (button9Tap == 0) {
            showCircleOrXButton9();
            enableField--;
        }
        button9Tap++;
        EndGame();
    }

    void EndGame(){
        if(xWinGame()){
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            winX.setText(String.valueOf(XwinCounter));
            gameCounter++;
        }
       else if(circleWinGame()){
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            winO.setText(String.valueOf(OwinCounter));
            gameCounter++;
        }
       else if( enableField==0) {
            Toast.makeText(this, "Remis", Toast.LENGTH_LONG).show();
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            drawCounter++;
            drawText.setText(String.valueOf(drawCounter));
            gameCounter++;
        }
    }


    boolean xWinGame(){
        if(cross.contentEquals(button1.getText()) && cross.contentEquals(button2.getText()) && cross.contentEquals(button3.getText())) {
            Toast.makeText(this, "Wygrał X", Toast.LENGTH_LONG).show();
            XwinCounter++;
            return true;
        }
        if(cross.contentEquals(button4.getText()) && cross.contentEquals(button5.getText()) && cross.contentEquals(button6.getText())) {
            Toast.makeText(this, "Wygrał X", Toast.LENGTH_LONG).show();
            XwinCounter++;
            return true;
        }
        if(cross.contentEquals(button7.getText()) && cross.contentEquals(button8.getText()) && cross.contentEquals(button9.getText())) {
            Toast.makeText(this, "Wygrał X", Toast.LENGTH_LONG).show();
            XwinCounter++;
            return true;
        }
        if (cross.contentEquals(button1.getText()) && cross.contentEquals(button4.getText()) && cross.contentEquals(button7.getText())) {
            Toast.makeText(this, "Wygrał X", Toast.LENGTH_LONG).show();
            XwinCounter++;
            return true;
        }
        if(cross.contentEquals(button2.getText()) && cross.contentEquals(button5.getText()) && cross.contentEquals(button8.getText())) {
            Toast.makeText(this, "Wygrał X", Toast.LENGTH_LONG).show();
            XwinCounter++;
            return true;
        }
        if(cross.contentEquals(button3.getText()) && cross.contentEquals(button6.getText()) && cross.contentEquals(button9.getText())) {
            Toast.makeText(this, "Wygrał X", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(cross.contentEquals(button1.getText()) && cross.contentEquals(button5.getText()) && cross.contentEquals(button9.getText())) {
            Toast.makeText(this, "Wygrał X", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(cross.contentEquals(button3.getText()) && cross.contentEquals(button5.getText()) && cross.contentEquals(button7.getText())) {
            Toast.makeText(this, "Wygral X", Toast.LENGTH_SHORT).show();
            XwinCounter++;
            return true;
        }
        return false;
    }

    boolean circleWinGame(){
        if(circle.contentEquals(button1.getText()) && circle.contentEquals(button2.getText()) && circle.contentEquals(button3.getText())) {
            Toast.makeText(this, "Wygrał O", Toast.LENGTH_LONG).show();
            OwinCounter++;
            return true;
        }
        if(circle.contentEquals(button4.getText()) && circle.contentEquals(button5.getText()) && circle.contentEquals(button6.getText())) {
            Toast.makeText(this, "Wygrał O", Toast.LENGTH_LONG).show();
            OwinCounter++;
            return true;
        }
        if(circle.contentEquals(button7.getText()) && circle.contentEquals(button8.getText()) && circle.contentEquals(button9.getText())) {
            Toast.makeText(this, "Wygrał O", Toast.LENGTH_LONG).show();
            OwinCounter++;
            return true;
        }
        if (circle.contentEquals(button1.getText()) && circle.contentEquals(button4.getText()) && circle.contentEquals(button7.getText())) {
            Toast.makeText(this, "Wygrał O", Toast.LENGTH_LONG).show();
            OwinCounter++;
            return true;
        }
        if(circle.contentEquals(button2.getText()) && circle.contentEquals(button5.getText()) && circle.contentEquals(button8.getText())) {
            Toast.makeText(this, "Wygrał O", Toast.LENGTH_LONG).show();
            OwinCounter++;
            return true;
        }
        if(circle.contentEquals(button3.getText()) && circle.contentEquals(button6.getText()) && circle.contentEquals(button9.getText())) {
            Toast.makeText(this, "Wygrał O", Toast.LENGTH_SHORT).show();
            OwinCounter++;
            return true;
        }
        if(circle.contentEquals(button1.getText()) && circle.contentEquals(button5.getText()) && circle.contentEquals(button9.getText())) {
            Toast.makeText(this, "Wygrał O", Toast.LENGTH_SHORT).show();
            OwinCounter++;
            return true;
        }
        if(circle.contentEquals(button3.getText()) && circle.contentEquals(button5.getText()) && circle.contentEquals(button7.getText())) {
            Toast.makeText(this, "Wygral O", Toast.LENGTH_SHORT).show();
            OwinCounter++;
            return true;
        }
        return false;
    }

    void showCircleOrXButton1(){
        if (counter % 2 != 0) button1.setText(cross);
        else button1.setText(circle);
        counter++;
    }

    void showCircleOrXButton2(){
        if (counter % 2 != 0 ) button2.setText(cross);
        else button2.setText(circle);
        counter++;
    }

    void showCircleOrXButton3(){
        if (counter % 2 != 0) button3.setText(cross);
        else button3.setText(circle);
        counter++;
    }

    void showCircleOrXButton4(){
        if (counter % 2 != 0) button4.setText(cross);
        else button4.setText(circle);
        counter++;
    }
    void showCircleOrXButton5(){
        if (counter % 2 != 0) button5.setText(cross);
        else button5.setText(circle);
        counter++;
    }

    void showCircleOrXButton6(){
        if (counter % 2 != 0) button6.setText(cross);
        else button6.setText(circle);
        counter++;
    }

    void showCircleOrXButton7(){
        if (counter % 2 != 0) button7.setText(cross);
        else button7.setText(circle);
        counter++;
    }

    void showCircleOrXButton8(){
        if (counter % 2 != 0) button8.setText(cross);
        else button8.setText(circle);
        counter++;
    }

    void showCircleOrXButton9(){
        if (counter % 2 != 0) button9.setText(cross);
        else button9.setText(circle);
        counter++;
    }
}