import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Scanner;
import java.io.*;

@RequestMapping(value = "/prop")

public class PropertyController{

//    @GetMapping(value = "/getprop")
//    public String getprop(){
//        File file = new File("/home/yuvrajchandrawanshi/Downloads/training/src/main/resources/application.properties");
//        Scanner sc = new Scanner(file);
//        String result = "";
//        while( sc.hasNextLine()){
//            // if(i == -1)break;
//            result += sc.nextLine();
//        }
//        return result;
//    }


}