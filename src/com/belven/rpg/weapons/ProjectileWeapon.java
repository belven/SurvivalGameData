package com.belven.rpg.weapons;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.ItemData;
import com.belven.rpg.items.ItemType;
import com.belven.rpg.items.RowData;

public class ProjectileWeapon extends RowData {
	public static ArrayList<ProjectileWeapon> Data = new ArrayList<>();
	public static String TableName = "\\ProjectileWeaponData.csv";

	public static TableDefinition Table_Definition = new TableDefinition("ProjectileWeapon", "ProjectileWeapon", new TableColumn("ID", ValueType.Integer),
			new TableColumn("RangedWeaponID", ValueType.Integer), new TableColumn("AmmoType", ValueType.Integer), new TableColumn("MagazineSize", ValueType.Integer),
			new TableColumn("ReloadSpeed", ValueType.Float), new TableColumn("BulletVelocity", ValueType.Integer));

	ProjectileWeaponData data;

	public ProjectileWeapon() {
		super(TableName);
		IncrementID(Data);
		Data.add(this);
	}

	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(data.rangedWeaponID));
		rowData.add(GetString(GetItemByName(data.ammoType)));
		rowData.add(GetString(data.magazineSize));
		rowData.add(GetString(data.reloadSpeed));
		rowData.add(GetString(data.bulletVelocity));
		return rowData.toArray(new String[0]);
	}

	public int GetItemByName(String name) {
		for (Item i : Item.Data) {
			if (i.GetData().name.equals(name))
				return i.ID;
		}

		return -1;
	}

	public static ProjectileWeapon CreateProjectileWeapon(ItemData itemData, WeaponData data, float accuracy, ProjectileWeaponData inProjectileData) {
		itemData.type = ItemType.Weapon;
		Item i = Item.CreateItem(itemData);

		data.itemID = i.ID;
		data.type = WeaponType.Projectile;
		Weapon w = Weapon.CreateWeapon(data);
		RangedWeapon rw = RangedWeapon.CreateRangedWeapon(w.ID, accuracy);

		inProjectileData.rangedWeaponID = rw.ID;
		ProjectileWeapon pw = new ProjectileWeapon();
		pw.data = inProjectileData;
		return pw;
	}

	@Override
	public int GetLastID() {
		return GetLastID(Data);
	}

}
