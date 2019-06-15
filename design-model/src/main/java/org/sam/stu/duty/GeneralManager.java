package org.sam.stu.duty;

/**
 * 经理审批
 */
public class GeneralManager extends Leader{

    public GeneralManager(String name){
        super(name);
    }

    @Override
    public void handleRequest(CertificateRequest certificateRequest) {
        certificateRequest.setApprovalStatus(ApprovalStatusEnum.ALREADY_PASSED.getCode());
        System.out.println("所有信息填写无误，通过审批");
    }
}
