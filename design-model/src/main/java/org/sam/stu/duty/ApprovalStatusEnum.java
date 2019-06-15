package org.sam.stu.duty;

/**
 * 审批状态
 */
public enum ApprovalStatusEnum {

    READY_APPROVAL(1,"待审批"),
    ALREADY_PASSED(2,"已通过"),
    NO_PASSED(3,"未通过");

    ApprovalStatusEnum(int code ,String name){
        this.code = code;
        this.name = name;
    }

    private int code;

    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
