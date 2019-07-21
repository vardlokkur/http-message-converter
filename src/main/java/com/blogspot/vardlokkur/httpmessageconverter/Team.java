package com.blogspot.vardlokkur.httpmessageconverter;

import java.util.Set;

public final class Team {

    private final Set<TeamMember> members;

    public Team(final Set<TeamMember> members) {
        this.members = members;
    }

    public Set<TeamMember> getMembers() {
        return members;
    }
    
}
