package com.zhengdf.manager.admin.utils;

import java.util.UUID;

/**
 * @ClassName IdGen
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 18:47
 * @Version 1.0
 * @Memo
 **/
public class IdGen {
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
