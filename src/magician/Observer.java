package magician;

import java.io.IOException;

public interface Observer {
    void update(String s) throws IOException;
}
