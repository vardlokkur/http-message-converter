package com.blogspot.vardlokkur.httpmessageconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Warlock
 */
@RestController
public class TeamDetailsController {

    @GetMapping("/teams/{teamId}/")
    public Team read() {
        final Set<TeamMember> members = new LinkedHashSet<>();
        members.add(new TeamMember("Albert Einstein", LocalDate.of(1879, 3, 14)));
        members.add(new TeamMember("Benjamin Franklin", LocalDate.of(1706, 1, 17)));
        members.add(new TeamMember("Isaac Newton", LocalDate.of(1643, 1, 4)));
        return new Team(members);
    }

}
