package org.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by Apple on 2017/6/10.
 * 常量类
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    /**
     * 产品：排序方式（Set提高效率//todo 时间复杂度：List Set）
     */
    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }

    /** 使用内部接口类分组常量 比枚举轻量*/

    /** 角色 */
    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1; //管理员
    }
    /** 购物车 */
    public interface Cart{
        int CHECKED = 1; //选中状态
        int UN_CHECKED = 0; // 未选中状态

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";// 库存不满足需求
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS"; // 库存满足需求
    }

    /**
     * 产品状态枚举
     */
    public enum ProductStatusEnum{
        ON_SALE(1, "在线");

        private int code;
        private String value;

        ProductStatusEnum(int code, String value){
            this.code = code;
            this.value = value;
        }

        public int getCode(){
            return code;
        }

        public String getValue(){
            return value;
        }
    }
}
