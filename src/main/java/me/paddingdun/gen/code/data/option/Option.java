/**
 * 
 */
package me.paddingdun.gen.code.data.option;

/**
 * 
 * @author paddingdun
 *
 * @param <T>
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Option<?> other = (Option<?>) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return title;
	}
	
	
}
