package com.xm.zeronews.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 职工表
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Emp extends Model<Emp> {

    private static final long serialVersionUID = 1L;


    private Integer num;

    @TableField("userId")
    private Long userId;

    @TableField("auditNum")
    private Integer auditNum;

    private String name;

    private String phone;

    private String address;

    private Integer status;

    private Boolean type;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private User user;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
