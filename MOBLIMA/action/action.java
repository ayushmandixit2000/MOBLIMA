package MOBLIMA.action;

import java.io.IOException;

/**
 * An interface for other actions to implement
 * 
 * @author Wong Yu Fei
 * @version 1.0
 */
public interface action {
    public void displayChoices();

    public int getChoice() throws IOException;
}
