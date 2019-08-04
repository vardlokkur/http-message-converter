package com.blogspot.vardlokkur.httpmessageconverter;

import javax.annotation.concurrent.Immutable;
import java.time.LocalDate;

/**
 * @author Warlock
 */
@Immutable
public final class TeamMember {

    private final LocalDate dateOfBirth;

    private final String name;

    public TeamMember(final String name, final LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

}
