package com.blogspot.vardlokkur.httpmessageconverter;

import java.time.LocalDate;
import java.time.Period;

import static java.time.LocalDate.now;

/**
 * @author Warlock
 */
public final class TeamMember {

    private final LocalDate dateOfBirth;

    private final String name;

    public TeamMember(final String name, final LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return Period.between(dateOfBirth, now().plusDays(1))
                     .getYears();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

}
