package MOBLIMA.configure;

import java.io.IOException;

/**
 * Configure interface for other configuring files to implement
 */
public interface configure {
    public void displaySetting() throws IOException;

    public void getNewSetting() throws IOException;
}
