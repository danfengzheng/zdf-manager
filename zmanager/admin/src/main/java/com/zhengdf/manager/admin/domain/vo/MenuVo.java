package com.zhengdf.manager.admin.domain.vo;

import com.zhengdf.manager.admin.utils.StringUtils;
import lombok.Data;

@Data
public class MenuVo {
    private String menuName;
    private String menuUrl;
    private Long menuSort;
    private Long parentId;
    private Long resourceType;
    private String permission;
}
