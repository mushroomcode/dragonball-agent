package com;

import java.lang.instrument.Instrumentation;

public class PreAgent  {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("agent参数:" + agentArgs);
    }
}
