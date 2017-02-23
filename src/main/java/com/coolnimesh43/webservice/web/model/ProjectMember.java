package com.coolnimesh43.webservice.web.model;

import javax.validation.constraints.NotNull;

public class ProjectMember extends AbstractAuditEntity {

    private Long id;
    private String status;

    @NotNull
    private Long projectId;

    @NotNull
    private Long userId;

    private Project projectDTO;

    public Long getId() {
        return id;
    }

    public ProjectMember() {
        super();
    }

    public ProjectMember(String status, Long projectId, Long userId) {
        super();
        this.status = status;
        this.projectId = projectId;
        this.userId = userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Project getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(Project projectDTO) {
        this.projectDTO = projectDTO;
    }

    @Override
    public String toString() {
        return "ProjectMember [id=" + id + ", status=" + status + ", projectId=" + projectId + ", userId=" + userId + ", projectDTO="
                + projectDTO + "]";
    }

}
