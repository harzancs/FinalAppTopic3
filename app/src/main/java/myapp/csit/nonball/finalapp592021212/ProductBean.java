package myapp.csit.nonball.finalapp592021212;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductBean implements Parcelable {

    /**
     * id : 1
     * id_product : csit01
     * name : IPhoneXL
     * detail : Black Camera 28MP
     * price : 30000
     * image_url : https://store.ais.co.th/media/catalog/product/i/p/iphone7plus-black-pureangles_2_4.jpg
     */

    private String id;
    private String name;
    private String major;
    private String grad;

    public static final String BASE_URL="http://10.112.2.110/final_sql/";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_product() {
        return name;
    }

    public void setId_product(String id_product) {
        this.name = name;
    }

    public String getName() {
        return major;
    }

    public void setName(String name) {
        this.major = major;
    }

    public String getDetail() {
        return grad;
    }

    public void setDetail(String detail) {
        this.grad = grad;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.major);
        dest.writeString(this.grad);
    }

    public ProductBean() {
    }

    protected ProductBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.major = in.readString();
        this.grad = in.readString();
    }

    public static final Creator<ProductBean> CREATOR = new Creator<ProductBean>() {
        @Override
        public ProductBean createFromParcel(Parcel source) {
            return new ProductBean(source);
        }

        @Override
        public ProductBean[] newArray(int size) {
            return new ProductBean[size];
        }
    };
}
