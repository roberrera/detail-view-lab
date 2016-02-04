package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView mItemName, mItemDesc, mItemPrice, mItemType, mItemOrganic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra("id", -1);

        mItemName = (TextView)findViewById(R.id.item_name);
        mItemDesc = (TextView)findViewById(R.id.item_desc);
        mItemPrice = (TextView)findViewById(R.id.item_price);
        mItemType = (TextView)findViewById(R.id.item_type);


        String name = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemNameById(id);
        mItemName.setText("Item: " + name);

        String description = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemDescById(id);
        mItemDesc.setText("Description: " + description);

        String price = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemPriceById(id);
        mItemPrice.setText("Price: "+price);

        String type = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemTypeById(id);
        mItemType.setText("Item type: "+type);

    }
}
