package domain.notificationmanager.mock;

import domain.notificationmanager.spi.FileNotificationService;
import domain.filemanager.mock.MockFileEvenHandlerList;

public class MockNotificationServiceOne extends MockFileEvenHandlerList implements FileNotificationService {

    @Override
    public String getServiceId() {
        return "ServiceOne";
    }
}
