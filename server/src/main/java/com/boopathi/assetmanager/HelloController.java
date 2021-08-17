package com.boopathi.assetmanager;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/*")
    public String index() {
        JSONObject jsonObject = new JSONObject().put("status","failed").put("message","Invalid URL accessed").put("status code",4007);
        return jsonObject.toString();
    }

}