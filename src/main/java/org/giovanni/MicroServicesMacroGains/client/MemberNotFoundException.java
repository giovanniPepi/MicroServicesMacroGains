package org.giovanni.MicroServicesMacroGains.client;

class MemberNotFoundException extends RuntimeException {
    MemberNotFoundException(Long id) {
        super("Could not find member " + id);
    }
}
