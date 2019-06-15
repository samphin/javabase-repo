package org.sam.stu.duty;

/**
 * 主任审批
 */
public class Director extends Leader{

    public Director(String name){
        super(name);
    }

    @Override
    public void handleRequest(CertificateRequest certificateRequest) {

        //如果是待审批状态-->改成通过状态
        if(certificateRequest.getApprovalStatus()==ApprovalStatusEnum.READY_APPROVAL.getCode()){
            //如果证件号码不正确则没法通过
            String organizationCode = certificateRequest.getOrganizationCode();
            if("123456".equals(organizationCode)){
                certificateRequest.setApprovalStatus(ApprovalStatusEnum.ALREADY_PASSED.getCode());

                //走下一个流程
                this.nextLeader.handleRequest(certificateRequest);

                System.out.println("主任审批通过");
            }else{
                certificateRequest.setApprovalStatus(ApprovalStatusEnum.NO_PASSED.getCode());
                System.out.println("证件号码 = " + organizationCode+"不正确，请重新申请");
            }
        }
    }
}
