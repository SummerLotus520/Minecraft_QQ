package Color_yr.Minecraft_QQ.side.velocity;

import Color_yr.Minecraft_QQ.API.ILogger;
import org.slf4j.Logger;

public class VelocityLog implements ILogger {
    private final Logger logger;

    public VelocityLog(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void warning(String data) {
        logger.warn(data);
    }

    @Override
    public void info(String data) {
        logger.info(data);
    }
}
