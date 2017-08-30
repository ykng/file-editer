import java.io.*;

public class FilesCutting{
    public static void main(String[] args) throws Exception {
        try (
                BufferedReader brLoad = new BufferedReader(new FileReader(new File(args[0])));
                BufferedReader brExeTime = new BufferedReader((new FileReader(new File(args[1]))));
                FileWriter fw = new FileWriter(new File(args[2]), true)
        ){
            String exeTime = extractTime(brExeTime);

            writeData(brLoad, fw);

            fw.write(exeTime);
            fw.write('\n');

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    // timeコマンドで計測する場合
//    public static String extractExeTime(BufferedReader br) throws  Exception {
//        String line;
//        String exeTime="";
//
//        while ((line = br.readLine()) != null) {
//            if (line.startsWith("real")) {
//                String stringTime = line.substring(5);
//                int intTime = (int) Double.parseDouble(stringTime);
//                exeTime = String.valueOf(intTime);
//
//                break;
//            }
//        }
//
//        return exeTime;
//    }

    // hibench.reportを利用する場合
    private static String extractTime(BufferedReader br) throws Exception{
        String line = "";
        String nextline;

        while ((nextline = br.readLine()) != null) {
            line = nextline;
        }

        return line.split("\\s+")[4].toString();
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
