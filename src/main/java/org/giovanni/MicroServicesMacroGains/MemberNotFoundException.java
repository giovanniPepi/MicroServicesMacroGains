package org.giovanni.MicroServicesMacroGains;

class MemberNotFoundException extends RuntimeException {
    MemberNotFoundException(Long id) {
        super("Could not find member " + id);
    }
}
