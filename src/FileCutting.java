/**
 * Created by Kazuki on 2016/06/06.
 */
import java.io.*;

public class FileCutting {
    public static void main(String[] args)throws Exception{
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        try{
            //第1引数:読込ファイル名
            //第2引数:出力ファイル名(.arff)
            //第3引数:実行時間
            File readfile = new File(args[0]);
            File writefile = new File(args[1]);
            fr = new FileReader(readfile);
            br = new BufferedReader(fr);
            fw = new FileWriter(writefile, true);
            String exeTime = args[2];

            //arffファイルの形式に従って適宜変更
            //新しいarffファイルを作るときのみ実行
            /*
            fw.write("@relation PredictExeTime\n\n");
            fw.write("@attribute class0 real\n");
            fw.write("@attribute class1 real\n");
            fw.write("@attribute class2 real\n");
            fw.write("@attribute class3 real\n");
            fw.write("@attribute class4 real\n");
            fw.write("@attribute class5 real\n");
            fw.write("@attribute class6 real\n");
            fw.write("@attribute exeTime real\n\n");
            fw.write("@data\n");
            */

            int count = 0;
            String line;

            while((line = br.readLine()) != null){
                if(line.startsWith("#class")){
                    String number = line.substring(11);
                    fw.write(number);
                    if(count < 7){
                        fw.write(',');
                        count++;
                    }
                }
            }
            fw.write(exeTime);
            fw.write('\n');
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }finally{
            try{
                fr.close();
                br.close();
                fw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}