import java.util.Scanner;
import java.text.DecimalFormat;

public abstract class Veiculo {
    private String modelo;
    private String marca;
    private int ano_fabricacao;
    private Double valor_mercado;
    public String placa;
    public int numCombustivel;
    public String combustivel;
    private DecimalFormat df = new DecimalFormat("#,###.00");

    Scanner input = new Scanner(System.in);

    public Veiculo(double valor_mercado, int ano_fabricacao, int numCombustivel, String modelo, String marca,
            String placa) {
        this.valor_mercado = valor_mercado;
        this.ano_fabricacao = ano_fabricacao;
        this.numCombustivel = numCombustivel;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
    }

    public Veiculo() {

    }

    // Função que vai ser passada para o @override de GerenciarVeiculos
    public abstract double calcularImposto(String placa);

    public String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getAno_fabricacao() {
        return this.ano_fabricacao;
    }

    public double getValor_Mercado() {
        return this.valor_mercado;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getCombustivel() {
        return this.combustivel;
    }

    public String setCombustivel(Veiculo veiculo) { //Tratamento de variável utilizada para armazenar o tipo de combustível do veiculo.
        if (veiculo.numCombustivel == 1) { 
            veiculo.combustivel = "Gasolina";
        } else if (veiculo.numCombustivel == 2) {
            veiculo.combustivel = "Diesel";
        } else if (veiculo.numCombustivel == 3) {
            veiculo.combustivel = "Flex";
        } else if (veiculo.numCombustivel == 4) {
            veiculo.combustivel = "GNV";
        } else if (veiculo.numCombustivel == 5) {
            veiculo.combustivel = "Álcool";
        }

        return combustivel;
    }

    public String imprimir(Veiculo veiculo) {
        setCombustivel(veiculo);

        return "\nID: " + veiculo + "\nMODELO: " + veiculo.modelo + "\nMARCA: " + veiculo.marca
                + "\nANO DE FABRICAÇÃO: " + veiculo.ano_fabricacao + "\nVALOR DE MERCADO: R$"
                + df.format(veiculo.valor_mercado) + "\nPLACA: " + veiculo.placa + "\nTIPO DE COMBUSTÍVEL: "
                + veiculo.combustivel + "\n";
    }
}