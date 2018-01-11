import java.io.*;

public class ForWekaPrediction {
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
            String[] num = line.split(",");
            String pTime = num[2];
            bw.write(pTime);
            bw.newLine();
        }
    }

}
