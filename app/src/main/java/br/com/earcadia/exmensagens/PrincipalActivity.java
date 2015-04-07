package br.com.earcadia.exmensagens;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;


public class PrincipalActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void onClickMostraMensagem(View view) {
        int duracao = Toast.LENGTH_SHORT;
        RadioGroup rg = (RadioGroup) findViewById(R.id.idRadioGroupTempo);
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.idRadioButtonTempoCurto:
                duracao = Toast.LENGTH_SHORT;
                break;
            case R.id.idRadioButtonTempoLongo:
                duracao = Toast.LENGTH_LONG;
                break;
        }

        Context contexto = getApplicationContext();
        String texto = "A grande MENSAGEM";

        Toast toast = Toast.makeText(contexto, texto, duracao);

        RadioGroup rgPosicao = (RadioGroup) findViewById(R.id.idRadioGroupPosicao);
        switch (rgPosicao.getCheckedRadioButtonId()) {
            case R.id.idRadioButtonCentro:
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                break;
            case R.id.idRadioButtonEmBaixo:
                toast.setGravity(Gravity.BOTTOM,  0, 0);
                break;
            case R.id.idRadioButtonEmCima:
                toast.setGravity(Gravity.TOP, 0,0);
                break;
        }

        toast.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
