package com.test.rest.api.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class ApiController {

    private HttpSession session;

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public HttpEntity<String> getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String response = dateFormat.format(date);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/timezone", method = RequestMethod.GET)
    public HttpEntity<String> getTimeZone() {
        Calendar cal = Calendar.getInstance();
        long milliDiff = cal.get(Calendar.ZONE_OFFSET);
        String [] ids = TimeZone.getAvailableIDs();
        String timezone = "";
        for (String id : ids) {
            TimeZone tz = TimeZone.getTimeZone(id);
            if (tz.getRawOffset() == milliDiff) {
                timezone = id;
                break;
            }
        }
        String response = timezone;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public HttpEntity<String> getIp() throws UnknownHostException {
        String response = InetAddress.getLocalHost().getHostAddress();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST)
    public HttpEntity<String> addUser(@RequestParam String username, HttpSession httpSession) {
        httpSession.setAttribute("username", username);
        session = httpSession;
        String response = "success";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public HttpEntity<String> getUser() {
        String username = (String) session.getAttribute("username");
        String response;
        if(username != null) {
            response = username;
        } else {
            response = "Anonymous";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
