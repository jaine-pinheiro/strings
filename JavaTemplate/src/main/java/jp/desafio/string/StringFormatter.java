package jp.desafio.string;

public abstract class StringFormatter {

    private Integer limit;
    private boolean justify;
    
    public StringFormatter() {
        this.setLimit(40);
    }

    public abstract StringBuilder format(String text);

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public boolean isJustify() {
		return justify;
	}

	public void setJustify(boolean justify) {
		this.justify = justify;
	}
}
