package MobilePhone.Module_1_BasicClass;

/**
 * 上网套餐类 
 * 特征：上网流量、每月资费 行为：显示所有套餐信息;
 */
public class DataPlan {
    private int dataUse; // 上网流量
    private int dataMoBill; // 流量月账单金额

    /**
     * @return the dataUse
     */
    public int getDataUse() {
        return dataUse;
    }

    /**
     * @param dataUse the dataUse to set
     */
    public void setDataUse(int dataUse) {
        this.dataUse = dataUse;
    }

    /**
     * @return the moBill
     */
    public int getMoBill() {
        return moBill;
    }

    /**
     * @param moBill the moBill to set
     */
    public void setMoBill(int moBill) {
        this.moBill = moBill;
    }

    public void showDataInfo() {
        System.out.printf("网络用量：%d MB\n", dataUse);
        System.out.printf("网络费用：%d 元\n", dataMoBill);
    }

}
