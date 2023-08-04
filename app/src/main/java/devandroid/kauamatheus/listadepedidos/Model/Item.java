package devandroid.kauamatheus.listadepedidos.Model;

public class Item {

    private String nome;
    private int qntd;
    private double preco;
    private String total;

    public Item(){

    }

    public Item(String nome, int qntd, double preco, String total) {
        this.nome = nome;
        this.qntd = qntd;
        this.preco = preco;
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome +": R$"+ preco +" " +qntd + "" + total;
    }
}
