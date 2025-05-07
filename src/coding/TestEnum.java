package coding;

public enum TestEnum {
	PERSONAL("personal"), BUSINESS("business");

	private String name;

	TestEnum(String name) {
		this.name = name;
	}

	public boolean equalTo(String name) {
		return this.name.equalsIgnoreCase(name);
	}

}
