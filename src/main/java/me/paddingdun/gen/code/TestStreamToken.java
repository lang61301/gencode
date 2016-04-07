/**
 * 
 */
package me.paddingdun.gen.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author paddingdun
 *
 *         2015年12月2日
 */
public class TestStreamToken {
	public static void main(String[] args) throws Exception {
//		StringReader sr = new StringReader("ssssssssddddddda");
//		BufferedReader bb = new BufferedReader(sr);
		
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in, "utf-8")));
		st.eolIsSignificant(true);
		st.ordinaryChars('/', '/');
		st.ordinaryChars('0', '9');
		st.ordinaryChars('.', '.');
		st.ordinaryChars('-', '-');
		
		st.wordChars('.', '.');
		st.wordChars('0', '9');
		st.wordChars('-', '-');
		st.wordChars('/', '/');
		List<String> list = new ArrayList<String>(); 
		System.out.println("wait...");
		while (true) {
			int ttype = st.nextToken();
			System.out.println("=========");
			if ((ttype == StreamTokenizer.TT_WORD) ) {
				String s = st.sval;
				System.out.println("stirng:" + s);
				if("quit".equalsIgnoreCase(s))break;
				 list.add (s );

			}else if((ttype == StreamTokenizer.TT_NUMBER) ) {
				Double s = st.nval;
				System.out.println("number:" + s);
				 list.add (s +"" );

			} else if (ttype == StreamTokenizer.TT_EOF) {
				break;

			} else if (ttype == StreamTokenizer.TT_EOL) {
				break;

			}else{
				System.out.println("unknow ttype:" +ttype);
			}
		}
		System.out.println("---------------------------");
		for(String s1 : list){
			System.out.println(s1);
		}

	}

}
