package edu.suffolk.jsimons3.heart_ratecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;



public class MainActivity extends AppCompatActivity {


    private EditText ageeditText;

    private TextView agetextview;
    private TextView maxratetextview;
    private TextView targetratetextview;

    private java.lang.Integer maxheartrate = 220;
    private java.lang.Double minrange, maxrange;



    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ageeditText =
                (EditText) findViewById(R.id.ageeditText);
        ageeditText.addTextChangedListener(ageeditTextWatcher);

        agetextview =
                (TextView) findViewById(R.id.agetextview);
        agetextview.setText("0 Years");

        maxratetextview =
                (TextView) findViewById(R.id.maxratetextview);
        maxratetextview.setText("220 Beats Per Minute");

        targetratetextview =
                (TextView) findViewById(R.id.targetratetextview);



    }

    private void updateViews()
    {
        maxratetextview.setText(maxheartrate.toString() + " Beats Per Minute"); //Max Rate

        //Determine Target Range
        minrange = maxheartrate * 0.5; //50% of Max Rate
        maxrange = maxheartrate * 0.85; //%85% of Max Rate

        //Display Target Range
        targetratetextview.setText(minrange.toString().format("%.2f", minrange)  + " -- " + maxrange.toString().format("%.2f", maxrange) + " Beats Per Minute");
    }


    private TextWatcher ageeditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        // called when the user enters a number
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try
            {
                agetextview.setText(ageeditText.getText() + " Years");
                maxheartrate = 220 -  Integer.parseInt(s.toString());
            }
            catch (Exception e)
            {
                agetextview.setText("0 Years");
                maxheartrate = 220;
            }



            updateViews();





            //update views
        } // end method onTextChanged

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

