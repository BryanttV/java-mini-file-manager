package logic.encapsulate;

import comunication.IArchiver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Bryann_Valderrama
 */
public class PortArchiver implements IArchiver {

    @Override
    public boolean save(String path, String text) {
        try {
            PrintStream output = new PrintStream(path);
            output.println(text);
            output.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    @Override
    public String load(String path) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(path));
            String content = "";
            String line = input.readLine();
            while (line != null) {
                content += line + "\n";
                line = input.readLine();
            }
            input.close();
            return content;
        } catch (IOException e) {
            return null;
        }
    }

}
