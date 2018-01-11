import java.io.*;

public class ArffEditer {
    public static void main(String[] args) throws Exception {
        try (
                BufferedReader brArff = new BufferedReader(new FileReader(new File(args[0])));
                BufferedReader brTgls = new BufferedReader((new FileReader(new File(args[1]))));
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(args[2]), true))
        ){

            String tglsAverage = extractTglsAverage(brTgls);
            replace(bw, brArff, tglsAverage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractTglsAverage(BufferedReader br) throws Exception {
        String line;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int[] chars = new int[7];

        while((line = br.readLine()) != null) {
            for (int i=0; i<7; i++) {
                chars[i] += Integer.valueOf(line.split(",")[i + 1]);
            }
            count++;
        }

        for(int i=0; i<7; i++) {
            sb.append(",").append(String.valueOf(chars[i]/count));
        }

        return sb.append(",").toString();
    }

    private static void replace(BufferedWriter bw, BufferedReader br, String str) throws Exception {
        String line, dsize, etime;

        while ((line = br.readLine()) != null) {
            if (!line.startsWith("@") && line.length() > 0) {
                String[] num = line.split(",");
                dsize = num[0];
                etime = num[num.length - 1];
                bw.write(dsize + str + etime);
                bw.newLine();
            }
        }
    }

}
