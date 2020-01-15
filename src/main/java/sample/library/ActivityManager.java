package sample.library;

import java.util.Stack;

public class ActivityManager {
    private Stack<Activity> activities = new Stack<Activity>();

    public void push(Activity activity) {
        activities.push(activity);
    }

    public Activity pop() {
        return activities.pop();
    }

    public Activity peek() {
        return activities.peek();
    }

    public void remove(Activity activity) {
        activities.remove(activity);
    }

    public Activity getActivity(int index) {
        return activities.get(index);
    }

    public <T extends Activity> T getActivity(int index, Class<T> classty) {
        return (T) activities.get(index);
    }

    public int getActivityIndex(Activity activity) {
        return activities.indexOf(activity);
    }

    public int search(Activity activity) {
        return activities.search(activity);
    }

    public int getSize(){
        return activities.size();
    }

}
