package models;

public class Release {

    private int dayOfSprint;
    private int dayRequiredToValidate;

    public Release(int startDay, int duration) {
        this.dayOfSprint = startDay;
        this.dayRequiredToValidate = startDay + duration - 1; // Calculate the end day
    }

    public int getDay() {
        return dayOfSprint;
    }

    public int getDayValidateRelease() {
        return dayRequiredToValidate;
    }


}
