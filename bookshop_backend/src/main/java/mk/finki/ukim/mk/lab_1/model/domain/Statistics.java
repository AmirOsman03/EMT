package mk.finki.ukim.mk.lab_1.model.domain;

import lombok.Data;

@Data
public class Statistics {
    private String mostRentedBookTitle;
    private String mostRentedAuthorName;
    private String mostRentedUserId;

    public Statistics(String mostRentedAuthorName, String mostRentedBookTitle, String mostRentedUserId) {
        this.mostRentedAuthorName = mostRentedAuthorName;
        this.mostRentedBookTitle = mostRentedBookTitle;
        this.mostRentedUserId = mostRentedUserId;
    }

    public Statistics() {}
}

