/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.traveloffice;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import pl.altkom.traveloffice.model.Date;
import pl.altkom.traveloffice.model.Trip;

/**
 *
 * @author altkom
 */
public class FileTest {

    public static void main(String[] args) {
        //readFileIn16Java();
        //readFileIn17Java();

        //writeToFile("ala ma kota\n");
        //readFileIn17Java();
        Trip trip = new Trip(new Date(1, 1, 2014), new Date(15, 01, 2014), "ateny");
        //serializacja(trip);
        //Trip t = deSerializacja();
        //System.out.println(t);
        
        toXML(trip);
        Trip t = fromXML();
        
        System.out.println(t);
    }

    private static Trip deSerializacja() {

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("trip.ser"))) {
            return (Trip) ois.readObject();
        } catch (IOException ex) {
            throw new RuntimeException("problem z zapisem danych do pliku", ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("problem z zapisem danych do pliku", ex);
        }
    }

    private static Trip fromXML() {
        
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream("trip.xml")) ) {
               return (Trip) decoder.readObject();
        } catch (IOException ex) {
            System.out.println("problem z odczytem z XML");
            throw new RuntimeException(ex.getMessage(), ex);
        }
            
    }
    
    private static void toXML(Trip trip) {

        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream("trip.xml"))) {
            encoder.writeObject(trip);
        } catch (IOException ex) {
            System.out.println("problem z zapisem do XML");
        }

    }

    private static void serializacja(Object o) {

        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream("trip.ser"))) {

            oos.writeObject(o);

        } catch (IOException ex) {
            throw new RuntimeException("problem z zapisem danych do pliku", ex);
        }

    }

    private static void writeToFile(String text) {

        File file = new File("test.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(text);
        } catch (IOException ex) {
            System.out.println("obsługa błędu IOException");
            ex.printStackTrace();
        }

    }

    private static void readFileIn17Java() {

        File file = new File("test.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("obsługa błędu IOException");
            ex.printStackTrace();
        }
    }

    private static void readFileIn16Java() {
        File file = new File("test.txt");

        FileReader reader = null;

        try {
            reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (Throwable ex) {
            System.out.println("obsługa błędu Throwable");
            ex.printStackTrace();
        } finally {
            System.out.println("zamykanie");
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                System.out.println("nie udało się zamknąćs");
            }

        }

//        System.out.println("istnieje " + file.exists());
//        
//        file.createNewFile();
//        
//        System.out.println("istnieje " + file.exists());
//        
//        System.out.println(file.getAbsoluteFile());
//        
//        File f = File.createTempFile("mojedane", ".txt");
//        
//        System.out.println("tmp file " + f.getAbsolutePath());
    }

}
