package level_01.module_02.class_05;

public enum DirectionEnum {
    UP("Go to up"),DOWN("Go to down"),LEFT("Go to left"),RIGHT("Go to left");

    private final String desc;

    private DirectionEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

	public static DirectionEnum[] values() {
		return null;
	}
}
