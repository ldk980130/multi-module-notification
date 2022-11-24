package com.practice.multimodulenotification.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByPushStatus(PushStatus pushStatus);
}
