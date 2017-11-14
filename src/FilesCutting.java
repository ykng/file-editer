import java.io.*;

public class FilesCutting{
    public static void main(String[] args) throws Exception {
        try (
                BufferedReader brLoad = new BufferedReader(new FileReader(new File(args[0])));
                BufferedReader brReport = new BufferedReader((new FileReader(new File(args[1]))));
                FileWriter fw = new FileWriter(new File(args[2]), true)
        ){
            String lastLine = extractLastLine(brReport);

            // 入力データ量
            writeInputDataAmount(lastLine, fw);

            // トレースデータ
            writeData(brLoad, fw);

            // 実行時間
            writeTime(lastLine, fw);

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

    // hibench.reportの最終行を抽出
    public static String extractLastLine(BufferedReader br) throws Exception {
        String line = "";
        String nextLine;

        while ((nextLine = br.readLine()) != null) {
            line = nextLine;
        }

        return line;
    }

    private static void writeTime(String lastLine, FileWriter fw) throws Exception{
        fw.write(lastLine.split("\\s+")[4].toString());
        fw.write('\n');
    }

    private static void writeInputDataAmount(String lastLine, FileWriter fw) throws Exception {
        fw.write(lastLine.split("\\s+")[3].toString());
        fw.write(',');
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
