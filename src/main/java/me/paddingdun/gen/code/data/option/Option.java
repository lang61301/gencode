/**
 * 
 */
package me.paddingdun.gen.code.data.option;

/**
 * @author paddingdun
 *
 * 2015年12月22日
 */
public class Option<T> {
	
	public Option(){
		
	}

	/**
	 * @param title
	 * @param value
	 */
	public Option(String title, T value) {
		super();
		this.title = title;
		this.value = value;
	}

	private String title;
	
	private T value;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Option other = (Option) obj;
//		if (title == null) {
//			if (other.title != null)
//				return false;
//		} else if (!title.equals(other.title))
//			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return title;
	}
	
	
}
