import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by Kazuki on 2016/09/09.
 */
public class TFCForSlave {
    public static void main(String[] args) throws Exception {
        try (
                BufferedReader brLoad1 = new BufferedReader(new FileReader(new File(args[0])));
                BufferedReader brLoad2 = new BufferedReader(new FileReader(new File(args[1])));
                FileWriter fw = new FileWriter(new File(args[3]), true)
        ){
            writeData(brLoad1, fw);
            writeData(brLoad2, fw);
            fw.write('\n');

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeData(BufferedReader br, FileWriter fw) throws Exception {
        String line;

        while ((line = br.readLine()) != null) {
            if (line.startsWith("#class")) {
                // Once the specification of "tgls" is changed, it need to be changed.
                String number = line.substring(11);

                fw.write(number);
                fw.write(',');
            }
        }
    }
}
