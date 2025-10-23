package adocao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastrarAnimal {
    private String nome;
    private String tipo;
    private char sexo;
    private String endereco;
    private int idade;
    private double peso;
    private String raca;

    public CadastrarAnimal(String nome, String tipo, char sexo, String endereco, int idade, double peso, String raca) {
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Pattern pattern = Pattern.compile("[^a-zA-Z]+\\s[a-zA-Z]+");
        Matcher matcher = pattern.matcher(nome);
        if(matcher.matches()){
            this.nome = nome;
        } else{
            System.out.println("Coloque somente letras!");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(raca);
        if(matcher.matches()){
            this.raca = raca;
        } else{
            System.out.println("Somente letras são permitidas.");
        }
    }
}
