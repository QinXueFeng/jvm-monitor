package com.andaily.infrastructure;

/**
 * @author Shengzhao Li
 */
public abstract class ThreadLocalHolder {

    private static ThreadLocal<String> clientIpThreadLocal = new ThreadLocal<>();

    protected ThreadLocalHolder() {
    }

    public static void clientIp(String clientIp) {
        clientIpThreadLocal.set(clientIp);
    }

    public static String clientIp() {
        return clientIpThreadLocal.get();
    }
}