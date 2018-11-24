package com.xm.zeronews.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String email;

    private String username;

    private String password;

    private String signature;

    private String code;

    private String image;

    private String bg;

    private Integer type;

    private Boolean gender;

    private LocalDate birth;

    @TableField("isActive")
    private Boolean isActive;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private Love love;

    @TableField(exist = false)
    private List<News> newsList;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
