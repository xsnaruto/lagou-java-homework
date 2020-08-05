package level_01.module_02.class_04;

public class Rect extends Shape {
    private int len;
    private int wid;

    public Rect() {
    }

    public Rect(int x, int y, int len, int wid) {
        super(x, y);
        setLen(len);
        setWid(wid);
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        if (len > 0) {
            this.len = len;
        } else {
            System.out.println("长度不合理。");
        }
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        if (wid > 0) {
            this.wid = wid;
        } else {
            System.out.println("宽度不合理。");
        }
    }

    @Override
    public void show() {
        super.show();
        System.out.println("L = " + getLen() + ", W = " + getWid());
    }

    // 自定义静态方法
    public static void test(){
        System.out.println("Rect 类中的静态方法");
    }
}
