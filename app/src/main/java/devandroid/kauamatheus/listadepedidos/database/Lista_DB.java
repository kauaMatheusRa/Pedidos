package devandroid.kauamatheus.listadepedidos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Lista_DB extends SQLiteOpenHelper {


    private static String DB_NAME = "Lista_DB";
    private static final int DB_VERSION = 4;

    Cursor cursor;
    SQLiteDatabase db;

    public Lista_DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TabelaLista
                = "CREATE TABLE Lista (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT," +
                "quantidade TEXT)";


        db.execSQL(TabelaLista);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            // Add the new column "preco" to the existing table
            db.execSQL("ALTER TABLE Lista ADD COLUMN preco REAL");
            db.execSQL("ALTER TABLE Lista ADD COLUMN total REAL");
        }
    }

    public void salvarDados(String tabela, ContentValues dados){
        db.insert(tabela, null,dados);

    }

    public void limparTabela(String tabela) {
        // Verificar se o banco de dados está aberto
        if (db == null || !db.isOpen()) {
            db = getWritableDatabase(); // Abrir o banco de dados se não estiver aberto
        }

        // Executar a operação SQL de DELETE
        db.delete(tabela, null, null);
    }
}
