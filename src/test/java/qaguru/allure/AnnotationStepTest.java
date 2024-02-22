package qaguru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import qaguru.pages.WebSteps;



public class AnnotationStepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "С Новым Годом (2022)";

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void annotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithText(ISSUE);

    }
}
