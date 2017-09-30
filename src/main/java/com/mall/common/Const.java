package com.mall.common;

import com.google.common.collect.Sets;
import com.sun.tools.corba.se.idl.StringGen;
import org.springframework.cglib.transform.impl.InterceptFieldCallback;

import java.util.Set;

/**
 * Created by peter on 17/8/6.
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String USERNAME = "username";
    public static final String EMAIL = "email";

    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    public interface Role{
        int ROLE_CUSTOMER = 0;//普通用户
        int ROLE_ADMIN = 1;//管理员
    }

    public interface Cart {
        int CHECKED = 1;//购物车选中
        int UN_CHECKED = 0;//购物车没有选中
        String LIMIT_NUM_FAIL = "limit_num_fail";
        String LIMIT_NUM_SUCCESS = "limit_num_success";
    }
}
