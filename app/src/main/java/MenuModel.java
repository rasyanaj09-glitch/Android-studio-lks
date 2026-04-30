

import com.google.gson.annotations.SerializedName;

public class MenuModel {

    // @SerializedName harus sama persis dengan nama kolom di database kamu
    @SerializedName("Id")
    private int id;

    @SerializedName("CategoryId")
    private int categoryId;

    @SerializedName("Name")
    private String name;

    @SerializedName("Description")
    private String description;

    @SerializedName("Price")
    private String price;

    @SerializedName("Stock")
    private int stock;

    @SerializedName("ImageUrl")
    private String imageUrl;

    // Getter (Fungsi untuk mengambil data)
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
}
