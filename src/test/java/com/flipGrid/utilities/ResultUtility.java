package com.flipGrid.utilities;

public class ResultUtility {
    // bu class da 1 method oluştur. Bu method bize 2 sayaç arasında olması gereken fark varmı,
    // otomasyon testi başarılı mı? onu söyleyecek!!

    public static void verifyEquals (int expected, int actual, int quantity){
        // expected otomasyon sonrası sayaç sayısı
        // actual ise sayfayı ilk açtığımızdaki sayaç sayısı
        // quantity bizim belirleyeceğimiz/gireceğimiz otomasyon tekrar sayısı
        if (expected == actual + quantity){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
    }

}
