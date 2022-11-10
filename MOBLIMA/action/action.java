package MOBLIMA.action;

import java.io.IOException;

public interface action {
    public void displayChoices();

    public int getChoice() throws IOException;
}
