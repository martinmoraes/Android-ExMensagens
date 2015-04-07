package br.com.earcadia.exmensagens;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class PrincipalActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        RadioGroup rGroup = (RadioGroup) findViewById(R.id.idRadioGroupTempo);
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                              public void onCheckedChanged(RadioGroup group, int id) {
                                                  if (id == R.id.idRadioButtonTempoCurto)
                                                      Toast.makeText(PrincipalActivity.this, "Você clicou em Curto", Toast.LENGTH_LONG).show();
                                                  else if (id == R.id.idRadioButtonTempoLongo)
                                                      Toast.makeText(PrincipalActivity.this, "Você clicou em Longo", Toast.LENGTH_LONG).show();
                                              }
                                          }

        );


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
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                break;
            case R.id.idRadioButtonEmCima:
                toast.setGravity(Gravity.TOP, 0, 0);
                break;
        }
        toast.show();
    }


    public void onCLickToastCustomizado(View view) {
        LayoutInflater layoutInflater = getLayoutInflater();
        //ViewGroup viewGroup = (ViewGroup) findViewById(R.id.toast_layout_referencia);
        View viewA = layoutInflater.inflate(R.layout.toast, null);//viewGroup
        TextView tv_texto = (TextView) viewA.findViewById(R.id.texto);
        tv_texto.setText("Com Inflado");
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(viewA);
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
