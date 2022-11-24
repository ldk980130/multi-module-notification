package com.practice.modulebatch;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.modulecommon.Notification;
import com.practice.modulecommon.NotificationRepository;
import com.practice.modulecommon.PushStatus;

public interface NotificationBatchRepository extends NotificationRepository {

    List<Notification> findByPushStatusAndPushTimeIsBefore(PushStatus pushStatus, LocalDateTime pushTime);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update Notification n set n.pushStatus = 'COMPLETED' where n.id in :ids")
    void completeAll(@Param("ids") List<Long> ids);
}
