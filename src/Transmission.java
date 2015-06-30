/**
 * Created by koga on 15/06/30.
 */
import jp.ac.it_college.std.nakasone.lib.exam.Communicator;

import java.io.IOException;
import java.util.Scanner;
public class Transmission {
    public static void ss() {
        Communicator comm = new Communicator((msg) -> {
            System.out.println(msg);
        });
        comm.start();
        String name = "s14005:";
        while(true){
            System.out.println("入力してください");
            Scanner scan = new Scanner(System.in);
            String a = scan.next();
            if(a.equals("exit")) {
                try {
                    comm.send(name + "切断しました");
                } catch (IOException var3) {
                    var3.printStackTrace();
                }
                comm.finish();
                break;
            } else {
                try {
                    comm.send(name + a);
                } catch (IOException var3) {
                    var3.printStackTrace();
                }
            }
        }
    }
}