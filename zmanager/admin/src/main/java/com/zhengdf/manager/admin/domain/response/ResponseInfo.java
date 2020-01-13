package com.zhengdf.manager.admin.domain.response;

import com.zhengdf.manager.admin.constant.CommonEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

/**
 * @ClassName ResponseEntity
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/9 18:25
 * @Version 1.0
 * @Memo
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInfo<T> {
    private Long code;
    private String message;
    private T data;

    public static ResponseInfo getInstance(CommonEnums commonEnums){
        return ResponseInfo.builder().code(commonEnums.getCode()).message(commonEnums.getMessage()).build();
    }


    public static ResponseInfo success(Object data){
        ResponseInfo info = getInstance(CommonEnums.SUCCESS);
        info.setData(data);
        return info;
    }
    public static ResponseInfo success(){
        ResponseInfo info = getInstance(CommonEnums.SUCCESS);
        return info;
    }
}
