package org.giovanni.MicroServicesMacroGains;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHER("other"),
    PREFER_NOT_TELL("not_informed");

    private final String opt;
    Gender(String opt){
        this.opt = opt;
    }
    public String getOpt(){
        return opt;
    }
}