package tabeb.anagrammeur;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class Anagrammeur{

    private int id;

    public Anagrammeur() {
        this.id = 2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void replaceInFile(File file) throws IOException {

        File tempFile = File.createTempFile("buffer", ".tmp");
        FileWriter fw = new FileWriter(tempFile);

        Reader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while(br.ready()) {
            fw.write(br.readLine().replaceAll("�", "e")+("\n"));
        }

        fw.close();
        br.close();
        fr.close();

        // Finally replace the original file.
        tempFile.renameTo(file);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
            try {
                File myObj = new File("./Scrabble/game/game/src/main/java/tabeb/anagrammeur/listeFrancais.txt");
                replaceInFile(myObj);

                System.out.println(myObj.canRead());
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }




}