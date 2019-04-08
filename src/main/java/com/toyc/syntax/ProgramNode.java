package com.toyc.syntax;

import com.toyc.common.CollectionUtil;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName: ProgramNode
 * @Description 程序是由多个程序片断组成
 * 产生式  <program>   ->	<segment><program> | EMPTY
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class ProgramNode extends SyntaxNode {

    public ProgramNode() {
    }

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public ProgramNode addSegment(SegmentNode segment) {
        this.segmentNodeList = CollectionUtil.createIfNull(this.segmentNodeList);
        this.segmentNodeList.add(segment);
        return this;
    }

    public List<SegmentNode> getSegments() {
        return Collections.unmodifiableList(CollectionUtil.createIfNull(this.segmentNodeList));
    }

    private List<SegmentNode> segmentNodeList;
}
