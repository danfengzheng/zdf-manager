package com.zhengdf.manager.admin.domain.vo;

import com.zhengdf.manager.admin.utils.StringUtils;
import lombok.Data;

@Data
public class MenuVo {
    private String menuName;
    private String menuUrl;
    private Long menuSort;
    private String parentId;

    public String getParentId() {
        if (StringUtils.isBlank(this.parentId)) {
            return "0";
        }
        return this.parentId;
    }
}
