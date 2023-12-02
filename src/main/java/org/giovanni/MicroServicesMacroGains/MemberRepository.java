package org.giovanni.MicroServicesMacroGains;

import org.springframework.data.jpa.repository.JpaRepository;

interface MemberRepository extends JpaRepository<Member, Long> {
}
