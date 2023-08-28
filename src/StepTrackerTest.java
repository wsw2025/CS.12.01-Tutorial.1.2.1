import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepTrackerTest {

    private StepTracker stepTracker;

    @BeforeEach
    void setUp() {

        stepTracker = new StepTracker(10000);
    }

    @AfterEach
    void tearDown() {
        stepTracker = null;
    }

    @Test
    void averageStepsNoDays() {

        assertEquals(0.0,stepTracker.averageSteps());

    }

    @Test
    void activeDaysNoDays() {

        assertEquals(0,stepTracker.activeDays());

    }

    @Test
    void totalDaysNoDays() {

        assertEquals(0,stepTracker.getDays());

    }

    @Test
    void stepsForActiveDays() {

        assertEquals(10000,stepTracker.getStepsForActiveDay());

    }

    @Test
    void addDailyStepsIncreasesDay() {

        stepTracker.addDailySteps(9000);
        assertEquals(1, stepTracker.getDays());

    }

    @Test
    void addDailyStepsIncreasesSteps() {

        stepTracker.addDailySteps(9000);
        assertEquals(9000, stepTracker.getTotalSteps());

    }

    @Test
    void addDailyStepsUnderActiveStepRequirement() {

        stepTracker.addDailySteps(9000);
        assertEquals(0, stepTracker.getActiveDays());

    }

    @Test
    void addDailyStepsEqualToActiveStepRequirement() {

        stepTracker.addDailySteps(10000);
        assertEquals(1, stepTracker.getActiveDays());

    }

    @Test
    void addDailyStepsOverActiveStepRequirement() {

        stepTracker.addDailySteps(11000);
        assertEquals(1, stepTracker.getActiveDays());

    }

    @Test
    void addMultipleDailyStepsOverActiveStepRequirement() {

        stepTracker.addDailySteps(11000);
        stepTracker.addDailySteps(12000);
        stepTracker.addDailySteps(16500);
        assertEquals(3, stepTracker.getActiveDays());

    }

    @Test
    void addMultipleDailyStepsUnderAndOverActiveStepRequirement() {

        stepTracker.addDailySteps(11000);
        stepTracker.addDailySteps(9000);
        stepTracker.addDailySteps(16500);
        assertEquals(2, stepTracker.getActiveDays());

    }

    @Test
    void addMultipleDailyStepsTotalSteps() {

        stepTracker.addDailySteps(11000);
        stepTracker.addDailySteps(9000);
        stepTracker.addDailySteps(16500);
        assertEquals(36500, stepTracker.getTotalSteps());

    }

    @Test
    void addMultipleDailyStepsTotalDays() {

        stepTracker.addDailySteps(11000);
        stepTracker.addDailySteps(9000);
        stepTracker.addDailySteps(16500);
        assertEquals(3, stepTracker.getDays());

    }

}