package com.github.zlwqa;

import com.github.zlwqa.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest extends TestBase {

    private static final String REPOSITORY = "zlw-qa/qa_guru_6";
    private final WebSteps steps = new WebSteps();

    @Test
    public void checkIssueNameInRepositoryTest() {

        steps.openMainPage()
                .searchForRepository(REPOSITORY)
                .goToRepository(REPOSITORY)
                .checkIssueNameInRepository();

    }
}
