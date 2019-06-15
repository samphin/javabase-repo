package org.sam.stu.duty;

/**
 * 审批流程参与者
 * @author chenyongfeng
 * @date 2019-6-12 17:32:54
 */
public abstract class Leader {

    protected String name;
    protected Leader nextLeader;//责任链后期对象
    public Leader(){}

    public Leader(String name){
        super();
        this.name=name;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    //处理请求核心业务方法
    public abstract void handleRequest(CertificateRequest certificateRequest);
}
