package MOBLIMA.action;

import java.io.IOException;

/**
 * An interface for other actions to implement
 * 
 */
public interface action {
    public void displayChoices();

    public int getChoice() throws IOException;
}
