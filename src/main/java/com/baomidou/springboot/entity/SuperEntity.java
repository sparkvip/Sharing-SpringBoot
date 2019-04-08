package com.baomidou.springboot.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 演示实体父类
 */
@Data
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID
     */
    @TableId("id")
    private Long id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
