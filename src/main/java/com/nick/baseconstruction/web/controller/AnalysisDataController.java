package com.nick.baseconstruction.web.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analysisData/")
public class AnalysisDataController {


    @RequestMapping("test")
    public void test(String str1, String str2) {
        System.out.println(str1);
        JSONObject jsonObject = JSONObject.parseObject(str1);
        JSONObject jsonObject1 = JSONObject.parseObject(str2);
        List<Map<String, Object>> value1 = (List<Map<String, Object>>) jsonObject.get("value");
        List<Map<String, Object>> value2 = (List<Map<String, Object>>) jsonObject1.get("value");
        anaylsisData(value1, value2);
        System.out.println(value1.toString());
    }

    private List<Map<String, Object>> anaylsisData(List<Map<String, Object>> obj1, List<Map<String, Object>> obj2) {
        if (obj1.size() < obj2.size()) {
            List<Map<String, Object>> list = new ArrayList<>();
            list = obj2;
            obj2 = obj1;
            obj1 = list;
        }
        for (Map<String, Object> map1 : obj1) {
            for (Map<String, Object> map2 : obj2) {
                if (map1.get("resourceCode").equals(map2.get("resourceCode"))) {
                    map2.put("flag", "1");
                    List<Map<String, Object>> dto1 = (List<Map<String, Object>>) map1.get("resourceDTO2List");
                    List<Map<String, Object>> dto2 = (List<Map<String, Object>>) map2.get("resourceDTO2List");
                    for (Map<String, Object> needOperate : dto1) {
                        for (Map<String, Object> notNeedOperate : dto2) {
                            if (needOperate.get("unitName").equals(notNeedOperate.get("unitName"))) {
                                needOperate.put("resourceCount", Integer.parseInt(String.valueOf(needOperate.get("resourceCount"))) + Integer.parseInt(String.valueOf(notNeedOperate.get("resourceCount"))));
                            }
                        }
                    }
                    anaylsisData((List<Map<String, Object>>) map1.get("resourceList"), (List<Map<String, Object>>) map2.get("resourceList"));
                    break;
                }
            }
        }
        Iterator<Map<String, Object>> iterator = obj2.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> next = iterator.next();
            if (!next.containsKey("flag")) {
                obj1.add(next);
            }
        }
        return obj1;
    }
}
