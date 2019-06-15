package org.sam.stu;

import org.junit.Test;
import org.sam.stu.duty.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试
 */
public class CertificateRequestTest {

    @Test
    public void test1() {
        //填写申请信息
        CertificateRequest certificateRequest = new CertificateRequest();
        certificateRequest.setProposer("张三");
        certificateRequest.setUserType("个人");
        certificateRequest.setApplyDate(new Date());
        certificateRequest.setOrganizationName("张三");
        certificateRequest.setOrganizationCode("123456");
        certificateRequest.setApprovalStatus(ApprovalStatusEnum.READY_APPROVAL.getCode());
        certificateRequest.setPhone("18802096261");
        Attachment front = new Attachment("1001","正面照","/images/front.jpg");
        Attachment behind = new Attachment("1002","反面照","/images/behind.jpg");
        List<Attachment> attachmentList = Stream.of(front,behind).collect(Collectors.toList());
        certificateRequest.setAttachments(attachmentList);


        Director director = new Director("主任");
        Manager manager = new Manager("经理");
        GeneralManager generalManager = new GeneralManager("总经理");


        //责任链对象关系
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        //开始审批
        director.handleRequest(certificateRequest);
    }
}
