package com.mab.entity;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static javafx.scene.input.KeyCode.T;


/** * Created by 马斌 on 2018/12/4.
 *
 * 使用jpa注解配置映射关系
 * @Entity 告诉jpa这是一个实体类（和数据库表映射的类）
 * @Table(name = "jpa_user") 指定和那个数据表
 */
@Entity
@Table(name = "jpa_user")
public class User {
    @javax.persistence.Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer Id;

    @Column(name = "user_name",length = 300)//指定列明及长度
    private String UserName;

    @Column//省略列名就是属性值
    private Integer Age;

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
