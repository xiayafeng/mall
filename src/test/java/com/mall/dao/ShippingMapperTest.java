package com.mall.dao;

import com.google.common.collect.Lists;
import com.mall.pojo.Shipping;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by peter on 17/10/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-datasource.xml"})
public class ShippingMapperTest {

    @Autowired
    ShippingMapper shippingMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void insert() throws Exception {
        Shipping shipping = new Shipping(30,"张三","021-9832","1359822","湖北省","武汉市","洪山区","杨家湾","421302");

//        shippingMapper.insert(shipping);
    }

    @Test
    public void insertBatch() throws Exception {
        Shipping shipping1 = new Shipping(40,"张三","021-9832","1359822","湖北省","武汉市","洪山区","杨家湾","421302");
        Shipping shipping2 = new Shipping(41,"李四","021-9832","1359822","湖北省","武汉市","洪山区","杨家湾","421302");
        Shipping shipping3 = new Shipping(42,"王五","021-9832","1359822","湖北省","武汉市","洪山区","杨家湾","421302");
        Shipping shipping4 = new Shipping(43,"赵卫","021-9832","1359822","湖北省","武汉市","洪山区","杨家湾","421302");
        Shipping shipping5 = new Shipping(45,"韩信","021-9832","1359822","湖北省","武汉市","洪山区","杨家湾","421302");

        List<Shipping> shippingList = Lists.newArrayList();
        shippingList.add(shipping1);
        shippingList.add(shipping2);
        shippingList.add(shipping3);
        shippingList.add(shipping4);
        shippingList.add(shipping5);

//        shippingMapper.insertBatch(shippingList);


    }

    @Test
   public void insertBatct2() {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
        ShippingMapper shippingMapper1 = sqlSession.getMapper(ShippingMapper.class);
        // STOPSHIP: 17/10/25
        try {

            for (int i = 0; i < 10; i++) {
                Shipping shipping = new Shipping();
                shipping.setUserId(100+ i);
                shipping.setReceiverName("8");
                shipping.setReceiverAddress("6");
                shipping.setReceiverCity("1");
                shipping.setReceiverDistrict("2");
                shipping.setReceiverMobile("3");
                shipping.setReceiverPhone("4");
                shipping.setReceiverProvince("5");
                shipping.setReceiverZip("7");
                shippingMapper1.insert(shipping);
                if(i % 10 == 0 || i == 9) {
                    //手动每1000个一提交，提交后无法回滚
                    sqlSession.commit();
                    //清理缓存，防止溢出
                    sqlSession.clearCache();
                }
            }
        } catch (Exception e) {
            sqlSession.rollback();

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testBatchSql() {
        shippingMapper.executeBatchSql();

    }

}