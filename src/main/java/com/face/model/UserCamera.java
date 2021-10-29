package com.face.model;

public class UserCamera {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_camera.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_camera.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_camera.camera_ids
     *
     * @mbg.generated
     */
    private String cameraIds;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_camera.id
     *
     * @return the value of t_user_camera.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_camera.id
     *
     * @param id the value for t_user_camera.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_camera.user_id
     *
     * @return the value of t_user_camera.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_camera.user_id
     *
     * @param userId the value for t_user_camera.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_camera.camera_ids
     *
     * @return the value of t_user_camera.camera_ids
     *
     * @mbg.generated
     */
    public String getCameraIds() {
        return cameraIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_camera.camera_ids
     *
     * @param cameraIds the value for t_user_camera.camera_ids
     *
     * @mbg.generated
     */
    public void setCameraIds(String cameraIds) {
        this.cameraIds = cameraIds == null ? null : cameraIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserCamera other = (UserCamera) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCameraIds() == null ? other.getCameraIds() == null : this.getCameraIds().equals(other.getCameraIds()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCameraIds() == null) ? 0 : getCameraIds().hashCode());
        return result;
    }
}