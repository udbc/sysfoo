package com.example.sysfoo.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SystemInfoService {

    @Value("${app.version}")
    private String appVersion;

    public String getHostname() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    public String getIpAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    public boolean isRunningInDocker() {
        return new java.io.File("/.dockerenv").exists();
    }

    public boolean isRunningInKubernetes() {
        return System.getenv("KUBERNETES_SERVICE_HOST") != null;
    }

    public String getAppVersion() {
        return appVersion;
    }
}
