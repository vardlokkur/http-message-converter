package com.blogspot.vardlokkur.httpmessageconverter;

import javax.annotation.concurrent.Immutable;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Collections.emptySet;

/**
 * @author Warlock
 */
@Immutable
public final class Team {

    private final Set<TeamMember> members;

    public Team(final Set<TeamMember> members) {
        this.members = (null == members) ? null : new LinkedHashSet<>(members);
    }

    public Set<TeamMember> getMembers() {
        return (null == members) ? emptySet() : new LinkedHashSet<>(members);
    }

}
