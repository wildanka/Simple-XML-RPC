/**
 * Created by HP on 1/9/2017.
 */
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.util.Base64;

public class JavaClient {
     public static void main(String[] args){

         int xmlrpcConnTimeout = 10000;
         int xmlrpcReplyTimeout = 60000;
         try {
             /*XmlRpcClient client = new XmlRpcClient();
             XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
             config.setServerURL(new URL("http://127.0.0.1/arpc/index.php"));
             config.setConnectionTimeout(xmlrpcConnTimeout);
             config.setReplyTimeout(xmlrpcReplyTimeout);
             client.setConfig(config);
             Vector params = new Vector();

             params.addElement(new Integer(17));
             params.addElement(new Integer(13));

             Object result = client.execute("sample.sum", params);*/

             Tanggalizer waktu = new Tanggalizer(); //input tanggal
             System.out.println("Masukkan no. Handphone: \n");
             Scanner inputHP = new Scanner(System.in);
             System.out.println("Masukkan Pesan: ");
             Scanner inputChat = new Scanner(System.in);

             //memasukkan inputan yang diperlukan kedalam variabel
             String chat = inputChat.nextLine();
             String hp = inputHP.nextLine();
             String waktuTerkirim = waktu.getWaktu()+" "+waktu.getTanggal();

             XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
             //config.setServerURL(new URL("http://localhost/arpc/index.php"));
             //config.setServerURL(new URL("http://192.168.1.7/Deon/a/index.php"));
             XmlRpcClient client = new XmlRpcClient();
             client.setConfig(config);
             /*Object[] params = new Object[]{new String("wildan"), new Integer(9), new String(chat)};*/
             Object[] params = new Object[]{new String(hp), new String(chat), new String(waktuTerkirim)};
             String result = (String) client.execute("username", params);
             String chatText = (String) client.execute("chat", params);
             String timestamp = (String) client.execute("timestamp",params);
             System.out.println(timestamp+" Terkirim");
             System.out.println(result);
             System.out.println(chatText);

          /*   config.setServerURL(new URL("http://127.0.0.1/arpc/index.php"));
             config.setConnectionTimeout(xmlrpcConnTimeout);
             config.setReplyTimeout(xmlrpcReplyTimeout);
             client.setConfig(config);*/



         } catch (Exception exception) {
             System.err.println("JavaClient: "+ exception);
         }
     }
}
