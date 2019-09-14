package com.chuangwei.internalAnswer.model;

import org.springframework.stereotype.Component;


@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();//不同线程访问不同对象

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
