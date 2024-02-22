package qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "С Новым Годом (2022)";


    @Test
    public void testLambdaStep() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () -> {
        open("https://github.com");
    });
    step("Ищем репозиторий " + REPOSITORY, () -> {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").submit();
    });
    step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
        $(linkText(REPOSITORY)).click();
    });
    step("Открываем таб Issues", () -> {
        $("#issues-tab").click();
    });
    step("Проверяем наличие Issue с текстом " + ISSUE, () -> {
        $(withText(ISSUE)).should(Condition.exist);
    });
}}
