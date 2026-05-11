package Imuniku.src.driver; // Tetap gunakan ini jika folder kamu memang seperti ini

import java.sql.Connection; // WAJIB ADA

public class TestKoneksi {

    public static void main(String[] args) {
        // Mencoba memanggil koneksi
        Connection test = DatabaseConnection.getConnection();

        if (test != null) {
            System.out.println("Status: Aplikasi siap digunakan.");
        } else {
            System.out.println("Status: Periksa kembali MySQL service atau Driver JDBC Anda.");
        }
    }
}