package sample.library;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Intent {

    private Context context;
    private Activity activity;
    private HashMap<String, Object> hashMap;

    public Intent(Context context, Class<? extends Context> cls) {
        this.context = context;
        hashMap = new HashMap<String, Object>();
        try {
            Constructor constructor = cls.getConstructor();
            this.activity = (Activity) constructor.newInstance();
            this.activity.attachApplicationContext((ApplicationContext) context.getApplicationContext());
            ((ApplicationContext) context.getApplicationContext()).getManager().push(this.activity);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void putExtra(String key, Object value) {
        hashMap.put(key, value);
    }

    public <T> T getExtra(String key, T defultvalue, Class<T> cls) {
        return (T) (hashMap.get(key) == null ? defultvalue : hashMap.get(key));
    }

    public Object getExtra(String key, Object defultvalue) {
        return hashMap.get(key) == null ? defultvalue : hashMap.get(key);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Activity getActivity() {
        return activity;
    }

}
