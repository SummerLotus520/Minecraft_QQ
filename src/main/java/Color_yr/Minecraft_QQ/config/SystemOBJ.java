package Color_yr.Minecraft_QQ.config;

public class SystemOBJ {
    public String IP;
    public int Port;
    public boolean AutoConnect;
    public int AutoConnectTime;
    public boolean Debug;
    public int Sleep;

    public SystemOBJ() {
        IP = "localhost";
        Port = 25555;
        AutoConnect = false;
        AutoConnectTime = 10000;
        Debug = false;
        Sleep = 50;
    }
}
