package org.sam.stu.duty;

/**
 * 经理审批
 */
public class Manager extends Leader{

    public Manager(String name){
        super(name);
    }

    @Override
    public void handleRequest(CertificateRequest certificateRequest) {
        //如果是待审批状态-->改成通过状态
        if(certificateRequest.getApprovalStatus()==ApprovalStatusEnum.ALREADY_PASSED.getCode()){
            //如果证件号码不正确则没法通过
            String phone = certificateRequest.getPhone();
            if("18802096261".equals(phone)){
                certificateRequest.setApprovalStatus(ApprovalStatusEnum.ALREADY_PASSED.getCode());

                System.out.println("经理审批通过");
                //走下一个流程
                this.nextLeader.handleRequest(certificateRequest);
            }else{
                certificateRequest.setApprovalStatus(ApprovalStatusEnum.NO_PASSED.getCode());
                System.out.println("经理审批，手机号不正确，请重新申请");
            }
        }
    }
}
