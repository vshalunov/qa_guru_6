package com.github.zlwqa;

import com.github.zlwqa.steps.WebSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest extends TestBase {

    private static final String REPOSITORY = "zlw-qa/qa_guru_6";
    private final WebSteps steps = new WebSteps();

    @Test
    @Owner("Vasilii Shalunov")
    @Feature("Репозитории")
    @Story("Отображение элементов в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Step annotated. Отображение табы Issues в репозитории zlw-qa/qa_guru_6")
    @Link(name = "GitHub", url = "https://github.com")
    public void checkIssueNameInRepositoryTest() {

        steps.openMainPage()
                .searchForRepository(REPOSITORY)
                .goToRepository(REPOSITORY)
                .checkIssueNameInRepository();

    }
}
