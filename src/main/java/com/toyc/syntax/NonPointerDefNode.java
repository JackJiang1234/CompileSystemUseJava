package com.toyc.syntax;

/**
 * @ClassName: NonPointerDefNode
 * @Description  def 非指针定义分支
 *   <def>	->	ID  <idtail>
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class NonPointerDefNode extends DefNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }
}
