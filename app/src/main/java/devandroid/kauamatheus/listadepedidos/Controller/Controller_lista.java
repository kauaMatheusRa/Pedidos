package devandroid.kauamatheus.listadepedidos.Controller;

import android.content.ContentValues;
import android.util.Log;

import androidx.annotation.NonNull;


import devandroid.kauamatheus.listadepedidos.Model.Item;
import devandroid.kauamatheus.listadepedidos.View.MainActivity;
import devandroid.kauamatheus.listadepedidos.database.Lista_DB;

public class Controller_lista extends Lista_DB {

    public Controller_lista(MainActivity activity){
        super(activity);

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciada");
        return super.toString();
    }

    public void salvar(Item lista){
        Log.d("MVC_Controller", "Salvo");

        ContentValues dados = new ContentValues();
        dados.put("nome", lista.getNome());
        dados.put("quantidade",lista.getQntd());
        dados.put("preco",lista.getPreco());
        dados.put("total", lista.getTotal());

        salvarDados("Lista",dados);
    }

    public void limpar(Item lista){

        ContentValues dados = new ContentValues();
        dados.put("nome", lista.getNome());
        dados.put("quantidade",lista.getQntd());
        dados.put("preco",lista.getPreco());
        dados.put("total", lista.getTotal());

        salvarDados("Lista",dados);
    }

}
