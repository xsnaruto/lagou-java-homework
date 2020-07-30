/**
 * GetMax
 */
public class GetMax {
    int a;
    int b;

    void setAB(int aa, int bb) {
        a = aa;
        b = bb;
    }

    int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else if (b > a) {
            return b;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        GetMax st = new GetMax();
        st.a = 6;
        st.b = 9;

        st.setAB(15, 65);

        System.out.println("a 的数值是：" + st.a);
        System.out.println("b 的数值是：" + st.b);

        int theMX = st.getMax(st.a, st.b);
        System.out.println("最大数是：" + theMX);
    }
}