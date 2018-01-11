import java.io.*;

public class ArffCutter {
    public static void main(String[] args) throws Exception {
        try (
                BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(args[1]), true))
        ){
            cut(br, bw);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cut(BufferedReader br, BufferedWriter bw) throws Exception {
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.startsWith("@") && line.length() > 0) {
                String[] num = line.split(",");
                String dsize = num[0];
                String etime = num[num.length - 1];
                bw.write(dsize + "," + etime);
            } else {
                bw.write(line);
            }
            bw.newLine();
        }
    }

}
