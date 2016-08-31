import java.io.*;

public class TwoFilesCutting{
    public static void main(String[] args) throws Exception {
        try (
            FileReader fr1 = new FileReader(new File(args[0]));
            FileReader fr2 = new FileReader(new File(args[1]));
            BufferedReader br1 = new BufferedReader(fr1);
            BufferedReader br2 = new BufferedReader(fr2);
            FileWriter fw = new FileWriter(new File(args[2]), true)
        ){
            String exeTime = args[3];

            writeData(br1, fw);
            writeData(br2, fw);

            fw.write(exeTime);
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
