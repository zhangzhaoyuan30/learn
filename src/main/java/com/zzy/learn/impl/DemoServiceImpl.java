package com.zzy.learn.impl;

import com.zzy.learn.thrift.DemoService;
import com.zzy.learn.thrift.Parameter;
import org.apache.thrift.TException;

import java.util.Map;

public class DemoServiceImpl implements DemoService.Iface {
    @Override
    public int demoMethod(String param1, Parameter param2, Map<String, String> param3) throws TException {
        return param1.length() + param2.getId() + param3.get("num").length();
    }
}
