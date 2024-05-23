package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultPracticeFormComponent;
import pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submit = $("#submit"),
            resulModalWindow = $(".modal-content");

    CalendarComponent calendar = new CalendarComponent();
    ResultPracticeFormComponent resultPracticeForm = new ResultPracticeFormComponent();
    StateAndCityComponent stateAndCity = new StateAndCityComponent();

    @Step("Открытие страницы /automation-practice-form")
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        DropBanner.dropBanner();
        return this;
    }

    @Step("Ввод имени {firstName}")
    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Ввод фамилии {lastName}")
    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввод электронной почты {email}")
    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Выбор гендера {gender}")
    public PracticeFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    @Step("Ввод номера телефона {userNumber}")
    public PracticeFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    @Step("Ввод даты рождения {day}.{month}.{year}")
    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Ввод предмета {subject}")
    public PracticeFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Ввод хобби {hobby}")
    public PracticeFormPage setHobby(String hobby) {
        hobbiesWrapperInput.$(byText(hobby)).click();
        return this;
    }

    @Step("Загрузка файла {file}")
    public PracticeFormPage uploadFile(String file) {
        uploadFileInput.uploadFromClasspath(file);
        return this;
    }

    @Step("Ввод текущего адреса {currentAddress}")
    public PracticeFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress).pressEnter();
        return this;
    }

    @Step("Ввод штата {state}")
    public PracticeFormPage setState(String state) {
        stateInput.click();
        stateAndCity.setStateOrCity(state);
        return this;
    }

    @Step("Ввод города {city}")
    public PracticeFormPage setCity(String city) {
        cityInput.click();
        stateAndCity.setStateOrCity(city);
        return this;
    }

    @Step("Подтверждение формы")
    public PracticeFormPage submitClick() {
        submit.click();
        return this;
    }

    @Step("Проверка полей результирующей таблицы {key} : {value}")
    public PracticeFormPage checkResult(String key, String value) {
        resultPracticeForm.checkResultForm(key, value);
        return this;
    }

    @Step("Проверка отсутствия результирующей таблицы")
    public void checkAbsenceFormResult() {
        resulModalWindow.shouldNotBe(visible);
    }
}
