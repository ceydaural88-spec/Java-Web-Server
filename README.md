Markdown
# Java Socket HTTP Web Server (Port 1989)

Bu proje, Kırklareli Üniversitesi Yazılım Mühendisliği Bölümü ödev gereksinimleri doğrultusunda, herhangi bir 3. parti çatı (framework) veya dış kütüphane kullanılmaksızın yalnızca Java standart kütüphaneleri (`java.net`, `java.io`) kullanılarak geliştirilmiş bir HTTP Web Sunucusudur.

---

## 📌 Proje Hakkında

Sunucu, TCP/IP protokolü üzerinden `1989` numaralı portu dinler ve web tarayıcılarından gelen taleplere custom CSS ve HTML bileşenleri ile biçimlendirilmiş öğrenci biyografi sayfasını sunar.

* **Erişim Portu:** 1989
* **Protokol:** HTTP/1.1
* **Çoklu İzlek (Multithreading):** Var (Gelen her istemci bağlantısı ayrı bir `Thread` üzerinde işlenir)
* **Tasarım:** SOLID mimari prensiplerine uygun nesne yönelimli tasarım

---

## 👤 Öğrenci Bilgileri

* **Adı Soyadı:** Ceyda Ural
* **Öğrenci No:** 1250505027
* **Bölüm:** Yazılım Mühendisliği

---

## 🛠️ Kurulum ve Çalıştırma

### 1. Depoyu Klonlayın
```bash
git clone [https://github.com/ceydaural88-spec/Java-Web-Server.git](https://github.com/ceydaural88-spec/Java-Web-Server.git)
cd Java-Web-Server
2. Projeyi Derleyin
Bash
javac src/SimpleWebServer.java
3. Sunucuyu Başlatın
Bash
java src/SimpleWebServer
4. Tarayıcıdan Test Edin
Sunucu çalıştıktan sonra herhangi bir web tarayıcısından aşağıdaki adrese gidin:

Plaintext
http://localhost:1989
🏗️ Kullanılan Teknolojiler ve Mimari Kavramlar
ServerSocket & Socket: Sunucu soket dinleme işlemi 1989 portu üzerinden başlatılır. Gelen bağlantı talepleri accept() metodu ile karşılanarak istemci soketine yönlendirilir.

I/O Akışları: BufferedReader ve InputStreamReader ile HTTP isteği okunur; OutputStream ile yanıt başlıkları ve HTML içeriği istemciye iletilir.

SOLID Prensipleri: Sunucu dinleme ve istek işleme sorumlulukları SimpleWebServer ve ClientHandler sınıfları arasında ayrılmıştır (SRP). Kodlar bağımlılıkların tersine çevrilmesi (DIP) ve genişletilebilir yapıda (OCP) tasarlanmıştır.


---

### Güncellenmiş README.md Dosyasını GitHub'a Yükleme

Dosyayı oluşturup kaydettikten sonra terminalde sırasıyla şu **3 komutu** çalıştırarak GitHub'a gönderebilirsin:

```powershell
git add README.md
git commit -m "docs: README.md eklendi"
git push origin main
