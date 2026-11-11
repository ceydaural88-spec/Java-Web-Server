import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SimpleWebServer {

    private static final int PORT = 1989;

    public static void main(String[] args) {
        System.out.println("Web Sunucusu " + PORT + " portunda başlatılıyor...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu hazır. Tarayıcıdan http://localhost:" + PORT + " adresine gidin.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                // Her istemci isteğini ayrı bir izlekte (thread) ele alalım
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Sunucu hatası: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {

    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream out = clientSocket.getOutputStream()
        ) {
            // İstemciden gelen HTTP isteğinin ilk satırını oku
            String requestLine = in.readLine();
            if (requestLine != null && !requestLine.isEmpty()) {
                System.out.println("Gelen İstek: " + requestLine);
            }

            // HTML İçeriğini Oluştur
            String htmlContent = generateHtmlResponse();
            byte[] htmlBytes = htmlContent.getBytes(StandardCharsets.UTF_8);

            // HTTP 200 OK Yanıt Başlıkları (Response Headers)
            String httpResponse = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: " + htmlBytes.length + "\r\n" +
                    "Connection: close\r\n" +
                    "\r\n";

            // Başlıkları ve gövdeyi istemciye gönder
            out.write(httpResponse.getBytes(StandardCharsets.UTF_8));
            out.write(htmlBytes);
            out.flush();

        } catch (IOException e) {
            System.err.println("İstemci işleme hatası: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Soket kapatma hatası: " + e.getMessage());
            }
        }
    }

    private String generateHtmlResponse() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"tr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Öğrenci Biyografisi</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "            background-color: #f4f7f6;\n" +
                "            color: #333333;\n" +
                "            margin: 40px;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "        .card {\n" +
                "            background-color: #ffffff;\n" +
                "            border-radius: 10px;\n" +
                "            padding: 30px;\n" +
                "            box-shadow: 0 4px 8px rgba(0,0,0,0.1);\n" +
                "            max-width: 700px;\n" +
                "            margin: 0 auto;\n" +
                "        }\n" +
                "        h1 {\n" +
                "            color: #1a5276;\n" +
                "            border-bottom: 2px solid #1a5276;\n" +
                "            padding-bottom: 10px;\n" +
                "            font-size: 28px;\n" +
                "        }\n" +
                "        h2 {\n" +
                "            color: #5d6d7e;\n" +
                "            font-size: 20px;\n" +
                "            margin-top: -10px;\n" +
                "        }\n" +
                "        p {\n" +
                "            font-size: 16px;\n" +
                "            text-align: justify;\n" +
                "        }\n" +
                "        .highlight {\n" +
                "            color: #e74c3c;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"card\">\n" +
                "        <h1>Ceyda Ural</h1>\n" +
                "        <h2>Öğrenci No: 1250505027</h2>\n" +
                "        <hr>\n" +
                "        <h3>Biyografi</h3>\n" +
                "        <p>Merhaba, ben <span class=\"highlight\">Ceyda Ural</span>. Kırklareli Üniversitesi Yazılım Mühendisliği Bölümü 2. sınıf öğrencisiyim.</p>\n" +
                "        <p>Yazılım geliştirme sürecinde <span class=\"highlight\">C, Java ve SQL</span> gibi teknolojiler üzerinde çalışmalar sürdürmekteyim. Temel sistem programlama, soket mimarileri ve nesne yönelimli yazılım tasarımı ilgi alanlarım arasındadır.</p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}