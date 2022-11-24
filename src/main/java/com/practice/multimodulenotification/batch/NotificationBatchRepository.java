package com.practice.multimodulenotification.batch;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.multimodulenotification.common.Notification;
import com.practice.multimodulenotification.common.NotificationRepository;
import com.practice.multimodulenotification.common.PushStatus;

public interface NotificationBatchRepository extends NotificationRepository {

    List<Notification> findByPushStatusAndPushTimeIsBefore(PushStatus pushStatus, LocalDateTime pushTime);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update Notification n set n.pushStatus = 'COMPLETED' where n.id in :ids")
    void completeAll(@Param("ids") List<Long> ids);
}
