package lukeklepfer.com.coolcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL;
    }

    TextView resultView;

    String runningNum = "";
    String leftValue = "";
    String rightValue = "";
    Operation currentOp;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);
        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);

        Button clearBtn = (Button)findViewById(R.id.clearBtn);

        ImageButton addBtn = (ImageButton)findViewById(R.id.addBtn);
        ImageButton subBtn = (ImageButton)findViewById(R.id.subtractBtn);
        ImageButton multBtn = (ImageButton)findViewById(R.id.multiplyBtn);
        ImageButton divBtn = (ImageButton)findViewById(R.id.divideBtn);
        ImageButton calcBtn = (ImageButton)findViewById(R.id.calcBtn);

        resultView = (TextView)findViewById(R.id.resultsTxt);
        resultView.setText("");

        oneBtn.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v) {

                numPressed(1);

           }
        });

        twoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(2);

            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(3);

            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(4);

            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(5);

            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(6);

            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(7);

            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(8);

            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(9);

            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                numPressed(0);

            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                leftValue = "";
                rightValue = "";
                resultView.setText("");
                result = 0;
                runningNum = "";
                currentOp = null;

            }
        });
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                processOperation(Operation.EQUAL);

            }
        });
        divBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                processOperation(Operation.DIVIDE);


            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                processOperation(Operation.ADD);


            }
        });
        multBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                processOperation(Operation.MULTIPLY);


            }
        });
        subBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                processOperation(Operation.SUBTRACT);


            }
        });
    }

    void processOperation(Operation operation){

        if (currentOp != null) {
            if (runningNum != "") {
                rightValue = runningNum;
                runningNum = "";

                switch (currentOp) {
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                }
                leftValue = String.valueOf(result); //5+5 = 10+3 = 13 ...etc
                resultView.setText(leftValue);
            }
        }else{
            //operation is null
            leftValue = runningNum;
            runningNum = "";
        }
        currentOp = operation;
    }

    void numPressed(int number) {

        runningNum += String.valueOf(number);// 5 and 6 = 56
        resultView.setText(runningNum);

    }
}
