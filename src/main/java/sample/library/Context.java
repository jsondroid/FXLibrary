package sample.library;

public abstract class Context {

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int requestCode);

    public boolean isMacOs() {
        return SystemOSInfo.isMacOS();
    }

    public boolean isWindows() {
        return SystemOSInfo.isWindows();
    }

    public boolean isLinux() {
        return SystemOSInfo.isLinux();
    }

    public String getOSName() {
        return SystemOSInfo.getOSName();
    }

    public abstract Context getApplicationContext();

    public abstract void attachApplicationContext(ApplicationContext applicationContext);

}
