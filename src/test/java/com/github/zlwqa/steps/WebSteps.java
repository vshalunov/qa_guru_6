package com.github.zlwqa.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class WebSteps {

    @Step("Открыть github.com")
    public WebSteps openMainPage() {
        open("https://github.com/");

        return this;
    }

    @Step("Ввести название репозитория {repository}")
    public WebSteps searchForRepository(String repository) {
        $("[name=q]").setValue(repository).pressEnter();

        return this;
    }

    @Step("В результате поиска перейти в репозиторий {repository}")
    public WebSteps goToRepository(String repository) {
        $(linkText(repository)).click();

        return this;
    }

    @Step("Проверить, что таб Issues существует в репозитории zlw-qa/qa_guru_6")
    public WebSteps checkIssueNameInRepository() {
        $("#issues-tab").shouldHave(text("Issues"));

        return this;
    }
}
