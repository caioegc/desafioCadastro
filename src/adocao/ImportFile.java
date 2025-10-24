package adocao;
import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImportFile {
        File file = new File("formulario.txt");

        public void readerFile() {
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (Exception e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        public void savedPet(CadastrarAnimal pet) {
            try{ File f = new File("petsCadastrados");
                if (!f.exists()) {
                    if (!f.mkdirs()) {
                        throw new IOException("Não foi possível criar a pasta petsCadastrados");
                    }
                }

            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
            String dataFormata = agora.format(formatter);
            String nomePet = pet.getNome().toUpperCase().replaceAll("[^A-Z0-9]", "");
            String arquivoFormated = dataFormata + "-" + nomePet + ".txt";


                File file1 = Paths.get("petsCadastrados", arquivoFormated).toFile();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file1))) {
                bw.write(pet.getNome());
                bw.newLine();
                bw.write(pet.getTipo().toString());
                bw.newLine();
                bw.write(pet.getSexo().toString());
                bw.newLine();
                bw.write(pet.getRua() + ", " + pet.getNumCasa() + ", " + pet.getCidade());
                bw.newLine();
                bw.write(pet.getIdade() + " anos");
                bw.newLine();
                bw.write(pet.getPeso() + "kg");
                bw.newLine();
                bw.write(pet.getRaca());

            }
            System.out.println("\n✅ Arquivo salvo em: " + file1.getAbsolutePath());
        }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}








