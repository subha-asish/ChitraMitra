package com.example.chitramitra;

public class Dates {
    private String maximum;
    private String minimum;

    public Dates(String maximum, String minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    // Getters and Setters (Optional)
    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }
}

