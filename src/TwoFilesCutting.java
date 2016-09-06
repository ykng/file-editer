import java.io.*;

public class TwoFilesCutting{
    public static void main(String[] args) throws Exception {
        try (
            BufferedReader brLoad1 = new BufferedReader(new FileReader(new File(args[0])));
            BufferedReader brLoad2 = new BufferedReader(new FileReader(new File(args[1])));
            BufferedReader brExeTime = new BufferedReader((new FileReader(new File(args[2]))));
            FileWriter fw = new FileWriter(new File(args[3]), true)
        ){
            String exeTime = extractExeTime(brExeTime);

            writeData(brLoad1, fw);
            writeData(brLoad2, fw);

            fw.write(exeTime);
            fw.write('\n');

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String extractExeTime(BufferedReader br) throws  Exception {
        String line;
        String exeTime="";

        while ((line = br.readLine()) != null) {
            if (line.startsWith("real")) {
                String stringTime = line.substring(5);
                int intTime = (int) Double.parseDouble(stringTime);
                exeTime = String.valueOf(intTime);

                break;
            }
        }

        return exeTime;
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
