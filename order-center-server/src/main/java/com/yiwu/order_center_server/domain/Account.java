package com.yiwu.order_center_server.domain;

public class Account {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.id
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.name
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    private String account;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.password
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.id
     *
     * @return the value of account.id
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.id
     *
     * @param id the value for account.id
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.name
     *
     * @return the value of account.name
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.name
     *
     * @param name the value for account.name
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account
     *
     * @return the value of account.account
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.account
     *
     * @param account the value for account.account
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.password
     *
     * @return the value of account.password
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.password
     *
     * @param password the value for account.password
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}