package algorithmTool.math.mathTools;

import java.math.BigDecimal;
import java.math.BigInteger;
/**
 * 数字操作工具
 * @author BlazingPhoenix
 *
 */
public class MathTool {
	
	/**
	 * 判断两个引用类型的大小
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
	 * 比较两个引用类型的大小
	 * @description 比较两个引用类型的大小<br>
	 * 				若左引用类型大于右引用类型，返回1<br>
	 * 				若一样大，则返回0；否则返回-1<br>
	 * @param left 左引用类型
	 * @param right 右引用类型
	 * @return 比较结果
	 */
	public static int compare(Object left, Object right)
	{
		return getBigDecimal(left).compareTo(getBigDecimal(right));
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
                throw new ClassCastException("Not possible to coerce ["+value+"] from "+value.getClass()+" into a BigDecimal.");  
            }
        }  
        return ret;  
    }  
	
}
