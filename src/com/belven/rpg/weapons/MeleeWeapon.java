package com.belven.rpg.weapons;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.ItemData;
import com.belven.rpg.items.ItemType;
import com.belven.rpg.items.RowData;

public class MeleeWeapon extends RowData {
	public static ArrayList<MeleeWeapon> Data = new ArrayList<>();
	public static String TableName = "\\MeleeWeaponData.csv";

	public static TableDefinition Table_Definition = new TableDefinition("MeleeWeapon", "MeleeWeapon", new TableColumn("ID", ValueType.Integer), new TableColumn("WeaponID", ValueType.Integer),
			new TableColumn("CleaveRadius", ValueType.Float));

	int weaponID;
	float cleaveRadius;

	public MeleeWeapon() {
		super(TableName);
		if (Data.size() > 0) {
			ID = GetLastID() + 1;
		}

		Data.add(this);
	}

	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(weaponID));
		rowData.add(GetString(cleaveRadius));
		return rowData.toArray(new String[0]);
	}

	public static MeleeWeapon CreateMeleeWeapon(ItemData itemData, WeaponData data, float inCleaveRadius) {
		itemData.type = ItemType.Weapon;
		Item i = Item.CreateItem(itemData);

		data.itemID = i.ID;
		data.type = WeaponType.Melee;
		Weapon w = Weapon.CreateWeapon(data);

		MeleeWeapon mw = new MeleeWeapon();
		mw.cleaveRadius = inCleaveRadius;
		mw.weaponID = w.ID;
		return mw;
	}

	@Override
	public int GetLastID() {
		return Data.get(Data.size() - 1).ID;
	}
}
