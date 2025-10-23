package adocao;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastrarAnimal {
    private String nome;
    private String tipo;
    private SexoAnimal sexo;
    private String endereco;
    private double idade;
    private double peso;
    private String raca;

    public CadastrarAnimal(String nome, String tipo, SexoAnimal sexo, String endereco, double idade, double peso, String raca) {
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
        Pattern pattern = Pattern.compile("^[a-zA-Z]+\\s[a-zA-Z]+");
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

    public SexoAnimal getSexo() {
        return sexo;
    }

    public void setSexo(SexoAnimal sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        try{
        if(idade > 20){
        throw new IllegalArgumentException("Idade não pode ser maior que 20");
        }else{
            this.idade = idade;
        }
        }
        catch(InputMismatchException e){
            System.out.println("Digite somente numeros! ");
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {

        try{
        if(peso <0.5 || peso > 60){
          throw  new IllegalArgumentException("Peso inválido");
        } else{
            this.peso = peso;
        }} catch (InputMismatchException e) {
            System.out.println("Digite somente numeros! ");
        }
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

    @Override
    public String toString() {
        return "CadastrarAnimal{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", sexo=" + sexo +
                ", endereco='" + endereco + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", raca='" + raca + '\'' +
                '}';
    }
}
