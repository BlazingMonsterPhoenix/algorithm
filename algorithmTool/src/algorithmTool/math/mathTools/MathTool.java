package algorithmTool.math.mathTools;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathTool {
	
	/**
	 * 比较两个引用类型的大小
	 * @description 判断左引用类型是否大于右引用类型<br>
	 * 				主要用于比较八种基本类型的封装类
	 * @param left 左引用类型
	 * @param right 右引用类型
	 * @return 左引用类型大于右引用类型
	 */
	public static boolean leftOneIsBigger(Object left, Object right)
	{
		return getBigDecimal(left).compareTo(getBigDecimal(right)) == 1;
	}
	
	/**
	 * 将一个引用类型转化为BigDecimal
	 * @param value 需要进行转化的引用类型
	 * @return 转化结果
	 */
	public static BigDecimal getBigDecimal(Object value) {  
        BigDecimal ret = null;  
        if(value != null ) {  
            if(value instanceof Number) {  
                ret = new BigDecimal(((Number)value).doubleValue() );  
            }
            else if (value instanceof Character){
            	ret = new BigDecimal((Character)value);
            }
            else if (value instanceof Boolean){
            	ret = new BigDecimal((Boolean)value ? 1 : 0);
            }
            else if(value instanceof BigDecimal) {  
                ret = (BigDecimal)value;  
            } 
            else if(value instanceof String) {  
                ret = new BigDecimal((String)value);  
            } 
            else if(value instanceof BigInteger) {  
                ret = new BigDecimal((BigInteger)value);  
            }
            else {
                throw new ClassCastException("Not possible to coerce ["+value+"] from class "+value.getClass()+" into a BigDecimal.");  
            }
        }  
        return ret;  
    }  
	
}
