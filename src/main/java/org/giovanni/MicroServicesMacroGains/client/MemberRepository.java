package org.giovanni.MicroServicesMacroGains.client;

import org.springframework.data.jpa.repository.JpaRepository;

interface MemberRepository extends JpaRepository<Member, Long> {
}
