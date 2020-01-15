package sample.library;

public class ApplicationContext extends ContextWrapper {

    private ActivityManager manager;

    public ApplicationContext() {
        super(null);
        manager = new ActivityManager();
    }

    public void attachBaseContext(Context context) {
        mBase = context;
    }

    public void onCreat() {

    }

    @Override
    public void startActivity(Intent intent) {
        if (intent != null) {
            intent.getActivity().attachBaseContext(mBase, intent);
            intent.getActivity().onStart();
        }
    }

    public ActivityManager getManager() {
        return manager;
    }
}
