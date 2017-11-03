/**
 * ������ģʽ
 * ����һ�����ԣ����������ķ���һ�ֱ�ʾ������һ��������
 * ���������ʹ�øñ�ʾ�����������еľ��ӡ�
 *
 * ���һ�����͵����ⷢ����Ƶ���㹻�ߣ�
 * ��ô���ܡ���ֵ�ý�������ĸ���ʵ������Ϊһ���������еľ���
 * �����Ϳ��Թ���һ�����������ý�����ͨ��������Щ��������������⡣
 */

package design_mode;

import java.util.ArrayList;
import java.util.List;

public class InterpreterMode {
	//This is a test
	public static void main(String[] args) {
		//�����Ķ���
		ContextExpression ctx=new ContextExpression();
		//���ʽ�����б�
		List<Expression> exps=new ArrayList<Expression>();
		//��ӱ��ʽ
		exps.add(new TerminalExpression());
		exps.add(new NonTerminalExpression());
		exps.add(new TerminalExpression());
		exps.forEach(exp->exp.interprete(ctx));
	}
}

//������ʽ��
abstract class Expression{
	public abstract void interprete(ContextExpression ContextExpression);
}

//�ս�����ʽ��(ʵ���ķ������ս����صĲ���)
class TerminalExpression extends Expression{
	@Override
	public void interprete(ContextExpression ContextExpression) {
		System.out.println("�ս�����ʽ��");
	}
}

//���ս�����ʽ��(ʵ���ķ�������ս����صĲ���)
class NonTerminalExpression extends Expression{
	@Override
	public void interprete(ContextExpression ContextExpression) {
		System.out.println("���ս�����ʽ��");
	}
}

//������֮���һ��ȫ����Ϣ
class ContextExpression{
	//�������(δʵ��)
	private String input;
	private String output;

	//getter and setter
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
}