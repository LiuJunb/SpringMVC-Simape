package com.xmg.touna.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 
 *==========================================================
 *
 * 版权
 *
 * 作者：liujun  1552752505@qq.com
 *
 * 版本：1.0
 *
 * 创建日期： 2016年3月23日  上午10:49:23
 *
 * 描述：
 * 
 * 		使用案例：
 * 		User user = new User();
		user.setAge(12);
		user.setName("刘军");
		Student student=new Student();
		
		System.out.println(student);
		student = (Student) CopyObject.makeObject1ToObject2(user, student);
		System.out.println(student);
		
//		输出结果
//		Student [age=0, name=null]
//		Student [age=12, name=刘军]
 *
 * 全局接口公共部分：
 *
 * 修订历史：
 *
 *==========================================================
 *
 */
public class CopyObject {

	  /**
     * 将对象1转换为对象2，并给相同属性字段复制
     *
     * @param object1
     * @param object2
     * @return
     */
    public static Object makeObject1ToObject2(Object object1, Object object2) {
        Field[] fields1 = object1.getClass().getDeclaredFields();
        Field[] fields2 = object2.getClass().getDeclaredFields();
        if (null != fields1 && null != fields2) {
            for (Field field1 : fields1) {
                try {
                    String name1 = field1.getName();
                    PropertyDescriptor pd = new PropertyDescriptor(name1, object1.getClass());
                    Method getMethod = pd.getReadMethod();//获得get方法
                    Object ohh = getMethod.invoke(object1);//执行get方法返回一个Object
                    for (Field field2 : fields2) {
                        String name2 = field2.getName();
                        if (name1.equals(name2)) {
                            PropertyDescriptor pd2 = new PropertyDescriptor(name2, object2.getClass());
                            Method writeMethod = pd2.getWriteMethod();//获得set方法
                            writeMethod.invoke(object2, ohh);//执行set方法，将ohh的值放入
                        }
                    }
                } catch (Exception e) {
                    //logger.info(e.getMessage());
                }
 
            }
        }
 
        return object2;
    }

}
