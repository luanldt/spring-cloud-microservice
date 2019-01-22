package com.luandeptrai.demotwoservice.controllers;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final DiscoveryClient discoveryClient;

    public MainController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "<a href='showAllServiceIds'>Show All Service Ids</a>";
    }

    @ResponseBody
    @RequestMapping(value = "/showAllServiceIds", method = RequestMethod.GET)
    public String showAllServiceIds() {

        List<String> serviceIds = this.discoveryClient.getServices();

        if (serviceIds == null) {
            return "No services found!";
        }
        String html = "<h3>Service Ids:</h3>";
        for (String serviceId : serviceIds) {
            html += "<br><a href='showService?serviceId=" + serviceId + "'>" + serviceId + "</a>";
        }
        return html;
    }

    @ResponseBody
    @RequestMapping(value = "/showService", method = RequestMethod.GET)
    public String showFirstService(@RequestParam(defaultValue = "") String serviceId) {

        // (Need!!) eureka.client.fetchRegistry=true
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);

        if (instances == null || instances.isEmpty()) {
            return "No instances for service: " + serviceId;
        }
        String html = "<h2>Instances for Service Id: " + serviceId + "</h2>";

        for (ServiceInstance instance : instances) {
            html += "<h3>Instance: " + instance.getInstanceId() + "</h3>";
            html += "Host: " + instance.getHost() + "<br>";
            html += "Port: " + instance.getPort() + "<br>";
        }

        return html;
    }

    // A REST method, To call from another service.
    // See in Lesson "Load Balancing with Ribbon".
    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        return "<html>Hello from Demo Two Service</html>";
    }
}
