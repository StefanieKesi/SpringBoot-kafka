package com.stefanie.kesi.controller;

import com.alibaba.fastjson.JSONObject;
import com.stefanie.kesi.service.KafkaService;
import com.stefanie.kesi.util.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @RequestMapping(value = "/produceMessage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String produceMessage(@RequestBody String requestBody){
        try {
            kafkaService.produceMessage(requestBody);
            return JSONObject.toJSONString(new HttpResult(200,"发送kafka成功"));
        }catch (Exception e) {
            e.printStackTrace();
            return JSONObject.toJSONString(new HttpResult(500,"发送kafka成功"));
        }
    }
}
