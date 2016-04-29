/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.TextEdit;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class ContentFormatHelper {

	/**
	 * 格式化java文件内容;
	 * 
	 * @param raw
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String formatJava(String source) {
		try {
			Map options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();

			// initialize the compiler settings to be able to format 1.5 code
			options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_5);
			options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_5);
			options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_5);

			// change the option to wrap each enum constant on a new line
			// options.put(
			// DefaultCodeFormatterConstants.FORMATTER_ALIGNMENT_FOR_ENUM_CONSTANTS,
			// DefaultCodeFormatterConstants.createAlignmentValue(
			// true,
			// DefaultCodeFormatterConstants.WRAP_ONE_PER_LINE,
			// DefaultCodeFormatterConstants.INDENT_ON_COLUMN));

			// instantiate the default code formatter with the given options
			final CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(options);

			// retrieve the source to format
			final TextEdit edit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, // format
																							// a
																							// compilation
																							// unit
					source, // source to format
					0, // starting position
					source.length(), // length
					0, // initial indentation
					System.getProperty("line.separator") // line separator
			);

			IDocument document = new Document(source);
			edit.apply(document);

			// display the formatted string on the System out
			
			String af = document.get();
			return af;
		} catch (Exception e) {
			e.printStackTrace();
			//说明待处理的java文本,有格式问题,返回未处理文本;
			return source;
		}
	}

}
