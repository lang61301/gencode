/**
 * 
 */
package me.paddingdun.gen.code.user;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class AdapterCDATA extends XmlAdapter<String, byte[]> {
	
//	private static final Pattern XML_CHARS = Pattern.compile("[&<>]", Pattern.MULTILINE);
	private static final BASE64Encoder encoder = new BASE64Encoder();
	private static final BASE64Decoder decoder = new BASE64Decoder();

	@Override
	public byte[] unmarshal(String v) throws Exception {
		String tmp1 = v.substring("<![CDATA[".length());
		String tmp2 = tmp1.substring(0, tmp1.length()-"]]>".length());
		return decoder.decodeBuffer(tmp2);
	}

	@Override
	public String marshal(byte[] v) throws Exception {
		String text = encoder.encode(v);
		
		return "<![CDATA["+ text + "]]>";
	}
}
