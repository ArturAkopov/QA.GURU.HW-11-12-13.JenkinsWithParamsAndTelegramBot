package pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DropBanner {
    public static void dropBanner(){
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");
    }
}
