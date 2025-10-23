package adocao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
    ImportFile ifi = new ImportFile();
    Scanner sc = new Scanner(System.in);
        ArrayList<CadastrarAnimal> ca = new ArrayList<>();
    int opcao = -1;
    do{
        System.out.println("Menu - Escolha uma das opções abaixo: ");
        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");
        try{
       opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                ifi.readerFile();
                System.out.println("Escreva o nome e sobrenome do pet abaixo: ");
                String nome = sc.nextLine();

                System.out.println("Escreva o tipo do pet(Cachorro/Gato) abaixo: ");
                String tipo = sc.nextLine();

                System.out.println("Qual o sexo do animal (M/F)? ");
                String sexo = sc.nextLine();

                System.out.println("Escreva o endereço que o pet foi encontrado abaixo: ");
                System.out.println("Numero da casa: ");
                String numCasa = sc.nextLine();

                System.out.println("Cidade: ");
                String cidade = sc.nextLine();

                System.out.println("Rua: ");
                String rua = sc.nextLine();

                System.out.println("Bairro: ");
                String endereco = sc.nextLine();

                System.out.println("Qual a idade aproximada do pet?");
                String idade = sc.nextLine();

                System.out.println("Qual o peso aproximado do pet? ");
                String peso = sc.nextLine();

                System.out.println("Qual a raça do pet? ");
                String raca = sc.nextLine();
                try {
                CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
                cadastrarAnimal.setNome(nome);
                cadastrarAnimal.setTipo(TipoAnimal.fromString(tipo));
                cadastrarAnimal.setSexo(SexoAnimal.fromString(sexo));
                cadastrarAnimal.setEndereco(endereco);
                cadastrarAnimal.setNumCasa(numCasa);
                cadastrarAnimal.setCidade(cidade);
                cadastrarAnimal.setRua(rua);
                cadastrarAnimal.setIdade(idade);
                cadastrarAnimal.setPeso(peso);
                cadastrarAnimal.setRaca(raca);

                ca.add(cadastrarAnimal);
                System.out.println("Pet cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar pet: " + e.getMessage());
            }
            break;

            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                break;
        }}catch (InputMismatchException e){
                System.out.println("Entrada invalida escolha somente números ");
                sc.nextLine();
            }
        } while(opcao != 6);



}}
