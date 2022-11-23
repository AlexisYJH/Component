package com.example.librouter;

import android.app.Activity;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AlexisYin
 */
public class Router {
    final Map<String, Map<String, Class<?>>> groupMap = new HashMap<>();
    final Map<String, Class<?>> routerMap = new HashMap<>();

    private Router() {
    }

    public static Router getInstance() {
        return Holder.INSTANCE;
    }

    public static class Holder {
        static Router INSTANCE = new Router();
    }

    /**
     *
     * @param path /main/MainActivity
     * @param clazz
     */
    public void register(String path, Class<?> clazz) {
        String[] array = path.split("/");
        if (array.length > 2) {
            String groupName = array[1];
            String routerName = path;
            Map<String, Class<?>> group = null;
            if (groupMap.containsKey(groupName)) {
                group = groupMap.get(groupName);
            }
            if (group == null) {
                group = new HashMap<>();
                groupMap.put(groupName, group);
            }
            group.put(routerName, clazz);
        }
    }

    public void startActivity(Activity activity, String path) {
        String[] array = path.split("/");
        if (array.length > 2) {
            String groupName = array[1];
            String routerName = path;
            Map<String, Class<?>> group = null;
            if (groupMap.containsKey(groupName)) {
                group = groupMap.get(groupName);
            }
            if (group != null && group.containsKey(routerName)) {
                Class<?> clazz = group.get(routerName);
                activity.startActivity(new Intent(activity, clazz));
            }
        }
    }

}
