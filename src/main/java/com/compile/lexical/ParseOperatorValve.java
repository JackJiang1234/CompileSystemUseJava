package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import com.compile.lexical.token.CommentToken;
import com.compile.lexical.token.OperatorToken;
import com.compile.lexical.token.OperatorUtil;

/**
 * 解析运算符, 包括单目和双目运算符
 * 单目运符算 +,-,*,/,%,&,>,<,=,!,(,),[,],
 * 双目运算符 ++, --, >=, <=, ==, !=, &&, ||
 *
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParseOperatorValve extends LookAheadCharBaseValue {

    @Override
    protected boolean isMatch(int ch) {
        this.lookAhead = ch;
        return OperatorUtil.isOperator(ch);
    }

    @Override
    protected BaseToken doParse(Scanner scanner) {
        if (OperatorUtil.needGreedyParse(this.lookAhead)) {
            return this.doBinaryOperatorParse(scanner);
        } else {
            return new OperatorToken(Character.toString((char) this.lookAhead));
        }
    }

    private BaseToken doBinaryOperatorParse(Scanner scanner) {
        int next = scanner.next();
        CharAppender appender = new CharAppender(this.lookAhead, next);

        if (OperatorUtil.isEndGreedyChar(next)) {
            String symbol = appender.toString();
            if (OperatorUtil.isCommentSymbol(symbol)) {
                return doCommentParse(symbol, scanner);
            } else {
                return new OperatorToken(appender.toString());
            }
        } else {
            scanner.pushBack(next);
            return new OperatorToken(Character.toString((char) this.lookAhead));
        }
    }

    private BaseToken doCommentParse(String symbol, Scanner scanner) {
        String comment;
        if (OperatorUtil.isSingleLineCommentSymbol(symbol)) {
            comment = this.readUntilNewLine(scanner);
        } else {
            comment = this.readUntilMultiLineEndCommentSymbol(scanner);
        }

        return new CommentToken(symbol + comment);
    }

    // 读取直到*/
    private String readUntilMultiLineEndCommentSymbol(Scanner scanner) {
        CharAppender appender = new CharAppender();
        int readChar;
        boolean endCommentStateBegin = false;

        while ((readChar = scanner.next()) != BaseScanner.EOF) {
            appender.append(readChar);
            if (readChar == OperatorUtil.MUL) {
                endCommentStateBegin = true;
                continue;
            }
            if (endCommentStateBegin && readChar == OperatorUtil.DIV) {
                break;
            }
            if (endCommentStateBegin && readChar != OperatorUtil.DIV) {
                throw new LexicalParseException(String.format("end comment format char '%c' parse error at %d line %d col.", readChar, scanner.getLine(), scanner.getColumn()));
            }
        }

        return appender.toString();
    }

    private int lookAhead;
}
