package com.example.kingsoft.animationdemo;

/**
 * Created by kingsoft on 2015/9/7.
 */


import com.example.kingsoft.animationdemo.expr.Expr;
import com.example.kingsoft.animationdemo.expr.Parser;
import com.example.kingsoft.animationdemo.expr.SyntaxException;
import com.example.kingsoft.animationdemo.expr.Variable;

public class HandleExpression {
    double x;
    double y;
    private String exprssion;

    public void processExprssion() {
        Expr expr;
        try {
            expr = Parser.parse(exprssion);
        } catch (SyntaxException e) {
            System.err.println(e.explain());

            return;
        }
        Variable var = Variable.make("x");
        var.setValue(x);
        y = expr.value();
    }


    public void setValue(int x) {
        this.x = x;
    }

    public void setExprssion(String exprssion) {
        this.exprssion = exprssion;
    }

    public double getY() {
        return y;
    }
}
