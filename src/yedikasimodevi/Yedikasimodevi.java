package yedikasimodevi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Yedikasimodevi {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File dosya = new File("kayit.txt");
        Frame form=new Frame();
        form.show();
    }

}
