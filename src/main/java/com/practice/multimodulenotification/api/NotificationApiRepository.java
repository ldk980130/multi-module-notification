package com.practice.multimodulenotification.api;

import java.util.List;

import com.practice.multimodulenotification.common.Notification;
import com.practice.multimodulenotification.common.NotificationRepository;
import com.practice.multimodulenotification.common.PushStatus;

public interface NotificationApiRepository extends NotificationRepository {

    List<Notification> findByPushStatus(PushStatus pushStatus);
}
