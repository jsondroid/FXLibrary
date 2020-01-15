package sample.library;

public class ContextWrapper extends Context {

    Context mBase;
    ApplicationContext applicationContext;

    public ContextWrapper(Context base) {
        mBase = base;
    }

    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        mBase.startActivityForResult(intent, requestCode);
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void attachApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
