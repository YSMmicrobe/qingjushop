package com.baizhi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encidePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        System.out.println(        encidePassword("123456"));
        //123456
        //$2a$10$YkX7Bw2LZHp1FJBreA52Gegdi64axfSvuAwBt2aVcZ1/FOpvmbj/2

        //  123
        //$2a$10$/4RMRZZpVlaglkfQozPDzeTKNF4SpGJPEWBc1kxTfiSIMbu1v3fP2
        //$2a$10$KSEc.qhLbdOUNVW91gb2oOt9I00b25IU8BdgDKSUgU5w4A3fh4oyy
    }
}
