package com.belven.rpg.items;

import java.util.ArrayList;

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
