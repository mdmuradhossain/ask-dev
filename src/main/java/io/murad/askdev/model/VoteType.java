package io.murad.askdev.model;

import io.murad.askdev.exception.AskDevException;

import java.util.Arrays;

public enum VoteType {

    UPVOTE(1), DOWNVOTE(-1);
    private int direction;

    VoteType(int direction){

    }
    public static VoteType lookup(Integer direction){
        return Arrays.stream(VoteType.values())
                .filter(value-> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(()-> new AskDevException("Vote not found"));
    }

    private Integer getDirection() {
    return this.direction;
    }
}
