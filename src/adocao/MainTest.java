package adocao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainTest {

        private static ArrayList<CadastrarAnimal> buscarPets(ArrayList<CadastrarAnimal> pets,
                                                             TipoAnimal tipoFiltro,
                                                             int criterio1, String informacao1,
                                                             Integer criterio2, String informacao2) {
            ArrayList<CadastrarAnimal> resultados = new ArrayList<>();

            for (CadastrarAnimal pet : pets) {
                boolean matches = true;

                // Filtro por tipo
                if (tipoFiltro != null && pet.getTipo() != tipoFiltro) {
                    matches = false;
                }

                // Primeiro critério
                if (matches && !aplicaCriterio(pet, criterio1, informacao1)) {
                    matches = false;
                }

                // Segundo critério (se existir)
                if (matches && criterio2 != null && !aplicaCriterio(pet, criterio2, informacao2)) {
                    matches = false;
                }

                if (matches) {
                    resultados.add(pet);
                }
            }

            return resultados;
        }

        private static boolean aplicaCriterio(CadastrarAnimal pet, int criterio, String informacao) {
            if (informacao == null || informacao.trim().isEmpty()) return true;

            String valorBusca = informacao.toLowerCase().trim();

            switch (criterio) {
                case 1: // Nome
                    return pet.getNome().toLowerCase().contains(valorBusca);
                case 2: // Sexo
                    return pet.getSexo().toString().equalsIgnoreCase(valorBusca);
                case 3: // Idade
                    try {
                        double idadeBusca = Double.parseDouble(valorBusca);
                        return pet.getIdade() == idadeBusca;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                case 4: // Peso
                    try {
                        double pesoBusca = Double.parseDouble(valorBusca);
                        return pet.getPeso() == pesoBusca;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                case 5: // Raça
                    return pet.getRaca().toLowerCase().contains(valorBusca);
                case 6: // Endereço
                    String enderecoCompleto = (pet.getRua() + " " + pet.getCidade()).toLowerCase();
                    return enderecoCompleto.contains(valorBusca);
                default:
                    return false;
            }
        }

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
                ifi.savedPet(cadastrarAnimal);
                System.out.println("Pet cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar pet: " + e.getMessage());
            }
             break;
            case 2:
                System.out.println("Escolha o tipo de animal que você gostaria de escolher?");
                System.out.println("1. Cachorro");
                System.out.println("2. Gato");
                System.out.println("3. Qualquer tipo");
                int opc = sc.nextInt(); sc.nextLine();
                TipoAnimal tipoFiltro = null;
                if(opc == 1){
                     tipoFiltro = TipoAnimal.Cachorro;
                } else if(opc == 2){
                    tipoFiltro = TipoAnimal.Gato;
            }

                System.out.println(" - Sistema de busca - ");
                System.out.println("Por qual meio abaixo você gostaria de encontrar o pet?");
                System.out.println("1. Nome | 2. Sexo | 3. Idade | 4. Peso | 5. Raça | 6. Endereço");
                int criterio1 = sc.nextInt(); sc.nextLine();

                System.out.println("Agora informe a informação sobre essa opção: ");
                String informacao1 = sc.nextLine();

                System.out.println("Gostaria de adicionar mais um meio de busca?(S/N) ");
                String busca = sc.nextLine();
                Integer criterio2 = null;
                String informacao2 = null;
                if(busca.equalsIgnoreCase("S")){
                    System.out.println("1. Nome | 2. Sexo | 3. Idade | 4. Peso | 5. Raça | 6. Endereço"  );
                     criterio2 = sc.nextInt(); sc.nextLine();

                    System.out.println("Agora informe a informação sobre essa opção: ");
                     informacao2 = sc.nextLine();

                }
                List<CadastrarAnimal> encontrar = buscarPets(ca, tipoFiltro, criterio1, informacao1, criterio2, informacao2);
                // EXIBIR RESULTADOS
                if (encontrar.isEmpty()) {
                    System.out.println("Nenhum pet encontrado com os critérios informados.");
                } else {
                    System.out.println("\n=== RESULTADOS DA BUSCA ===");
                    for (int i = 0; i < encontrar.size(); i++) {
                        CadastrarAnimal pet = encontrar.get(i);
                        System.out.println((i + 1) + ". " +
                                pet.getNome() + " - " +
                                pet.getTipo() + " - " +
                                pet.getSexo() + " - " +
                                pet.getRua() + ", " + pet.getCidade() + " - " +
                                pet.getIdade() + " anos - " +
                                pet.getPeso() + "kg - " +
                                pet.getRaca());
                    }
                }
                break;
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
