package com.example.componentestela;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {

    CheckBox ckbHabilitar;
    SeekBar sbkValor;
    TextView txtValor;
    Spinner spnNomes;
    RadioGroup rgOpcoes;
    Button btnView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ckbHabilitar = findViewById(R.id.ckbhabilitar);
        sbkValor = findViewById(R.id.sbkvalor);
        txtValor = findViewById(R.id.txtvalor);
        spnNomes = findViewById(R.id.spnnomes);
        rgOpcoes = findViewById(R.id.rgopcoes);

        configuraSeekBar();
        configuraSpinner();

    }

    public void configuraSeekBar(){

      sbkValor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

          @Override
          public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
              txtValor.setText(String.valueOf(i));
          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }
      });

    }

    public void configuraSpinner(){

      String[] nomes = new String[]{"João", "Maria", "José", "Ana","Eloah","Lis","Enzo"};

         //Criar um adaptador para o Spinner
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nomes);

        //Definir o layout do Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Associar o adaptador ao Spinner
        spnNomes.setAdapter(adapter);

    }


    public void visualizar(View view){

        //Recuperar o valor do CheckBox
        String habilitado = (ckbHabilitar.isChecked() ? "Habilitado" : "Desabilitado");

        //Recuperar o valor do CheckBox
        int opcaoSelecionada = rgOpcoes.getCheckedRadioButtonId();

        //Recuperar o valor do RadioButton
        RadioButton rbOpcao =(RadioButton) findViewById(opcaoSelecionada);

        //Recuperar o valor do EditText
        String opcao = "Opção:"+rbOpcao.getText().toString();

        //Recuperar o valor do Spinner
        String nome = "Nome:"+spnNomes.getSelectedItem().toString();

        //Recuperar o valor do Seekbar
        String valor = "Valor:"+sbkValor.getProgress();

        //Exibir os valores

        String mensagem = habilitado+"|"+opcao+"|"+nome+"|"+valor;

        //Criar um Toast
        Toast toast = Toast.makeText(this,mensagem.toString(),Toast.LENGTH_LONG);
        toast.show();


    }


}