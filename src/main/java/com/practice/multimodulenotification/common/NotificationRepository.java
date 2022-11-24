package com.practice.multimodulenotification.common;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByPushStatus(PushStatus pushStatus);

    List<Notification> findByPushStatusAndPushTimeIsBefore(PushStatus pushStatus, LocalDateTime pushTime);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update Notification n set n.pushStatus = 'COMPLETED' where n.id in :ids")
    void completeAll(@Param("ids") List<Long> ids);
}
