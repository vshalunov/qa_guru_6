package com.github.zlwqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepLambdaTest extends TestBase {

    private static final String REPOSITORY = "zlw-qa/qa_guru_6";

    @Test
    public void checkIssueNameInRepositoryTest() {

        step("Открыть github.com", () -> {
            open("https://github.com/");
        });
        step("Ввести название репозитория " + REPOSITORY, () -> {
            $("[name=q]").setValue("zlw-qa/qa_guru_6").pressEnter();
        });
        step("В результате поиска перейти в репозиторий " + REPOSITORY, () -> {
            $(linkText("zlw-qa/qa_guru_6")).click();
        });
        step("Проверить, что название Issues существует в репозитории " + REPOSITORY, () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });

    }
}
