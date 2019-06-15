package org.sam.stu.duty;

import java.util.Date;
import java.util.List;

/**
 * 证件申请信息
 * @author chenyongfeng
 * @date 2019-6-12 17:31:02
 */
public class CertificateRequest {

    //申请人
    private String proposer;

    //申请时间
    private Date applyDate;

    //用户类型（个人、企业）
    private String userType;

    //个人：姓名；企业：公司名
    private String organizationName;

    //个人：身份证号；企业：营业执照
    private String organizationCode;

    //联系电话
    private String phone;

    //审批状态
    private Integer approvalStatus;

    //附件列表（证件正反面）
    private List<Attachment> attachments;

    public CertificateRequest() {}

    public CertificateRequest(String proposer, Date applyDate, String userType,
                              String organizationName, String organizationCode,
                              String phone, Integer approvalStatus, List<Attachment> attachments) {
        this.proposer = proposer;
        this.applyDate = applyDate;
        this.userType = userType;
        this.organizationName = organizationName;
        this.organizationCode = organizationCode;
        this.phone = phone;
        this.approvalStatus = approvalStatus;
        this.attachments = attachments;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
