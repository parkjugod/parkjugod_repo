package com.sample.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	/**
	 * 한글화 처리
	 * @param str
	 * @return
	 */
	public static String toUnicode(String str){
		try{
			byte[] b = str.getBytes("ISO-8859-1");
			return new String(b);
		} catch(java.io.UnsupportedEncodingException uee) {
			uee.printStackTrace();
			return null;
		}
	}
	

	public static String toLatin(String str){
		try{
			byte[] b = str.getBytes();
			return new String(b, "ISO-8859-1");
		} catch(java.io.UnsupportedEncodingException uee) {
			uee.printStackTrace();
			return null;
		}
	}
	
	/**
	 *String이 null이나 공백인 경우 지정한 문자열로 변경한다.
	 * @author rocomo
	 * @return String
	 * @param String str
	 * @param SString def
	 * @throws Exception
	 */
	public static String null2String(String str, String def) {
		if (str == null || str.equals("") || str.equals("null"))
			str = def;
		return str;
	}
	
	 /**
	    * 원하는 만큼 str을 잘라 리턴함
	    * @param orig
	    * @param length
	    * @return
	    */
	    public static String getShortString(String orig, int length) {
	        byte[] byteString = orig.getBytes();

	        if (byteString.length <= length) {
	            return orig;
	        } else {
	            int minusByteCount = 0;
	            for (int i = 0; i < length; i++) {
	                minusByteCount += (byteString[i] < 0) ? 1 : 0;
	            }

	            if (minusByteCount % 2 != 0) {
	                length--;
	            }

	            return new String(byteString, 0, length) + "...";
	        }
	    }
	    
	/**
	 * null일 경우 공백처리 해주는 메서드
	 * null이 아니면 해당 값을 그대로 반환한다.
	 * @param args
	 */
	public static String isNull(Object o){
		return o == null ? "" : o.toString();
	}

	/**
	 * r_trim
	 */
	public static String r_trim(String str)	throws Exception{
		int i;
		for(i=str.length() -1; i>=0; i--)
		{
			if(str.charAt(i) != ' ')
				break;
		}
		return str.substring(0, i+1);
	}

	
	
	/**
	 * l_trim
	 */
	public static String l_trim(String str)	throws Exception{
		int i;
		for(i=0; i<str.length(); i++)
		{
			if(str.charAt(i) != ' ')
				break;
		}
		return str.substring(i);
	}
	
   
    
	/**
	 * Byte 기준으로 string 을 자른다. (한글기준 2byte 적용)
	 */
	public static String substring(String orginal, int start) throws Exception{
		byte[] byte_body = orginal.getBytes();
		if (byte_body == null)
			return null;
		return substring(byte_body, start, byte_body.length);
	}

	/**
	 * Byte 기준으로 string 을 자른다. (한글기준 2byte 적용)
	 */
	public static String substring(String orginal, int start, int end) throws Exception{
		byte[] byte_body = orginal.getBytes();
		if (byte_body == null)
			return null;
		return substring(byte_body, start, end);
	}

	/**
	 * Byte Array 데이터를 string 으로 자른다.
	 */
	public static String substring(byte[] byte_body, int start, int end) throws Exception{
		int size = end - start;
		int length = byte_body.length - start;
		if (length < size)
			size = length;

		
		// byte[] tmp_body = new byte[end - start];
		if(size > 0) {
			byte[] tmp_body = new byte[size];
 
			System.arraycopy(byte_body, start, tmp_body, 0, tmp_body.length);
			return new String(tmp_body);
		}
		else
			return null;
		
	
	}

	/**
	 * 스트링을 일정한 길이 이상일때 잘라줌. (왼쪽부터)
	 */
	public static String leftstring(String str, int end) throws Exception{
		if (str.length() < (end + 1))
			return str;
		else
			return (substring(str, 0, end));
	}

	/**
	 * 스트링을 일정한 길이 이상일때 잘라줌. (오른쪽부터)
	 */
	public static String rightstring(String str, int end)throws Exception {
		if (str.length() < (end + 1))
			return str;
		else
			return (substring(str, str.length() - end, str.length()));
	}

	/**
	 * str1의 값이 null이거나 공백이면 str2의 값으로 대체한다.<br>
	 * str2의 값도 null이거나 공백이면 공백을 반환한다. 만약 str1이 값이 있다면 str1의 값을 반환한다. <br>
	 */
	public static String nvl(String str1, String str2) throws Exception{
		String returnValue = "";

		if (str1 == null || str1.equals("")) {
			if (str2 != null && !str2.equals("")) {
				returnValue = str2.trim();
			} else {
				returnValue = "";
			}
		} else {
			returnValue = str1.trim();
		}

		return returnValue;
	}

	/**
	 * FID Parser에서만 사용함 위의 nvl함수에서 trim()만 제외함
	 */
	public static String nvl2(String str1, String str2)throws Exception {
		String returnValue = "";

		if (str1 == null || str1.equals("")) {
			if (str2 != null && !str2.equals("")) {
				returnValue = str2;
			} else {
				returnValue = "";
			}
		} else {
			returnValue = str1;
		}

		return returnValue;
	}

	/**
	 * Array로 되어있는 패킷데이터를 String으로 조합한다.
	 */
	public static String mergeData(String[] savedata) throws Exception{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < savedata.length; i++) {
			sb.append(savedata[i]);

		}
		return sb.toString();
	}

	/**
	 * 총size를 맞추기 위해서 data+<공백> 형태로 구성 (예: "data " -> 5size)
	 */
	public static String setSize(String base, int size) throws Exception{
		return setSize(base, size, " ", false);
	}

	/**
	 * 총size를 맞추기 위해서 data+<문자> 형태로 구성 (예: "data000000" -> 10size)
	 * 
	 * isFirst = true 이면 "000000data" / isFirst = false 이면 "data000000"
	 */
	public static String setSize(String base, int size, String defaultChar,
			boolean isFirst) throws Exception{
		if (base == null)
			base = "";
		if (base.length() == size) {
			return base;
		} else if (base.length() > size) {
			return leftstring(base, size);
		} else {
			StringBuffer sb = null;
			if (isFirst) {
				sb = new StringBuffer();
				for (int i = 0; i < size; i++) {
					sb.append(defaultChar);
				}
				sb.append(base);
				return rightstring(sb.toString(), size);
			} else {
				sb = new StringBuffer(base);
				for (int i = 0; i < size; i++) {
					sb.append(defaultChar);
				}
				return leftstring(sb.toString(), size);
			}
		}
	}

	/**
	 * 거래고유번호 (10자리)
	 */
	public static String getTransSEQ() throws Exception{

		SimpleDateFormat sdf = new SimpleDateFormat("ddHHmmssSSS");
		return setSize(sdf.format(new Date()), 10, "0", true);
	}

	/**
	 * 전문추적번호 (6자리)
	 */
	public static String getTraceSEQ() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return setSize(sdf.format(new Date()), 6, "0", true);
	}

	/**
	 * 패킷의 총 size를 구한다.
	 */
	public static int totalSize(int[] packet) throws Exception{
		int total = 0;
		for (int i = 0; i < packet.length; i++) {
			total += packet[i];
		}
		return total;
	}



	public static String setDbInjection(String paramData)throws Exception{
		int InjectCnt = 0;
		if (paramData != null){ 
			String temp_paramData = paramData.toUpperCase();

			String data_val [] = {"<", ">", "+or", "%", "'", "\""};
			for(InjectCnt = 0; InjectCnt < data_val.length; InjectCnt++) {
				if(temp_paramData.indexOf(data_val[InjectCnt]) > -1) {
					paramData = paramData.substring(0, temp_paramData.indexOf(data_val[InjectCnt])) + paramData.substring((temp_paramData.indexOf(data_val[InjectCnt])+data_val[InjectCnt].length()), temp_paramData.length());
					temp_paramData = paramData;
				}
				if(temp_paramData.toUpperCase().indexOf(data_val[InjectCnt]) > -1){
					paramData = setDbInjection(temp_paramData);
				}
			}
		}
		return paramData;
	}
	
	/**
	 * 길이가 넘어갈 경우 ... 을 붙여 준다
	 */
	public static String dotDotDot(String str, int length){
		String resStr = "";
		int cnt = 0;
		str = str.replaceAll("\n", "@&");
		
		for (int i = 0; i < str.length(); i++) {
			String subStr = str.substring(i, i+1);
			if(str.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
				// 한글이 포함된 문자열
				cnt = cnt + 2;
				resStr = resStr + subStr;
			} else {
				// 한글이 포함되지 않은 문자열
				cnt = cnt + 1;
				resStr = resStr + subStr;
			}
			
			if(cnt > length){
				resStr = resStr + "...";
				break;
			}
		}
		resStr = resStr.replaceAll("@&", "\n");
		return resStr;
	}
}
