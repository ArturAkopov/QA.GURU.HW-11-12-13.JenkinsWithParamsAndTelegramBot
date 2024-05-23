package pages;

import com.codeborne.selenide.SelenideElement;
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

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        DropBanner.dropBanner();
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage setHobby(String hobby) {
        hobbiesWrapperInput.$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage uploadFile(String file) {
        uploadFileInput.uploadFromClasspath(file);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress).pressEnter();
        return this;
    }

    public PracticeFormPage setState(String state) {
        stateInput.click();
        stateAndCity.setStateOrCity(state);
        return this;
    }

    public PracticeFormPage setCity(String city) {
        cityInput.click();
        stateAndCity.setStateOrCity(city);
        return this;
    }

    public PracticeFormPage submitClick() {
        submit.click();
        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        resultPracticeForm.checkResultForm(key, value);
        return this;
    }

    public void checkAbsenceFormResult() {
        resulModalWindow.shouldNotBe(visible);
    }
}
