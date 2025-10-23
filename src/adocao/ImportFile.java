package adocao;
import java.io.*;
import java.io.IOException;

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
}


