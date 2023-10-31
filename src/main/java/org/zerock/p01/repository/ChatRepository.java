package org.zerock.p01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.p01.Entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
