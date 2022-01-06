package com.yiwu_order_center_server.domain;

import java.util.Date;

public class RawMaterialCategory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.parent_id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.code
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.top_id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Long topId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.name
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.level
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.status
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.sort
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.is_del
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.create_time
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column raw_material_category.update_time
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.id
     *
     * @return the value of raw_material_category.id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.id
     *
     * @param id the value for raw_material_category.id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.parent_id
     *
     * @return the value of raw_material_category.parent_id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.parent_id
     *
     * @param parentId the value for raw_material_category.parent_id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.code
     *
     * @return the value of raw_material_category.code
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.code
     *
     * @param code the value for raw_material_category.code
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.top_id
     *
     * @return the value of raw_material_category.top_id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Long getTopId() {
        return topId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.top_id
     *
     * @param topId the value for raw_material_category.top_id
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setTopId(Long topId) {
        this.topId = topId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.name
     *
     * @return the value of raw_material_category.name
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.name
     *
     * @param name the value for raw_material_category.name
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.level
     *
     * @return the value of raw_material_category.level
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.level
     *
     * @param level the value for raw_material_category.level
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.status
     *
     * @return the value of raw_material_category.status
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.status
     *
     * @param status the value for raw_material_category.status
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.sort
     *
     * @return the value of raw_material_category.sort
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.sort
     *
     * @param sort the value for raw_material_category.sort
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.is_del
     *
     * @return the value of raw_material_category.is_del
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.is_del
     *
     * @param isDel the value for raw_material_category.is_del
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.create_time
     *
     * @return the value of raw_material_category.create_time
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.create_time
     *
     * @param createTime the value for raw_material_category.create_time
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column raw_material_category.update_time
     *
     * @return the value of raw_material_category.update_time
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column raw_material_category.update_time
     *
     * @param updateTime the value for raw_material_category.update_time
     *
     * @mbg.generated Mon Dec 20 15:02:40 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}