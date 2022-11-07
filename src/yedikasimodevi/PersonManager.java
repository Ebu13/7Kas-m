package yedikasimodevi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PersonManager {

    static List<Person> personlist = new ArrayList<Person>();

    public static void add(String name, String surname) throws FileNotFoundException, IOException {
        FileWriter yazici = new FileWriter("kayit.txt", true);
        BufferedWriter yaz = new BufferedWriter(yazici);
        yaz.write(name + "," + surname + ";");
        yaz.close();
        yazici.close();
    }

    public static List<Person> getList() throws FileNotFoundException, IOException {
        char[] array = new char[100];
        String name = null;
        String surname = null;
        boolean ns = true;
        FileReader file = new FileReader("kayit.txt");
        BufferedReader input = new BufferedReader(file);
        input.read(array);
        input.close();
        for (int i = 0; array[i] != '\0'; i++) {
            if (array[i] == ',') {
                ns = false;
            } else if (array[i] == ';') {
                ns = true;
                Person person = new Person(name, surname);
                personlist.add(person);
                name = null;
                surname = null;
            } else {
                if (ns == true) {
                    if (name == null) {
                        name = "" + array[i];
                    } else {
                        name += array[i];
                    }
                } else {
                    if (surname == null) {

                        surname = "" + array[i];
                    } else {
                        surname += array[i];
                    }
                }
            }
        }
        return personlist;
    }
}
