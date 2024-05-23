package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
// (Таблицу с результатами введенных данных тоже вынести в components)
public class ResultPracticeFormComponent {

    public void checkResultForm(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
