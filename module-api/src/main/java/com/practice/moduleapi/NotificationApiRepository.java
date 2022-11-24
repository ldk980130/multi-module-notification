package com.practice.moduleapi;

import java.util.List;

import com.practice.modulecommon.Notification;
import com.practice.modulecommon.NotificationRepository;
import com.practice.modulecommon.PushStatus;

public interface NotificationApiRepository extends NotificationRepository {

    List<Notification> findByPushStatus(PushStatus pushStatus);
}
