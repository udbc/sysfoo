package com.example.sysfoo.controller;

import com.example.sysfoo.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    @Value("${app.version}")
    private String appVersion; // Make sure this property is defined in your application.properties


    @GetMapping("/system-info")
    public Map<String, Object> getSystemInfo() throws UnknownHostException {
        Map<String, Object> info = new HashMap<>();
        info.put("Hostname", systemInfoService.getHostname());
        info.put("IP Address", systemInfoService.getIpAddress());
        info.put("Running in Docker", systemInfoService.isRunningInDocker());
        info.put("Running in Kubernetes", systemInfoService.isRunningInKubernetes());
        info.put("App Version", systemInfoService.getAppVersion());
        return info;
    }

    @GetMapping("/version")
    public ResponseEntity<String> getVersion() {
        return ResponseEntity.ok(appVersion); // Returns the app version
    }

    @GetMapping("/database-info")
    public Map<String, String> getDatabaseInfo() {
        return systemInfoService.getDatabaseInfo();
    }
}
