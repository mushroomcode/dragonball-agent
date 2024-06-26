package com;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HunterClassTransfor implements ClassFileTransformer {

    private static final Logger log = LoggerFactory.getLogger(HunterClassTransfor.class);

    public static String byteArrayToHexString(byte [] classBytes) throws IllegalClassFormatException {
        final StringBuilder buff = new StringBuilder();
        for (byte classByte : classBytes) {
            buff.append(Integer.toHexString(classByte));
        }
        return buff.toString();
    }


    public byte[] transform(final ClassLoader loader, final String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        log.info("Got to MyClassFileTransformer.transform()");
        log.info("Class Name: {}", className);
        log.info("Class: {}", classBeingRedefined);
        log.info("************ RAW CLASS BYTES ************");
        log.info("{}", byteArrayToHexString(classfileBuffer));
        log.info("*****************************************");
        return classfileBuffer;
    }
}
