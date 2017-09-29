package com.github.jackl.controller;

/**
 * Created by jackl on 2017/6/28.
 */

import com.github.jackl.service.ParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class HandleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ParseService parseService;

    @RequestMapping(value = "/parse", method = RequestMethod.GET)
    public String query(@RequestParam(value = "url", required = false) String url,
                        @RequestParam(value = "rule", required = false) String rule
    ) {
        logger.info("request url:" + url);
        String result = parseService.handlePage(url, rule);
        return result;
    }

    //@RequestMapping(value = "/hold", method = RequestMethod.GET)
    @RequestMapping(value = "/hold")
    public String hold(@RequestParam(value = "seconds", required = false) Integer seconds,HttpServletRequest servletRequest
                       ) {
        seconds = seconds == null ? 0 : seconds;
        String method = servletRequest.getMethod();
        String contentType = servletRequest.getContentType();
        logger.info(servletRequest.getRemoteAddr()+" "+ method +" request for hold " + seconds + " seconds"+"   contentType:"+contentType);
        String ip = servletRequest.getHeader("X-Real-IP1");
        String result = parseService.hold(seconds);
        return result;
    }


}
