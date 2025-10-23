package adocao;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
    ImportFile ifi = new ImportFile();
    Scanner sc = new Scanner(System.in);
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
