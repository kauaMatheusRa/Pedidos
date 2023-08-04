package devandroid.kauamatheus.listadepedidos.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devandroid.kauamatheus.listadepedidos.Controller.CalcularTotal;
import devandroid.kauamatheus.listadepedidos.Controller.Controller_lista;
import devandroid.kauamatheus.listadepedidos.Model.Adapter;
import devandroid.kauamatheus.listadepedidos.Model.Interface;
import devandroid.kauamatheus.listadepedidos.Model.Item;
import devandroid.kauamatheus.listadepedidos.Model.order_item;
import devandroid.kauamatheus.listadepedidos.R;
import devandroid.kauamatheus.listadepedidos.database.Lista_DB;

public class MainActivity extends AppCompatActivity implements Interface.ClickRecyclerView_Interface{

    EditText editNome;
    EditText editQuantidade;
    EditText editPreco;

//    Button btexcluir;

    Item pedidos;

    Controller_lista controller_lista;

//    Lista_DB listadb;


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    Adapter adapter;
    private List<Item> itemListas = new ArrayList<>();
    Button adc;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pedidos = new Item();
//        listadb = new Lista_DB(this);

        editNome = findViewById(R.id.editAdicionarItem);
        editQuantidade = findViewById(R.id.editQuantidade);
        editPreco = findViewById(R.id.editTextPreco);

//        btexcluir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                listadb.deletarRegistro("Lista", idParaDeletar);
//            }
//        });


        setaRecyclerView();

        setaButtons();
        listenersButtons();

    }


    public void setaRecyclerView(){

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new Adapter(this, itemListas, this);
        mRecyclerView.setAdapter(adapter);
    }

    public void setaButtons(){

        adc = findViewById(R.id.idButtonAdicionar);

    }

    /**
     * Aqui é o método onde trata o clique em um item da lista
     */
    @Override
    public void onCustomClick(Object object) {

    }

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {

        controller_lista = new Controller_lista(MainActivity.this);


        adc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Item itens = new Item();
                itens.setNome(editNome.getText().toString());
                itens.setQntd(Integer.parseInt(editQuantidade.getText().toString()));
                itens.setPreco(Double.parseDouble(editPreco.getText().toString()));


                double resultado = CalcularTotal.calcularTotal(itens.getQntd(),itens.getPreco());
                itens.setTotal(String.valueOf(resultado));


                controller_lista.salvar(itens);

                Toast.makeText(MainActivity.this, " Salvo ", Toast.LENGTH_SHORT).show();

                itemListas.add(itens);
                adapter.notifyDataSetChanged();



            }
        });



    }
}

