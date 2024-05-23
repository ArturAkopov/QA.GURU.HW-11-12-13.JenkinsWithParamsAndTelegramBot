package tests;


import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.TestData;


public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData testData = new TestData();

    @Test
    void fullFillFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.calendarDay, testData.calendarMonth, testData.calendarYear)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadFile(testData.file)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submitClick()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.calendarDay + " " + testData.calendarMonth + ',' + testData.calendarYear)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.file)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void shortFillFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.calendarDay, testData.calendarMonth, testData.calendarYear)
                .submitClick()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.calendarDay + " " + testData.calendarMonth + ',' + testData.calendarYear);
    }

    @Test
    void incorrectFillFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setDateOfBirth(testData.calendarDay, testData.calendarMonth, testData.calendarYear)
                .submitClick()
                .checkAbsenceFormResult();
    }
}
