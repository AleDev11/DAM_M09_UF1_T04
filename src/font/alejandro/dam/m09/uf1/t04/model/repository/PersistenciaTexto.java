package font.alejandro.dam.m09.uf1.t04.model.repository;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PersistenciaTexto {
    public void save(String nomFitxer, String contingut) {
        File file = new File(nomFitxer);

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(contingut);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void save(String fichero, String contenido, boolean agregarAlContenidoExistente) {
        File file = new File(fichero);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file, agregarAlContenidoExistente);

            bufferedWriter = new BufferedWriter(fileWriter);

            if (contenido != null && contenido.length() > 0) {
                bufferedWriter.write(contenido);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        finally {

            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }



    public String readOptimitzat(String fichero) {

        String resultat = null;
        File file = new File(fichero);

        StringBuilder sb = new StringBuilder();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(fileReader);

            String linia = bufferedReader.readLine();
            while (linia != null) {
                sb.append(linia);
                linia = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

        resultat = sb.toString();
        return resultat;
    }
}
