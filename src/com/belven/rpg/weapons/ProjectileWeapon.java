package com.belven.rpg.weapons;

import java.util.ArrayList;

import com.belven.rpg.items.Item;
import com.belven.rpg.items.ItemData;
import com.belven.rpg.items.ItemType;
import com.belven.rpg.items.RowData;

public class ProjectileWeapon extends RowData {
	public static ArrayList<ProjectileWeapon> ProjectileWeapons = new ArrayList<>();
	public static String ProjectileTable = "\\ProjectileWeaponData.csv";

	ProjectileWeaponData data;

	public ProjectileWeapon() {
		super(ProjectileTable);
		if (ProjectileWeapons.size() > 0) {
			ID = GetLastID() + 1;
		}

		ProjectileWeapons.add(this);
	}

	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(data.rangedWeaponID));
		rowData.add(data.projectile);
		rowData.add(GetString(data.magazineSize));
		rowData.add(GetString(data.reloadSpeed));
		rowData.add(GetString(data.bulletVelocity));
		return rowData.toArray(new String[0]);
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
		return ProjectileWeapons.get(ProjectileWeapons.size() - 1).ID;
	}

}
