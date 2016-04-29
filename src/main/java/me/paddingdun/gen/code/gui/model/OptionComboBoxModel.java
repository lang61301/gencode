/**
 * 
 */
package me.paddingdun.gen.code.gui.model;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import me.paddingdun.gen.code.data.option.Option;

/**
 * 
 * @author paddingdun
 *
 * @param <T>
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class OptionComboBoxModel<T> extends DefaultComboBoxModel<Option<T>> {
	

	public OptionComboBoxModel() {
		super();
	}
	/**
	 * @param v
	 */
	public OptionComboBoxModel(Vector<Option<T>> v) {
		super(v);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setValue(T value){
		int size = this.getSize();
		for (int i = 0; i < size; i++) {
			Option<T> tmp = this.getElementAt(i);
			if(tmp.getValue().equals(value)){
				this.setSelectedItem(tmp);
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getValue(){
		Object o = this.getSelectedItem();
		if(o != null){
			Option<T> tmp = (Option<T>)o;
			return tmp.getValue();
		}else{
			return null;
		}
	}
}
