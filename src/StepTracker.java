public class StepTracker {
    private int threshold;
    private int steps;
    private int days;
    private int active;

    public StepTracker(int threshold){
        this.threshold = threshold;
        this.steps = 0;
        this.days = 0;
        this.active = 0;

    }

    public int activeDays(){
        return this.active;
    }
    public double averageSteps(){
        if(this.days==0){
            return 0.0;
        }
        return (this.steps*1.0)/this.days;
    }
    public void addDailySteps(int steps){
        this.steps+=steps;
        if(steps>=threshold){
            this.active++;
        }

        this.days++;
    }

    public int getTotalSteps(){
        return this.steps;
    }
    public int getDays(){
        return this.days;
    }

    public int getStepsForActiveDay(){
        return this.threshold;
    }
    public int getActiveDays(){
        return this.active;
    }


}
