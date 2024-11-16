package dev.otthon.transfermoney.services;

import dev.otthon.transfermoney.client.NotificationClient;
import dev.otthon.transfermoney.entities.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationClient notificationClient;

    public void sendNotification(Transfer transfer) {
        try {
            logger.info("Sending notification...");

            var result = notificationClient.sendNotification(transfer);
            if (result.getStatusCode().isError()) {
                logger.error("Error while sending notification: {}", result.getStatusCode());
            }

        } catch (Exception e) {
            logger.error("Failed to send notification", e);
        }
    }

}
