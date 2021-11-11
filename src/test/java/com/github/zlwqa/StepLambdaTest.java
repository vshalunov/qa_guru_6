package com.github.zlwqa;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepLambdaTest extends TestBase {

    private static final String REPOSITORY = "zlw-qa/qa_guru_6";

    @Test
    @Owner("Vasilii Shalunov")
    @Feature("Репозитории")
    @Story("Отображение элементов в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка отображения табы Issues в репозитории zlw-qa/qa_guru_6")
    @Link(name = "GitHub", url = "https://github.com")
    public void checkIssueNameInRepositoryTest() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        step("Открыть github.com", () -> {
            open("https://github.com/");
        });
        step("Ввести название репозитория " + REPOSITORY, () -> {
            $("[name=q]").setValue("zlw-qa/qa_guru_6").pressEnter();
        });
        step("В результате поиска перейти в репозиторий " + REPOSITORY, () -> {
            $(linkText("zlw-qa/qa_guru_6")).click();
        });
        step("Проверить, что таб Issues существует в репозитории " + REPOSITORY, () -> {
            $("#issues-tab").shouldHave(text("Issues"));
            lifecycle.addAttachment("Screenshot репозитория " + REPOSITORY, "image/png",
                    "png", takeScreenshot());
        });

    }

    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
