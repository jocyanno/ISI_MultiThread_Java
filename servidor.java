import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {

    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Esperando Conexao");
            Socket conexao = server.accept();
            System.out.println("Chegou conexao!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            String resposta = "HTTP/1.1 200 OK/r/nContent-Type:text/html\n\n<html><title> Aula isi </title><h3>Auls servidor web</h3></html>";

            String s = "";

            while(s != null){
                s = reader.readLine();
                System.out.println(s);

                if (s.contains("Accept-Language")){
                    //enviar resposta
                    conexao.getOutputStream().write(resposta.getBytes());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}