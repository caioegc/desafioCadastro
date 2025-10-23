package adocao;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastrarAnimal {
    private String nome;
    private TipoAnimal tipo;
    private SexoAnimal sexo;
    private String endereco;
    private String numCasa;
    private String rua;
    private String cidade;
    private Double idade;
    private Double peso;
    private String raca;
    public static final String info = "NÃO INFORMADO";

    public CadastrarAnimal() {
    }

    public CadastrarAnimal(String nome, TipoAnimal tipo, SexoAnimal sexo, String endereco, String numCasa, String rua, String cidade, double idade, double peso, String raca) {
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.endereco = endereco;
        this.numCasa = numCasa;
        this.rua = rua;
        this.cidade = cidade;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try{
        Pattern pattern = Pattern.compile("^[a-zA-Z]+\\s[a-zA-Z]+");
        Matcher matcher = pattern.matcher(nome);
        if (nome.isEmpty()){
            this.nome = info;
        }
        if(matcher.matches()){
            this.nome = nome;
        } else{
            System.out.println("Nome deve ser composto!!");
        }} catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
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

    public void setIdade(String input) {
        try{
         if(input.isEmpty()){
             this.idade = 0.0;
         }
         double valor = Double.parseDouble(input.replace(",", "."));
        if(valor > 20){
        throw new IllegalArgumentException("Idade não pode ser maior que 20");
        }
        else{
            this.idade = valor;
        }
        }
        catch(NumberFormatException e){
            System.out.println("Digite somente numeros! ");
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(String input) {
        try{
            if(input.isEmpty()){
                this.peso = 0.0;
            }
        double valor = Double.parseDouble(input.replace(",", "."));
        if(valor < 0.5 || valor > 60){
          throw  new IllegalArgumentException("Peso inválido");
        } else{
            this.peso = valor;
        }} catch (NumberFormatException e) {
            System.out.println("Digite somente numeros! ");
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(raca);
        if (raca.isEmpty()){
            this.raca = info;
        }
        if(matcher.matches()){
            this.raca = raca;
        } else{
            System.out.println("Somente letras são permitidas.");
        }
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String NumCasa) {
        if(NumCasa.isEmpty()){
        this.numCasa = info;
        } else{
            this.numCasa = numCasa;
        }
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        cidade = cidade;
    }

    @Override
    public String toString() {
        return "CadastrarAnimal{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", sexo=" + sexo +
                ", endereco='" + endereco + '\'' +
                ", idade=" + (idade == 0 ? info  : idade) +
                ", peso=" + (peso == 0 ? info : peso) +
                ", raca='" + raca + '\'' +
                '}';
    }
}
