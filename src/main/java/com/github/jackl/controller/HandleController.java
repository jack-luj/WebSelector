package com.github.jackl.controller;

/**
 * Created by jackl on 2017/6/28.
 */
import com.github.jackl.service.ParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HandleController {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    ParseService parseService;
    @RequestMapping(value = "/parse",method = RequestMethod.GET)
    public String query(@RequestParam(value = "url",required = false) String url,
                        @RequestParam(value = "rule",required = false) String rule
                    ){
        logger.info("request url:"+url);
        String result=parseService.handlePage(url,rule);
        return result;
    }


}
