package Model;

import java.time.LocalDate;

public class Forestilling {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public Forestilling(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - " + startDate + " til " + endDate;
    }
}
