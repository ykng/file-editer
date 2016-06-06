/**
 * Created by Kazuki on 2016/06/06.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws Exception{
        try{
            File readfile = new File(args[0]);
            File[] writefile = new File[7];
            for(int i=0; i<7; i++){
                writefile[i] = new File(args[i+1]);
            }

            FileReader fr = new FileReader(readfile);
            FileWriter[] fw = new FileWriter[7];
            for(int i=0; i<7; i++){
                fw[i] = new FileWriter(writefile[i]);
            }

            int i = 0;
            int[] str = new int[10000];

            while((str[i] = fr.read()) != -1){
                if(str[i] == '\n'){
                    int index = str[i-2] - '0';
                    if(index >= 0 && index <=6){
                        for(int n=0; n<i-2; n++)  fw[index].write(str[n]);
                        fw[index].write('\n');
                        i = -1;
                    }
                }
                i++;
            }

            fr.close();
            for(int n=0; n<7; n++){
                fw[n].close();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}