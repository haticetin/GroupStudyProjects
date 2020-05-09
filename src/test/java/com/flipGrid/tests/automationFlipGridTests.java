package com.flipGrid.tests;

        import com.flipGrid.utilities.BrowserFactory;
        import com.flipGrid.utilities.ResultUtility;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import java.util.Set;
        import java.util.concurrent.TimeUnit;

public class automationFlipGridTests {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");// WebDriver

        driver.get("https://my.flipgrid.com");

        driver.manage().window().maximize(); // ekranı full screen yapıyoruz. pop up pencereleri arasındaki geçişlerdeki sorunları min etme için

        String parent = driver.getWindowHandle();
        // parent da mevcut pencerenin unique identifier tutar.

        //driver.findElement(By.tagName("button"));
       driver.findElement(By.cssSelector("button[data-testid='googleSSOButton__button__login']")).click(); //css e cevirdik
       Thread.sleep(2000); // yeni acılan pop up pencerenin tam yuklenmesı ıcın bekle


        Set<String> allWindowsHandle = driver.getWindowHandles();
        String child="";
        for (String handle : allWindowsHandle){
           child = handle;
        }
        System.out.println("parent = " + parent);
        System.out.println("child = " + child);


        driver.switchTo().window(child);  // parent dan chil'a yani yeni açılan pencereye geçtik!!!
        driver.findElement(By.id("identifierId")).sendKeys("kendi maili gir babam",Keys.ENTER);
      // WebElement mailInput = driver.findElement(By.id("identifierId"));

        //Thread.sleep(2000);
        //driver.findElement(By.xpath("(//span[@class ='RveJvd snByac']) [1]")).click();

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // password ıcın bekleme , kendisinden sonraki islemi gösteriyor
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sifreni gir burayaa", Keys.ENTER);

       driver.switchTo().window(parent); // ilk buyuk ekranlı pencereye geri donduk

      WebElement sayac = driver.findElement(By.xpath("(//td[@class='table__cell  text-center hide-for-medium-down'])[1]"));
      String firstCount = sayac.getText();  // sayacın ilk degerını get text metoduyla aldık ve string olarak SAKLADIK

        // otomasyon koy buraya loop u
        driver.findElement(By.xpath("//button[@data-testid='myResponses__button__viewFeedback0']")).click();

     Thread.sleep(6000);
     Actions windowAction = new Actions(driver);
     windowAction.sendKeys(Keys.ESCAPE).build().perform();  // ESC ye boş ekran da, elemnt e yonlendirme olmadan basmak ıccın


    String lastCount = sayac.getText();

        System.out.println("lastCount = " + lastCount);
        System.out.println("firstCount = " + firstCount);

        int firstCountInt = Integer.valueOf(firstCount);
        int lastCountInt = Integer.valueOf(lastCount);

        ResultUtility.verifyEquals(lastCountInt,firstCountInt,1);


        driver.quit();

    }
}
