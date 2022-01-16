package Transform;

import java.io.File;

public interface Transformer {
    void transform(File source, File[] dest);
}
