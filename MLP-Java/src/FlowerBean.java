public class FlowerBean {
    private double SLength;
    private double SWidth;
    private double PLength;
    private double PWidth;
    private String FlowerName;

    public double getSLength() {
        return SLength;
    }

    public void setSLength(double SLength) {
        this.SLength = SLength;
    }

    public double getSWidth() {
        return SWidth;
    }

    public void setSWidth(double SWidth) {
        this.SWidth = SWidth;
    }

    public double getPLength() {
        return PLength;
    }

    public void setPLength(double PLength) {
        this.PLength = PLength;
    }

    public double getPWidth() {
        return PWidth;
    }

    public void setPWidth(double PWidth) {
        this.PWidth = PWidth;
    }

    public String getFlowerName() {
        return FlowerName;
    }

    public void setFlowerName(String flowerName) {
        FlowerName = flowerName;
    }

    @Override
    public String toString() {
        return "FlowerBean{" +
                "SLength=" + SLength +
                ", SWidth=" + SWidth +
                ", PLength=" + PLength +
                ", PWidth=" + PWidth +
                ", FlowerName='" + FlowerName + '\'' +
                '}';
    }
}